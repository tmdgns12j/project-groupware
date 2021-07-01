package controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import model.Letter;
import model.MemberL;
import model.Notice;
import model.Schedule;
import service.CalendarDao;
import service.LetterDaoMybatis;

@Controller
@RequestMapping("/letter/")
public class LetterController {

	@Autowired
	LetterDaoMybatis dao;
	@Autowired
	CalendarDao cdao;

	@RequestMapping("letter")
	public String letter(Model m) throws Throwable {
		System.out.println("letter 입니다");

		List<Letter> listletter = dao.listletter(); // 화면에 출력된 게시물 데이터
		m.addAttribute("num", listletter.size());// letter.jsp들의 num, 리스트의 크기
		m.addAttribute("list", listletter);// letter.jsp들의 list

		return "letter/letter";
	}

	@RequestMapping("letterwriteForm")
	public String letterwriteForm(String name, Letter letter) throws Throwable {
		System.out.println("letterForm");
		if (name == null) {
			letter.setSTF_RCV_ID("");
		} else {
			letter.setSTF_RCV_ID(name);
		}
		return "letter/writeForm";
	}

	@RequestMapping("letterloginForm")
	public String letterloginForm() throws Throwable {
		return "letter/loginForm";
	}

	@RequestMapping("letterlogin")
	public String letterlogin(String STF_ID, String STF_PW, HttpSession session, Model m) throws Throwable {
		/*
		 * 1. id, pass 파라미터 저장 2. db에서 id 에 해당하는 데이터를 읽어서 Member 전달받기 3. 결과분석 Member객체가
		 * null 인경우 : 아이디를 확인하세요 메세지 출력. --->loginForm.jsp 페이지 이동 Member객체가 null이 아닌 경우
		 * : 화면에서 입력된 비밀번호와 db 비밀번호 검증 같은경우 : 로그인 성공. -----> main.jsp 페이지 이동 다른 경우 :
		 * 비밀번호 확인하세요 ----> loginForm.jsp로 페이지 이동
		 */

		//		String id = request.getParameter("STF_ID"); // 입력된 id값
		//		String pass = request.getParameter("STF_PW"); // 입력된 pass 값
		// mem : db에 저장된 회원정보 저장
		System.out.println(STF_ID);
		MemberL mem = dao.letterselectOne(STF_ID);
		String msg = "이이디를 확인해주세요";
		String url = "main";
		if (mem != null) {
			System.out.println("널 아님");
			if (STF_PW.equals(mem.getSTF_PW())) {
				System.out.println("비밀번호 매칭 확인");
				session.setAttribute("login", STF_ID);
				msg = mem.getSTF_NM() + "님이 로그인 하셨습니다.";
				url = "main";
			} else {
				msg = "비밀번호를 확인 하세요";
				url = "main";
			}
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		return "letter/alert";
	}

	@RequestMapping("main")
	public String main(Model m, HttpSession session) throws Throwable {
		/*
		 * 1. 로그인 후에 보여지는 페이지. => 로그인 여부 확인 => 로그인상태가 아닌 경우, loginForm.jsp로 페이지 이동하기
		 */
		String login = (String) session.getAttribute("login");

		if (login == null || login.trim().equals("")) {
			return "letter/loginForm";
		} else {
			m.addAttribute("login", login);
			return "letter/main";
		}
	}

	@RequestMapping("letterwrite")
	public String letterwrite(MultipartHttpServletRequest request, Letter letter, Model m) throws Throwable {

		String uploadpath = request.getServletContext().getRealPath("/upfile");
		MultipartFile multiFile = request.getFile("uploadfile");//파일을 위한 멀티파트
		if (!multiFile.isEmpty()) {
			File file = new File(uploadpath, multiFile.getOriginalFilename());
			try {
				multiFile.transferTo(file);
				letter.setEML_PL_NM(multiFile.getOriginalFilename());//파일이름 설정
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			letter.setEML_PL_NM("");
		}

		System.out.println("dao전");

		String msg = "fail";
		String url = "writeForm";
		System.out.println("if전");
		if (dao.letterinsert(letter)) {
			System.out.println("if후");
			msg = "게시물 등록 성공";
			url = "letter";
		}
		System.out.println("if후");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("letterdelete")
	public String letterdelete(Model m) throws Throwable {
		/*
		 * 1. num,pass 파라미터를 변수에 저장. 2. 입력된 비밀번호와 db
		 * 비밀번호 검증 틀린경우 : 비밀번호 오류 메시지 출력, deleteForm.jsp 페이지 이동 3. 게시물 삭제. 삭제 성공 : 삭제 성공
		 * 메시지 출력, list.jsp 페이지 이동 삭제 실패 : 삭제 실패 메시지 출력, info.jsp 페이지 이동
		 */

		/* String num = request.getParameter("STF_SQ"); */ // 입력된 id값
		Letter letter = new Letter();

		// board.getPass() : db에 저장된 비밀번호

		String msg = "삭제완료";
		String url = "letter";
		System.out.println("if밖");
		if (dao.letterdelete(letter)) {
			System.out.println("if안");
			msg = "게시글을 성공적으로 삭제하였습니다.";
			url = "letter";
		} else {
			msg = "게시글을 삭제하는데 실패하였습니다!";

		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}

	@RequestMapping("delete")//체크된 쪽지 삭제(전체지우기)
	public String delete(Model m, String[] RowCheck, HttpSession session) throws Throwable {
		System.out.println(Arrays.asList(RowCheck));//체크된거 확인용
		System.out.println(RowCheck[0]);
		int size = RowCheck.length;//체크된 항목 개수
		System.out.println(size);//개수 확인용
		String msg = "삭제완료";
		String url = "letter";
		for (int i = 0; i < size; i++) {
			if (dao.delete(RowCheck[i])) {//체크된것 삭제
				System.out.println("if밖");
				msg = "게시글을 성공적으로 삭제하였습니다.";
				url = "letter";
			}
			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}

	@RequestMapping("delete1")//체크로 선택삭제
	public String delete1(Model m, String[] RowCheck1) throws Throwable {
		System.out.println(Arrays.asList(RowCheck1));
		System.out.println(RowCheck1[0]);
		int size = RowCheck1.length;
		System.out.println(size);
		String msg = "삭제완료";
		String url = "letter";
		for (int i = 0; i < size; i++) {
			if (dao.delete1(RowCheck1[i])) {
				System.out.println("if밖");
				msg = "게시글을 성공적으로 삭제하였습니다.";
				url = "letter";
			}
			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}

	@RequestMapping("logout")
	public String logout(Model m, HttpSession session) throws Throwable {

		/*
		 * 1. session에 등록된 로그인 정보 제거 2. id님 로그아웃되었습니다. 메세지 출력 후 loginForm.jsp로 페이지 이동하기
		 */

		String login = (String) session.getAttribute("login");
		session.invalidate();
		String msg = login + "님 로그아웃되었습니다.";
		m.addAttribute("msg", msg);
		m.addAttribute("url", "main");
		return "alert";
	}

	/*---------------------------------------------------------*/
	@RequestMapping("info")//0이아니면 읽음으로 처리될것
	public String info(Model m, int num) {
		/*
		 * 1. num 파라미터를 이용하여 db에 해당 게시물 조회 selectOne(num); 2. 조회수 증가시키기. readcnt+1 new
		 * 3. 1번에서 조회한 게시물데이터를 화면에 출력하기
		 */
		/* eml_sq 편지번호 number */
		// myletter에서 num가져옴 1
		// 파라미터값읽기
		Letter letter = dao.selectOne(num);
		dao.readcntadd(num); // 조회건수증가
		m.addAttribute("letter", letter);
		m.addAttribute("num", num);// letterinfo로 num넘겨줌 if l.eml_sq = num
		return "letter/letterInfo";
	}

	@RequestMapping("joinForm")
	public String joinForm() {
		System.out.println("joinForm");
		return "letter/joinForm";
	}

	@RequestMapping("join")
	public String join(MemberL mem, Model m) {
		String msg = "";
		String url = "";
		if (dao.insert(mem)) { // 가입성공
			dao.cmtinsert(mem);
			msg = mem.getSTF_NM() + "님의 가입이 완료 되었습니다";
			url = "memlist";
		} else {
			msg = "회원 가입이 실패 되었습니다";
			url = "";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("memlist")//회원리스트
	public String memlist(Model m) {
		System.out.println("memlist 입니다");

		List<MemberL> memberlist = dao.memlist();
		m.addAttribute("num", memberlist.size());
		m.addAttribute("list", memberlist);
		System.out.println(memberlist);
		return "letter/memlist";
	}

	@RequestMapping("memdelete")//회원 삭제
	public String memdelete(Model m, String id) {
		System.out.println("memdelete");

		String msg = "실패";
		String url = "memlist";
		if (dao.memdelete(id)) {
			dao.cmtdelete(id);
			msg = "성공";
			url = "memlist";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("memupdateForm")//회원정보 수정폼
	public String memupdateForm(Model m, String id) {
		System.out.println("updateForm");
		MemberL mem = dao.letterselectOne(id);
		m.addAttribute("mem", mem);
		return "letter/memupdateForm";
	}

	@RequestMapping("memupdate")//회원정보 수정
	public String memupdate(Model m, MemberL mem) {
		MemberL dbMember = dao.letterselectOne(mem.getSTF_ID());
		String msg = "수정실패";
		String url = "memupdateForm?id=" + mem.getSTF_ID();
		if (mem.getSTF_ID().equals(dbMember.getSTF_ID())) {
			if (dao.memupdate(mem)) {
				msg = mem.getSTF_ID() + "의 정보가 수정되었습니다.";
				url = "memlist";
			}
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}

	@RequestMapping("scheduleList")//사내 일정목록
	public String scheduleList(Model m) {
		System.out.println("schedulelist입니다");

		List<Schedule> scheduleList = dao.scheduleList();
		m.addAttribute("num", scheduleList.size());
		m.addAttribute("list", scheduleList);
		System.out.println(scheduleList);
		return "letter/scheduleList";
	}

	@RequestMapping("scheduleDelete")//사내일정 삭제
	public String scheduleDelete(Model m, String id) {
		System.out.println("scheduleDelete");

		String msg = "실패";
		String url = "scheduleList";
		if (dao.scheduleDelete(id)) {
			msg = "성공";
			url = "scheduleList";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("scheduleUpdateForm")//사내일정 수정 폼
	public String scheduleUpdateForm(Model m, String id) {
		Schedule schedule = dao.scheduleselectOne(id);
		System.out.println(schedule.getSchedule_sq());
		m.addAttribute("schedule", schedule);
		return "letter/scheduleUpdateForm";
	}

	@RequestMapping("scheduleForm")
	public String ScheduleForm() {
		return "letter/scheduleForm";
	}

	@RequestMapping("addSchedule")//일정 추가
	public String addSchedule(Schedule schedule, Model m) {
		String msg = "fail";
		String url = "scheduleForm";
		System.out.println("if전");
		if (dao.addSchedule(schedule)) {
			System.out.println("if후");
			msg = "게시물 등록 성공";
			url = "scheduleList";
		}
		System.out.println("if후");
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("scheduleUpdate")//사내일정 수정
	public String scheduleUpdate(HttpSession session, Schedule schedule, Model m) throws Throwable {
		String msg = "fail";
		String url = "scheduleList";
		if (dao.scheduleUpdate(schedule)) {
			msg = "게시물 수정 완료";
			url = "scheduleList";
		} else {
			msg = "게시물 수정 실패";
		}
		System.out.println(schedule.getSchedule_sq());
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}
}

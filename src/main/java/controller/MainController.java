package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import data.DateData;
import model.Letter;
import model.MemberL;
import model.Notice;
import model.Schedule;
import service.CalendarDao;
import service.LetterDaoMybatis;
import service.NoticeDaoMybatis;

@Controller
@RequestMapping("/main/")
public class MainController {
	@Autowired
	LetterDaoMybatis dao;
	@Autowired
	CalendarDao Cdao;
	@Autowired
	NoticeDaoMybatis Ndao;
	@RequestMapping("loginForm")
	public String letterloginForm() throws Throwable { 
		return "letter/loginForm"; 
	}
	
	@RequestMapping("login")
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
		String url = "loginForm";
		if (mem != null) {
			System.out.println("널 아님");
			if (STF_PW.equals(mem.getSTF_PW())) {
				System.out.println("비밀번호 매칭 확인");
				session.setAttribute("login", STF_ID);
				msg = mem.getSTF_NM() + "님이 로그인 하셨습니다.";
				url = "main";
			} else {
				msg = "비밀번호를 확인 하세요";
				url = "loginForm";
			}
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		return "letter/alert";
	}
	
	@RequestMapping("main")
	public String main(Model m, HttpSession session, HttpServletRequest request, DateData dateData, String id,String page) {
		String login = (String) session.getAttribute("login");

		if (login == null || login.trim().equals("")) {
			return "letter/loginForm";
			
		} else {
			m.addAttribute("login", login);
			
			/* -------------달력시작------------------------ */
			System.out.println("달력들어옴");
			Calendar cal = Calendar.getInstance();
			DateData calendarData;
			// 寃 깋 궇吏
			if (dateData.getDate().equals("") && dateData.getMonth().equals("")) {
				dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
						String.valueOf(cal.get(Calendar.DATE)), null);
			}
			// 寃 깋 궇吏 end
			System.out.println("1");
			Map<String, Integer> today_info = dateData.today_info(dateData);
			System.out.println("2");
			List<DateData> dateList = new ArrayList<DateData>();
			// 떎吏덉쟻 씤 떖 젰 뜲 씠 꽣 由ъ뒪 듃 뿉 뜲 씠 꽣 궫 엯 떆 옉.
			// 씪 떒 떆 옉 씤 뜳 뒪源뚯 븘臾닿쾬 룄 뾾 뒗 뜲 씠 꽣 궫 엯
			for (int i = 1; i < today_info.get("start"); i++) {
				calendarData = new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
			
			// 궇吏 궫 엯
			for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
				if (i == today_info.get("today")) {
					calendarData = new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()),
							String.valueOf(i), "today");
				} else {
					calendarData = new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()),
							String.valueOf(i), "normal_date");
				}
				dateList.add(calendarData);
			}
			int index = 7 - dateList.size() % 7;

			if (dateList.size() % 7 != 0) {

				for (int i = 0; i < index; i++) {
					calendarData = new DateData(null, null, null, null);
					dateList.add(calendarData);
				}
			}
			id = request.getParameter("id");
			List<MemberL> birthM = Cdao.selectBM();
			List<MemberL> birthD = Cdao.selectBD();
			List<MemberL> birthName = Cdao.selectName();
			int search_month=today_info.get("search_month");
			System.out.println(today_info.get("search_month"));
			System.out.println(birthM);
			System.out.println(birthD);
			/*
			 * if (Integer.parseInt(birthM) < 10) { System.out.println("if안"); birthM =
			 * birthM.replace("0", ""); }
			 */
			m.addAttribute("id", id);// 파라미터 id를 "id" 이름으로 calendar.jsp ${id}에 전달
			m.addAttribute("birthM", birthM);// 생일의 달 01 02 03 ~ 11 12, dateList는 1 2 3 4 ~ 11 12
			m.addAttribute("birthD", birthD);// 생일의 일 calender.jsp로 보냄
			m.addAttribute("birthName", birthName);// 생일인 사람이름 calender.jsp로 보냄
			m.addAttribute("search_month",search_month);
			m.addAttribute("dateList", dateList);
			m.addAttribute("today_info", today_info);
			/* -----------------쪽지함 시작--------------------- */
			System.out.println("letter 입니다");

			List<Letter> listletter = dao.listletter(); // 화면에 출력된 게시물 데이터
			m.addAttribute("num", listletter.size());//letter.jsp들의 num, 리스트의 크기
			m.addAttribute("list", listletter);//letter.jsp들의 list
			/* -----------------게시판 시작--------------------- */
			System.out.println("list 입니다");
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(page);
			} catch (NumberFormatException e) {
			}

			int limit = 10; // 한페이지에 출력할 게시물 건수
			
			int noticecount = Ndao.noticeCount();// 등록된 전체 게시물의 건수

			List<Notice> nlist = Ndao.list(pageNum, limit, noticecount); // 화면에 출력된 게시물 데이터
			// 13 ---> boardcount/limit : 4 + 1
			int maxpage = (int) (noticecount / limit) + (noticecount % limit == 0 ? 0 : 1);
			int bottomLine = 3;
			// page 1,2,3 : 1, 4,5,6: 2
			int startpage = 1 + (pageNum - 1) / bottomLine * bottomLine;
			int endpage = startpage + bottomLine - 1;
			if (endpage > maxpage)
				endpage = maxpage;
			int noticenum = noticecount - (pageNum - 1) * limit;

			m.addAttribute("noticecount", noticecount);
			m.addAttribute("nlist", nlist);
			m.addAttribute("noticenum", noticenum);
			m.addAttribute("startpage", startpage);
			m.addAttribute("bottomLine", bottomLine);
			m.addAttribute("endpage", endpage);
			m.addAttribute("maxpage", maxpage);
			m.addAttribute("pageNum", pageNum);
			/* 일정 */
			List<Schedule> scheduleList = dao.scheduleList();
			m.addAttribute("schedulenum", scheduleList.size());
			m.addAttribute("schedulelist", scheduleList);
			System.out.println(scheduleList);
			
			return "letter/main";
		}
	}
	@RequestMapping("logout")
	public String logout(Model m, HttpSession session ) throws Throwable {

		String login = (String) session.getAttribute("login");
		session.invalidate();
		String msg = login + "님 로그아웃되었습니다.";
		m.addAttribute("msg", msg);
		m.addAttribute("url", "loginForm");
		return "alert";
	}
}

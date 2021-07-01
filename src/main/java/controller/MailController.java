package controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import model.Mail;
import model.Mail2;
import model.MemberL;
import service.MailDaoMybatis;

@Controller
@RequestMapping("/mail/")
public class MailController {

	@Autowired
	MailDaoMybatis dao;

	@RequestMapping("mail")
	public String mail(Model m) throws Throwable {
		System.out.println("mail 입니다");

		List<Mail> listmail = dao.listmail(); // 화면에 출력된 게시물 데이터
		m.addAttribute("num", listmail.size());// mail.jsp들의 num, 리스트의 크기
		m.addAttribute("list", listmail);// mail.jsp들의 list

		return "mail/mail";
	}

	@RequestMapping("mailwriteForm")
	public String mailwriteForm() throws Throwable {
		System.out.println("mailForm");
		return "mail/writeForm";
	}

	@RequestMapping("mailloginForm")
	public String mailloginForm() throws Throwable {
		return "mail/loginForm";
	}

	@RequestMapping("maillogin")
	public String maillogin(String STF_ID, String STF_PW, HttpSession session, Model m) throws Throwable {

		//		String id = request.getParameter("STF_ID"); // 입력된 id값
		//		String pass = request.getParameter("STF_PW"); // 입력된 pass 값
		System.out.println(STF_ID);
		MemberL mem = dao.mailselectOne(STF_ID);
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
		return "mail/alert";
	}

	@RequestMapping("mailwrite")
	public String mailwrite(MultipartHttpServletRequest request, Mail2 mail, Model m) throws Throwable {

		String uploadpath = request.getServletContext().getRealPath("/upfile");
		MultipartFile multiFile = request.getFile("uploadfile");
		if (!multiFile.isEmpty()) {
			File file = new File(uploadpath, multiFile.getOriginalFilename());
			try {
				multiFile.transferTo(file);
				mail.setMAIL_PL_NM(multiFile.getOriginalFilename());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			mail.setMAIL_PL_NM("");
		}

		System.out.println("dao전");

		String msg = "fail";
		String url = "writeForm";
		System.out.println("if전");
		System.out.println("if후");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "mail/alert";
	}

	@RequestMapping("maildelete")
	public String maildelete(Model m) throws Throwable {
		Mail2 mail = new Mail2();
		String msg = "삭제완료";
		String url = "mail";
		System.out.println("if밖");
		if (dao.maildelete(mail)) {
			System.out.println("if안");
			msg = "게시글을 성공적으로 삭제하였습니다.";
			url = "mail";
		} else {
			msg = "게시글을 삭제하는데 실패하였습니다!";

		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "mail/alert";
	}
	//----------------------밑은 쪽지에있는 삭제코드 추후 개발용
	@RequestMapping("delete")
	public String delete(Model m, String[] RowCheck, HttpSession session) throws Throwable {
		System.out.println(Arrays.asList(RowCheck));

		System.out.println("delete들어옴");
		System.out.println("f");

		System.out.println("d");
		System.out.println(RowCheck[0]);
		int size = RowCheck.length;
		System.out.println(size);
		String msg = "삭제완료";
		String url = "mail";
		for (int i = 0; i < size; i++) {

			if (dao.delete(RowCheck[i])) {
				System.out.println("if밖"); 
				msg = "게시글을 성공적으로 삭제하였습니다."; 
				url = "mail"; }

			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "mail/alert";
	}

	@RequestMapping("delete1")
	public String delete1(Model m, String[] RowCheck1) throws Throwable {
		System.out.println("delete들어옴");
		System.out.println(Arrays.asList(RowCheck1));
		System.out.println("f");

		System.out.println("d");
		System.out.println(RowCheck1[0]);
		int size = RowCheck1.length;
		System.out.println(size);
		String msg = "삭제완료";
		String url = "mail";
		for (int i = 0; i < size; i++) {

			if (dao.delete1(RowCheck1[i])) { 
				System.out.println("if밖"); 
				msg =  "게시글을 성공적으로 삭제하였습니다."; 
				url = "mail"; }

			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "mail/alert";
	}
	//--------------------------------------------------------------------------------까지 삭제
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
	@RequestMapping("info")
	public String info(Model m, int num) {
		/*
		 * : 게시물 상세 보기 :board/info?num=41 1. num 파라미터를 이용하여 db에 해당 게시물 조회 Board board =
		 * new BoardDao().selectOne(num); 2. 조회수 증가시키기. readcnt+1 new
		 * BoardDao().readcntadd(num); 3. 1번에서 조회한 게시물데이터를 화면에 출력하기
		 */
		/* eml_sq 편지번호 number */
		// mymail에서 num가져옴 1
		// 파라미터값읽기
		Mail2 mail = dao.selectOne(num);
		dao.readcntadd(num); // 조회건수증가
		m.addAttribute("mail", mail);
		m.addAttribute("num", num);// mailinfo로 num넘겨줌 if l.eml_sq = num
		return "mail/mailInfo";
	}


	@RequestMapping("mailForm")
	public ModelAndView mailForm() {
		ModelAndView mav = new ModelAndView("/mail/mailw");
		return mav;
	}

	@RequestMapping("mailw")//메일쓰기
	public ModelAndView mailw(Mail mail,HttpSession session, Model m) {
		mailSend(mail);
		if(dao.mailinsert(mail)) {
			System.out.println("success");
		}
		ModelAndView mav = new ModelAndView("/mail/mailSuccess");
		return mav;
	}

	//자바메일을 이용하여 메일 전송시 메일 서버에 인증 받기위한 객체
	private final class MyAuthenticator extends Authenticator {
		private String id;//보내는사람시 @naver.com이 디폴트로 붙어짐
		private String pw;
		public MyAuthenticator(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id,pw);
		}
	}
	//mail : 화면에서 입력한 정보 저장
	private void mailSend(Mail mail) {
		//메일 전송을 위한 환경 변수 설정
		MyAuthenticator auth = new MyAuthenticator(mail.getNaverid(),mail.getNaverpw());
		Properties prop = new Properties(); //Map 객체 
		prop.put("mail.smtp.host", "smtp.naver.com"); //메일 전송서버 주소 정보, 
		prop.put("mail.smtp.starttls.enable", "true");//보안 서버
		prop.put("mail.user",mail.getNaverid() );
		prop.put("mail.from",mail.getNaverid()+"@naver.com" );//보내는사람시 @naver.com이 디폴트로 붙어짐
		prop.put("mail.debug","false"); //debug 상태로 실습하기
		prop.put("mail.smtp.auth","true"); //메일 전송시 인증 필수. 
		prop.put("mail.smtp.port","465");
		prop.put("mail.smtp.user",mail.getNaverid() ); //보내는 사람 설정
		prop.put("mail.smtp.socketFactory.port","465");
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback","false");
		Session session = Session.getInstance(prop,auth); //메일 서버에 연결. 준비 완료
		//msg : session을 통해 전송되는 객체
		MimeMessage msg = new MimeMessage(session);  //메일로 전송할 객체 생성
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mail.getNaverid()+"@naver.com"));

			//수신자메일주소
			message.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(mail.getRecipient())); 

			// Subject 
			message.setSubject(mail.getTitle()); //메일 제목을 입력

			// Text
			message.setText(mail.getContents());    //메일 내용을 입력

			// send the message
			Transport.send(message); ////전송
			System.out.println("message sent successfully...");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



}

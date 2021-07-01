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
		System.out.println("mail �Դϴ�");

		List<Mail> listmail = dao.listmail(); // ȭ�鿡 ��µ� �Խù� ������
		m.addAttribute("num", listmail.size());// mail.jsp���� num, ����Ʈ�� ũ��
		m.addAttribute("list", listmail);// mail.jsp���� list

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

		//		String id = request.getParameter("STF_ID"); // �Էµ� id��
		//		String pass = request.getParameter("STF_PW"); // �Էµ� pass ��
		System.out.println(STF_ID);
		MemberL mem = dao.mailselectOne(STF_ID);
		String msg = "���̵� Ȯ�����ּ���";
		String url = "main";
		if (mem != null) {
			System.out.println("�� �ƴ�");
			if (STF_PW.equals(mem.getSTF_PW())) {
				System.out.println("��й�ȣ ��Ī Ȯ��");
				session.setAttribute("login", STF_ID);
				msg = mem.getSTF_NM() + "���� �α��� �ϼ̽��ϴ�.";
				url = "main";
			} else {
				msg = "��й�ȣ�� Ȯ�� �ϼ���";
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

		System.out.println("dao��");

		String msg = "fail";
		String url = "writeForm";
		System.out.println("if��");
		System.out.println("if��");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "mail/alert";
	}

	@RequestMapping("maildelete")
	public String maildelete(Model m) throws Throwable {
		Mail2 mail = new Mail2();
		String msg = "�����Ϸ�";
		String url = "mail";
		System.out.println("if��");
		if (dao.maildelete(mail)) {
			System.out.println("if��");
			msg = "�Խñ��� ���������� �����Ͽ����ϴ�.";
			url = "mail";
		} else {
			msg = "�Խñ��� �����ϴµ� �����Ͽ����ϴ�!";

		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "mail/alert";
	}
	//----------------------���� �������ִ� �����ڵ� ���� ���߿�
	@RequestMapping("delete")
	public String delete(Model m, String[] RowCheck, HttpSession session) throws Throwable {
		System.out.println(Arrays.asList(RowCheck));

		System.out.println("delete����");
		System.out.println("f");

		System.out.println("d");
		System.out.println(RowCheck[0]);
		int size = RowCheck.length;
		System.out.println(size);
		String msg = "�����Ϸ�";
		String url = "mail";
		for (int i = 0; i < size; i++) {

			if (dao.delete(RowCheck[i])) {
				System.out.println("if��"); 
				msg = "�Խñ��� ���������� �����Ͽ����ϴ�."; 
				url = "mail"; }

			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "mail/alert";
	}

	@RequestMapping("delete1")
	public String delete1(Model m, String[] RowCheck1) throws Throwable {
		System.out.println("delete����");
		System.out.println(Arrays.asList(RowCheck1));
		System.out.println("f");

		System.out.println("d");
		System.out.println(RowCheck1[0]);
		int size = RowCheck1.length;
		System.out.println(size);
		String msg = "�����Ϸ�";
		String url = "mail";
		for (int i = 0; i < size; i++) {

			if (dao.delete1(RowCheck1[i])) { 
				System.out.println("if��"); 
				msg =  "�Խñ��� ���������� �����Ͽ����ϴ�."; 
				url = "mail"; }

			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "mail/alert";
	}
	//--------------------------------------------------------------------------------���� ����
	@RequestMapping("logout")
	public String logout(Model m, HttpSession session) throws Throwable {

		/*
		 * 1. session�� ��ϵ� �α��� ���� ���� 2. id�� �α׾ƿ��Ǿ����ϴ�. �޼��� ��� �� loginForm.jsp�� ������ �̵��ϱ�
		 */

		String login = (String) session.getAttribute("login");
		session.invalidate();
		String msg = login + "�� �α׾ƿ��Ǿ����ϴ�.";
		m.addAttribute("msg", msg);
		m.addAttribute("url", "main");
		return "alert";
	}

	/*---------------------------------------------------------*/
	@RequestMapping("info")
	public String info(Model m, int num) {
		/*
		 * : �Խù� �� ���� :board/info?num=41 1. num �Ķ���͸� �̿��Ͽ� db�� �ش� �Խù� ��ȸ Board board =
		 * new BoardDao().selectOne(num); 2. ��ȸ�� ������Ű��. readcnt+1 new
		 * BoardDao().readcntadd(num); 3. 1������ ��ȸ�� �Խù������͸� ȭ�鿡 ����ϱ�
		 */
		/* eml_sq ������ȣ number */
		// mymail���� num������ 1
		// �Ķ���Ͱ��б�
		Mail2 mail = dao.selectOne(num);
		dao.readcntadd(num); // ��ȸ�Ǽ�����
		m.addAttribute("mail", mail);
		m.addAttribute("num", num);// mailinfo�� num�Ѱ��� if l.eml_sq = num
		return "mail/mailInfo";
	}


	@RequestMapping("mailForm")
	public ModelAndView mailForm() {
		ModelAndView mav = new ModelAndView("/mail/mailw");
		return mav;
	}

	@RequestMapping("mailw")//���Ͼ���
	public ModelAndView mailw(Mail mail,HttpSession session, Model m) {
		mailSend(mail);
		if(dao.mailinsert(mail)) {
			System.out.println("success");
		}
		ModelAndView mav = new ModelAndView("/mail/mailSuccess");
		return mav;
	}

	//�ڹٸ����� �̿��Ͽ� ���� ���۽� ���� ������ ���� �ޱ����� ��ü
	private final class MyAuthenticator extends Authenticator {
		private String id;//�����»���� @naver.com�� ����Ʈ�� �پ���
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
	//mail : ȭ�鿡�� �Է��� ���� ����
	private void mailSend(Mail mail) {
		//���� ������ ���� ȯ�� ���� ����
		MyAuthenticator auth = new MyAuthenticator(mail.getNaverid(),mail.getNaverpw());
		Properties prop = new Properties(); //Map ��ü 
		prop.put("mail.smtp.host", "smtp.naver.com"); //���� ���ۼ��� �ּ� ����, 
		prop.put("mail.smtp.starttls.enable", "true");//���� ����
		prop.put("mail.user",mail.getNaverid() );
		prop.put("mail.from",mail.getNaverid()+"@naver.com" );//�����»���� @naver.com�� ����Ʈ�� �پ���
		prop.put("mail.debug","false"); //debug ���·� �ǽ��ϱ�
		prop.put("mail.smtp.auth","true"); //���� ���۽� ���� �ʼ�. 
		prop.put("mail.smtp.port","465");
		prop.put("mail.smtp.user",mail.getNaverid() ); //������ ��� ����
		prop.put("mail.smtp.socketFactory.port","465");
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback","false");
		Session session = Session.getInstance(prop,auth); //���� ������ ����. �غ� �Ϸ�
		//msg : session�� ���� ���۵Ǵ� ��ü
		MimeMessage msg = new MimeMessage(session);  //���Ϸ� ������ ��ü ����
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mail.getNaverid()+"@naver.com"));

			//�����ڸ����ּ�
			message.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(mail.getRecipient())); 

			// Subject 
			message.setSubject(mail.getTitle()); //���� ������ �Է�

			// Text
			message.setText(mail.getContents());    //���� ������ �Է�

			// send the message
			Transport.send(message); ////����
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

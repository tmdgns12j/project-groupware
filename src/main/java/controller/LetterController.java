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
		System.out.println("letter �Դϴ�");

		List<Letter> listletter = dao.listletter(); // ȭ�鿡 ��µ� �Խù� ������
		m.addAttribute("num", listletter.size());// letter.jsp���� num, ����Ʈ�� ũ��
		m.addAttribute("list", listletter);// letter.jsp���� list

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
		 * 1. id, pass �Ķ���� ���� 2. db���� id �� �ش��ϴ� �����͸� �о Member ���޹ޱ� 3. ����м� Member��ü��
		 * null �ΰ�� : ���̵� Ȯ���ϼ��� �޼��� ���. --->loginForm.jsp ������ �̵� Member��ü�� null�� �ƴ� ���
		 * : ȭ�鿡�� �Էµ� ��й�ȣ�� db ��й�ȣ ���� ������� : �α��� ����. -----> main.jsp ������ �̵� �ٸ� ��� :
		 * ��й�ȣ Ȯ���ϼ��� ----> loginForm.jsp�� ������ �̵�
		 */

		//		String id = request.getParameter("STF_ID"); // �Էµ� id��
		//		String pass = request.getParameter("STF_PW"); // �Էµ� pass ��
		// mem : db�� ����� ȸ������ ����
		System.out.println(STF_ID);
		MemberL mem = dao.letterselectOne(STF_ID);
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
		return "letter/alert";
	}

	@RequestMapping("main")
	public String main(Model m, HttpSession session) throws Throwable {
		/*
		 * 1. �α��� �Ŀ� �������� ������. => �α��� ���� Ȯ�� => �α��λ��°� �ƴ� ���, loginForm.jsp�� ������ �̵��ϱ�
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
		MultipartFile multiFile = request.getFile("uploadfile");//������ ���� ��Ƽ��Ʈ
		if (!multiFile.isEmpty()) {
			File file = new File(uploadpath, multiFile.getOriginalFilename());
			try {
				multiFile.transferTo(file);
				letter.setEML_PL_NM(multiFile.getOriginalFilename());//�����̸� ����
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			letter.setEML_PL_NM("");
		}

		System.out.println("dao��");

		String msg = "fail";
		String url = "writeForm";
		System.out.println("if��");
		if (dao.letterinsert(letter)) {
			System.out.println("if��");
			msg = "�Խù� ��� ����";
			url = "letter";
		}
		System.out.println("if��");
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("letterdelete")
	public String letterdelete(Model m) throws Throwable {
		/*
		 * 1. num,pass �Ķ���͸� ������ ����. 2. �Էµ� ��й�ȣ�� db
		 * ��й�ȣ ���� Ʋ����� : ��й�ȣ ���� �޽��� ���, deleteForm.jsp ������ �̵� 3. �Խù� ����. ���� ���� : ���� ����
		 * �޽��� ���, list.jsp ������ �̵� ���� ���� : ���� ���� �޽��� ���, info.jsp ������ �̵�
		 */

		/* String num = request.getParameter("STF_SQ"); */ // �Էµ� id��
		Letter letter = new Letter();

		// board.getPass() : db�� ����� ��й�ȣ

		String msg = "�����Ϸ�";
		String url = "letter";
		System.out.println("if��");
		if (dao.letterdelete(letter)) {
			System.out.println("if��");
			msg = "�Խñ��� ���������� �����Ͽ����ϴ�.";
			url = "letter";
		} else {
			msg = "�Խñ��� �����ϴµ� �����Ͽ����ϴ�!";

		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}

	@RequestMapping("delete")//üũ�� ���� ����(��ü�����)
	public String delete(Model m, String[] RowCheck, HttpSession session) throws Throwable {
		System.out.println(Arrays.asList(RowCheck));//üũ�Ȱ� Ȯ�ο�
		System.out.println(RowCheck[0]);
		int size = RowCheck.length;//üũ�� �׸� ����
		System.out.println(size);//���� Ȯ�ο�
		String msg = "�����Ϸ�";
		String url = "letter";
		for (int i = 0; i < size; i++) {
			if (dao.delete(RowCheck[i])) {//üũ�Ȱ� ����
				System.out.println("if��");
				msg = "�Խñ��� ���������� �����Ͽ����ϴ�.";
				url = "letter";
			}
			System.out.println("delete");
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}

	@RequestMapping("delete1")//üũ�� ���û���
	public String delete1(Model m, String[] RowCheck1) throws Throwable {
		System.out.println(Arrays.asList(RowCheck1));
		System.out.println(RowCheck1[0]);
		int size = RowCheck1.length;
		System.out.println(size);
		String msg = "�����Ϸ�";
		String url = "letter";
		for (int i = 0; i < size; i++) {
			if (dao.delete1(RowCheck1[i])) {
				System.out.println("if��");
				msg = "�Խñ��� ���������� �����Ͽ����ϴ�.";
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
	@RequestMapping("info")//0�̾ƴϸ� �������� ó���ɰ�
	public String info(Model m, int num) {
		/*
		 * 1. num �Ķ���͸� �̿��Ͽ� db�� �ش� �Խù� ��ȸ selectOne(num); 2. ��ȸ�� ������Ű��. readcnt+1 new
		 * 3. 1������ ��ȸ�� �Խù������͸� ȭ�鿡 ����ϱ�
		 */
		/* eml_sq ������ȣ number */
		// myletter���� num������ 1
		// �Ķ���Ͱ��б�
		Letter letter = dao.selectOne(num);
		dao.readcntadd(num); // ��ȸ�Ǽ�����
		m.addAttribute("letter", letter);
		m.addAttribute("num", num);// letterinfo�� num�Ѱ��� if l.eml_sq = num
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
		if (dao.insert(mem)) { // ���Լ���
			dao.cmtinsert(mem);
			msg = mem.getSTF_NM() + "���� ������ �Ϸ� �Ǿ����ϴ�";
			url = "memlist";
		} else {
			msg = "ȸ�� ������ ���� �Ǿ����ϴ�";
			url = "";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("memlist")//ȸ������Ʈ
	public String memlist(Model m) {
		System.out.println("memlist �Դϴ�");

		List<MemberL> memberlist = dao.memlist();
		m.addAttribute("num", memberlist.size());
		m.addAttribute("list", memberlist);
		System.out.println(memberlist);
		return "letter/memlist";
	}

	@RequestMapping("memdelete")//ȸ�� ����
	public String memdelete(Model m, String id) {
		System.out.println("memdelete");

		String msg = "����";
		String url = "memlist";
		if (dao.memdelete(id)) {
			dao.cmtdelete(id);
			msg = "����";
			url = "memlist";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("memupdateForm")//ȸ������ ������
	public String memupdateForm(Model m, String id) {
		System.out.println("updateForm");
		MemberL mem = dao.letterselectOne(id);
		m.addAttribute("mem", mem);
		return "letter/memupdateForm";
	}

	@RequestMapping("memupdate")//ȸ������ ����
	public String memupdate(Model m, MemberL mem) {
		MemberL dbMember = dao.letterselectOne(mem.getSTF_ID());
		String msg = "��������";
		String url = "memupdateForm?id=" + mem.getSTF_ID();
		if (mem.getSTF_ID().equals(dbMember.getSTF_ID())) {
			if (dao.memupdate(mem)) {
				msg = mem.getSTF_ID() + "�� ������ �����Ǿ����ϴ�.";
				url = "memlist";
			}
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}

	@RequestMapping("scheduleList")//�系 �������
	public String scheduleList(Model m) {
		System.out.println("schedulelist�Դϴ�");

		List<Schedule> scheduleList = dao.scheduleList();
		m.addAttribute("num", scheduleList.size());
		m.addAttribute("list", scheduleList);
		System.out.println(scheduleList);
		return "letter/scheduleList";
	}

	@RequestMapping("scheduleDelete")//�系���� ����
	public String scheduleDelete(Model m, String id) {
		System.out.println("scheduleDelete");

		String msg = "����";
		String url = "scheduleList";
		if (dao.scheduleDelete(id)) {
			msg = "����";
			url = "scheduleList";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("scheduleUpdateForm")//�系���� ���� ��
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

	@RequestMapping("addSchedule")//���� �߰�
	public String addSchedule(Schedule schedule, Model m) {
		String msg = "fail";
		String url = "scheduleForm";
		System.out.println("if��");
		if (dao.addSchedule(schedule)) {
			System.out.println("if��");
			msg = "�Խù� ��� ����";
			url = "scheduleList";
		}
		System.out.println("if��");
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "letter/alert";
	}

	@RequestMapping("scheduleUpdate")//�系���� ����
	public String scheduleUpdate(HttpSession session, Schedule schedule, Model m) throws Throwable {
		String msg = "fail";
		String url = "scheduleList";
		if (dao.scheduleUpdate(schedule)) {
			msg = "�Խù� ���� �Ϸ�";
			url = "scheduleList";
		} else {
			msg = "�Խù� ���� ����";
		}
		System.out.println(schedule.getSchedule_sq());
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "letter/alert";
	}
}

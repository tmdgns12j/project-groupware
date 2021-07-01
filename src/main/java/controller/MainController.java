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
		String url = "loginForm";
		if (mem != null) {
			System.out.println("�� �ƴ�");
			if (STF_PW.equals(mem.getSTF_PW())) {
				System.out.println("��й�ȣ ��Ī Ȯ��");
				session.setAttribute("login", STF_ID);
				msg = mem.getSTF_NM() + "���� �α��� �ϼ̽��ϴ�.";
				url = "main";
			} else {
				msg = "��й�ȣ�� Ȯ�� �ϼ���";
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
			
			/* -------------�޷½���------------------------ */
			System.out.println("�޷µ���");
			Calendar cal = Calendar.getInstance();
			DateData calendarData;
			// � �� ����
			if (dateData.getDate().equals("") && dateData.getMonth().equals("")) {
				dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
						String.valueOf(cal.get(Calendar.DATE)), null);
			}
			// � �� ���� end
			System.out.println("1");
			Map<String, Integer> today_info = dateData.today_info(dateData);
			System.out.println("2");
			List<DateData> dateList = new ArrayList<DateData>();
			// ���و적 �� �� �� �� �� �� 리스 �� �� �� �� �� �� �� �� ��.
			// �� �� �� �� �� �� ��까� ��무것 �� �� �� �� �� �� �� ��
			for (int i = 1; i < today_info.get("start"); i++) {
				calendarData = new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
			
			// ���� �� ��
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
			 * if (Integer.parseInt(birthM) < 10) { System.out.println("if��"); birthM =
			 * birthM.replace("0", ""); }
			 */
			m.addAttribute("id", id);// �Ķ���� id�� "id" �̸����� calendar.jsp ${id}�� ����
			m.addAttribute("birthM", birthM);// ������ �� 01 02 03 ~ 11 12, dateList�� 1 2 3 4 ~ 11 12
			m.addAttribute("birthD", birthD);// ������ �� calender.jsp�� ����
			m.addAttribute("birthName", birthName);// ������ ����̸� calender.jsp�� ����
			m.addAttribute("search_month",search_month);
			m.addAttribute("dateList", dateList);
			m.addAttribute("today_info", today_info);
			/* -----------------������ ����--------------------- */
			System.out.println("letter �Դϴ�");

			List<Letter> listletter = dao.listletter(); // ȭ�鿡 ��µ� �Խù� ������
			m.addAttribute("num", listletter.size());//letter.jsp���� num, ����Ʈ�� ũ��
			m.addAttribute("list", listletter);//letter.jsp���� list
			/* -----------------�Խ��� ����--------------------- */
			System.out.println("list �Դϴ�");
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(page);
			} catch (NumberFormatException e) {
			}

			int limit = 10; // ���������� ����� �Խù� �Ǽ�
			
			int noticecount = Ndao.noticeCount();// ��ϵ� ��ü �Խù��� �Ǽ�

			List<Notice> nlist = Ndao.list(pageNum, limit, noticecount); // ȭ�鿡 ��µ� �Խù� ������
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
			/* ���� */
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
		String msg = login + "�� �α׾ƿ��Ǿ����ϴ�.";
		m.addAttribute("msg", msg);
		m.addAttribute("url", "loginForm");
		return "alert";
	}
}

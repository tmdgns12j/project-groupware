package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import data.DateData;
import model.MemberL;
import model.Schedule;
import service.CalendarDao;
import service.LetterDaoMybatis;

@Controller
@RequestMapping("/calendar/")
public class CalendarController {

	@Autowired
	CalendarDao dao;

	@RequestMapping("calendar") // post�����س���
	public String calendar(Model model, HttpServletRequest request, DateData dateData, String id) {
		System.out.println("�޷µ���");
		Calendar cal = Calendar.getInstance();
		DateData calendarData;
		// � �� ����
		if (dateData.getDate().equals("") && dateData.getMonth().equals("")) {
			dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
					String.valueOf(cal.get(Calendar.DATE)), null);
		}
		// � �� ���� end

		Map<String, Integer> today_info = dateData.today_info(dateData);
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
		List<MemberL> birthM = dao.selectBM();
		List<MemberL> birthD = dao.selectBD();
		List<MemberL> birthName = dao.selectName();
		System.out.println(birthM);
		System.out.println(birthD);
		System.out.println(birthName);
		/*
		 * if (Integer.parseInt(birthM) < 10) { System.out.println("if��"); birthM =
		 * birthM.replace("0", ""); }
		 */
		/* dateList.month�� dateList.date�� 1,2,3~11, 12�εǾ�����
		 * ���� ������ birthM�̳� birthD�� 01,02,03~11,12�� �Ǿ�����
		 * �׷��� �ΰ��� ������ ��������ϴµ� birthM�̳� birthD�� -0,���� ���������ְԵǸ� 1,2,3~11,12�� ������ ������
		 * dateList.month�� 0���� �����̶� jsp���� birthM�� -1������
		 * �׷����� -1�� ���ָ� 1���� ������ �ȳ����⶧���� dateList.month��+1������
		 */
		model.addAttribute("id", id);// �Ķ���� id�� "id" �̸����� calendar.jsp ${id}�� ����
		model.addAttribute("birthM", birthM);// ������ �� 01 02 03 ~ 11 12, dateList�� 1 2 3 4 ~ 11 12
		model.addAttribute("birthD", birthD);// ������ �� calender.jsp�� ����
		model.addAttribute("birthName", birthName);// ������ ����̸� calender.jsp�� ����

		model.addAttribute("dateList", dateList);
		model.addAttribute("today_info", today_info);
		return "calendar/calendar";
	}
}
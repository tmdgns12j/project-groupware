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

	@RequestMapping("calendar") // post삭제해놨음
	public String calendar(Model model, HttpServletRequest request, DateData dateData, String id) {
		System.out.println("달력들어옴");
		Calendar cal = Calendar.getInstance();
		DateData calendarData;//data.DateData
		//검색날짜
		if (dateData.getDate().equals("") && dateData.getMonth().equals("")) { 
			dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
					String.valueOf(cal.get(Calendar.DATE)), null);
		}


		Map<String, Integer> today_info = dateData.today_info(dateData);
		List<DateData> dateList = new ArrayList<DateData>();//해당하는 년도의 달의 날짜를 나열 2020 5.1~30 (배열)
		
		
		for (int i = 1; i < today_info.get("start"); i++) {
			calendarData = new DateData(null, null, null, null);
			dateList.add(calendarData);
		}

		//날짜삽입
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
		//달력 빈곳 빈 데이터로 삽입(달력의 표를 맞춰주기위함, 달마다 시작요일 끝요일 다르기때문)
		int index = 7 - dateList.size() % 7;
		if (dateList.size() % 7 != 0) {

			for (int i = 0; i < index; i++) {
				calendarData = new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
		}

		id = request.getParameter("id");//id에 해당하는 생일을 불러오기위해 가져옴
		List<MemberL> birthM = dao.selectBM();
		List<MemberL> birthD = dao.selectBD();
		List<MemberL> birthName = dao.selectName();
		System.out.println(birthM);
		System.out.println(birthD);
		System.out.println(birthName);
		/* dateList.month나 dateList.date는 1,2,3~11, 12로되어있음
		 * 내가 설정한 birthM이나 birthD는 01,02,03~11,12로 되어있음
		 * 그래서 두개의 형식을 맞춰줘야하는데 birthM이나 birthD에 -0,같은 연산을해주게되면 1,2,3~11,12로 형식이 맞춰짐
		 * dateList.month는 0부터 시작이라 jsp보면 birthM에 -1해줬음
		 * 그랬지만 -1을 해주면 1월달 생일이 안나오기때문에 dateList.month에+1해줬음
		 */
		model.addAttribute("id", id);// 파라미터 id를 "id" 이름으로 calendar.jsp ${id}에 전달
		model.addAttribute("birthM", birthM);// 생일의 달 01 02 03 ~ 11 12, dateList는 1 2 3 4 ~ 11 12
		model.addAttribute("birthD", birthD);// 생일의 일 calender.jsp로 보냄
		model.addAttribute("birthName", birthName);// 생일인 사람이름 calender.jsp로 보냄

		model.addAttribute("dateList", dateList); //날짜 데이터배열
		model.addAttribute("today_info", today_info);
		return "calendar/calendar";
	}
}
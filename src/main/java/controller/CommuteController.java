package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import model.Commute;
import service.CommuteDaoMybatis;


@Controller
@RequestMapping("/commute/")
public class CommuteController {
	@Autowired
	CommuteDaoMybatis cdao;
	
	@RequestMapping("start")//출근버튼 클릭시
	public String start(HttpServletRequest request, HttpSession session,String STF_ID, Model m,Commute commute,String id) {
		System.out.println("출근시작");
		String login = (String) session.getAttribute("login");//해당 사원의 출근시간을 저장하기위함
		String msg = "fail";
		String url = "../main/main";
		Date starttm = cdao.starttime(login);
		cdao.starttime(login);//id의 출근시간 저장
		if (cdao.starttime(login) != null) {
			System.out.println("if후");
			msg = "출근했네";
			url = "../main/main";
		}
		System.out.println("starttm : "+ starttm);
		session.setAttribute("StartTm", starttm);
		m.addAttribute("StartTm", starttm);//main으로 StartTm전달
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "alert";
	}
	
	@RequestMapping("end")//퇴근버튼클릭시
	public String end(HttpServletRequest request, HttpSession session,String STF_ID, Model m,Commute commute,String id) {
		System.out.println("퇴근시작");
		String login = (String) session.getAttribute("login");
		String msg = "fail";
		String url = "../main/main";
		Date endtm = cdao.endtime(login);//퇴근
		if (cdao.endtime(login) != null) {
			System.out.println("if후");
			msg = "집에가자";
			url = "../main/main";
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd :hh/mm/ss");//시간포멧(안씀)
		
		System.out.println("dd"+sf.format(endtm));
		System.out.println("endtm : "+ endtm);
		m.addAttribute("aaa", sf.format(endtm));//main으로 EndTm전달
		session.setAttribute("EndTm", endtm); 
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "alert";
	}
}

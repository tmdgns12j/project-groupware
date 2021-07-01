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
	
	@RequestMapping("start")
	public String start(HttpServletRequest request, HttpSession session,String STF_ID, Model m,Commute commute,String id) {
		System.out.println("��ٽ���");
		String login = (String) session.getAttribute("login");
		String msg = "fail";
		String url = "../main/main";
		Date starttm = cdao.starttime(login);
		cdao.starttime(login);
		if (cdao.starttime(login) != null) {
			System.out.println("if��");
			msg = "����߳�";
			url = "../main/main";
		}
		System.out.println("starttm : "+ starttm);
		session.setAttribute("StartTm", starttm);
		m.addAttribute("StartTm", starttm);//main���� StartTm����
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "alert";
	}
	
	@RequestMapping("end")
	public String end(HttpServletRequest request, HttpSession session,String STF_ID, Model m,Commute commute,String id) {
		System.out.println("��ٽ���");
		String login = (String) session.getAttribute("login");
		String msg = "fail";
		String url = "../main/main";
		Date endtm = cdao.endtime(login);
		if (cdao.endtime(login) != null) {
			System.out.println("if��");
			msg = "��������";
			url = "../main/main";
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd :hh/mm/ss");
		
		System.out.println("dd"+sf.format(endtm));
		System.out.println("endtm : "+ endtm);
		m.addAttribute("aaa", sf.format(endtm));//main���� EndTm����
		session.setAttribute("EndTm", endtm); 
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "alert";/*tq*/
	}
}

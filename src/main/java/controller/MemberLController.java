package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.MemberL;
import service.MemberLDao;

@Controller
@RequestMapping("/memberl/")
public class MemberLController {
	@Autowired
	MemberLDao dao;	
	@RequestMapping("joinForm")
	public String joinForm() {
		System.out.println("joinForm");
		return "memberl/joinForm";
	}
	@RequestMapping("join")
	public String join(MemberL mem, Model m) {
		String msg = "";
		String url = "";
		if (dao.insert(mem)) { // ���Լ���
			msg = mem.getSTF_NM() + "���� ������ �Ϸ� �Ǿ����ϴ�";
			url = "letter/main";
		} else {
			msg = "ȸ�� ������ ���� �Ǿ����ϴ�";
			url = "joinForm";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "alert";
	}
}

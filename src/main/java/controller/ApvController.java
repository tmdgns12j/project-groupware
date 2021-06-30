package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Apv;
import service.ApvDao;

@Controller
@RequestMapping("/apv/")
public class ApvController {

	@Autowired
	ApvDao dao;
	
	@RequestMapping("list")
	public String list(Model m) throws Throwable {
		System.out.println("list �Դϴ�");

		List<Apv> list = dao.list(); // ȭ�鿡 ��µ� �Խù� ������
		m.addAttribute("num", list.size());//letter.jsp���� num, ����Ʈ�� ũ��
		m.addAttribute("list", list);//letter.jsp���� list

		return "apv/list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm() {
		return "apv/writeForm";
	}

	@RequestMapping("write")
	public String write(Apv apv, Model m) {
		
		String msg = "fail";
		String url = "writeForm";
		if(dao.insert(apv)) {
			msg = "success";
			url = "list";
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "apv/alert";
	}
	
	@RequestMapping("info")
	public String info(int num, Model m) {
		Apv apv = dao.selectOne(num);
		m.addAttribute("apv", apv);
		m.addAttribute("num",num);
		return "apv/info";
	}
	@RequestMapping("info2")
	public String info2(int num, Model m) {
		Apv apv = dao.selectOne(num);
		m.addAttribute("apv", apv);
		m.addAttribute("num",num);
		return "apv/info2";
	}
	
	@RequestMapping("update")
	public String update(Model m, int num) {
		String msg = null;
		String url = null;
		
		Apv apv = dao.selectOne(num);
		apv.setAPV_NO("O");
		if (dao.update(apv)) {
			msg = "����";
			url = "list";
		} else {
			msg = "����";
			url = "list";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}
	
	@RequestMapping("update1")
	public String update1(Model m, int num, String reject) {
		String msg = null;
		String url = null;
		
		Apv apv = dao.selectOne(num);
		apv.setAPV_NO("X:"+reject);
		if (dao.update(apv)) {
			msg = "����";
			url = "list";
		} else {
			msg = "����";
			url = "list";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}
	
	@RequestMapping("fnlupdate")
	public String fnlupdate(Model m, int num) {
		String msg = null;
		String url = null;
		
		Apv apv = dao.selectOne(num);
		apv.setAPV_NO1("O");
		if (dao.fnlupdate(apv)) {
			msg = "����";
			url = "list";
		} else {
			msg = "����";
			url = "list";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}
	
	@RequestMapping("fnlupdate1")
	public String fnlupdate1(Model m, int num, String reject) {
		String msg = null;
		String url = null;
		
		Apv apv = dao.selectOne(num);
		apv.setAPV_NO1("X:"+reject);
		if (dao.fnlupdate(apv)) {
			msg = "����";
			url = "list";
		} else {
			msg = "����";
			url = "list";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}
}

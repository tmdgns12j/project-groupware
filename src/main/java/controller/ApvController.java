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
		List<Apv> list = dao.list(); // 화면에 출력된 게시물 데이터
		m.addAttribute("num", list.size());// 리스트의 크기
		m.addAttribute("list", list);// apv.jsp들의 list
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
		if (dao.insert(apv)) {  //폼에있는 내용 insert후 success띄운후 list로 돌아감
			msg = "success";
			url = "list";
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		return "apv/alert";
	}

	@RequestMapping("info") //결재 정보
	public String info(int num, Model m) {
		Apv apv = dao.selectOne(num); //결재번호(num)에 해당하는 것을 불러옴
		m.addAttribute("apv", apv);
		m.addAttribute("num", num);
		return "apv/info";
	}

	@RequestMapping("info2")//결재 완료된 항목의 정보를 보여줌
	public String info2(int num, Model m) {
		Apv apv = dao.selectOne(num);
		m.addAttribute("apv", apv);
		m.addAttribute("num", num);
		return "apv/info2";
	}

	@RequestMapping("update")//중간승인 완료
	public String update(Model m, int num) {
		String msg = null;
		String url = null;
		Apv apv = dao.selectOne(num);
		apv.setAPV_NO("O");//승인되면 O표시
		if (dao.update(apv)) { //중간승인자 승인
			msg = "성공";
			url = "list";
		} else {
			msg = "실패";
			url = "list";
		}

		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}

	@RequestMapping("update1")//중간승인 거절
	public String update1(Model m, int num, String reject) {
		String msg = null;
		String url = null;

		Apv apv = dao.selectOne(num);
		apv.setAPV_NO("X:" + reject);//승인 거절
		if (dao.update(apv)) {
			msg = "성공";
			url = "list";
		} else {
			msg = "실패";
			url = "list";
		}

		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}

	@RequestMapping("fnlupdate")//최종승인 완료
	public String fnlupdate(Model m, int num) {
		String msg = null;
		String url = null;

		Apv apv = dao.selectOne(num);
		apv.setAPV_NO1("O");//승인시 O표시
		if (dao.fnlupdate(apv)) {//승인
			msg = "성공";
			url = "list";
		} else {
			msg = "실패";
			url = "list";
		}

		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}

	@RequestMapping("fnlupdate1")//최종승인 거절
	public String fnlupdate1(Model m, int num, String reject) {
		String msg = null;
		String url = null;

		Apv apv = dao.selectOne(num);
		apv.setAPV_NO1("X:" + reject);
		if (dao.fnlupdate(apv)) {
			msg = "성공";
			url = "list";
		} else {
			msg = "실패";
			url = "list";
		}

		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "letter/alert";
	}
}

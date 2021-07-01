/*
 * package controller;
 * 
 * import java.io.File; import java.io.IOException;
 * 
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.multipart.MultipartHttpServletRequest;
 * 
 * import model.Board; import service.BoardDaoMybatis;
 * 
 * @Controller
 * 
 * @RequestMapping("/board/") public class BoardController { String sesboardid =
 * "1"; int sespageNum = 1;
 * 
 * @Autowired BoardDaoMybatis dao;
 * 
 * @ModelAttribute() public void setSession(HttpSession session) { if
 * (session.getAttribute("boardid") != null) { sesboardid = (String)
 * session.getAttribute("boardid"); } if (session.getAttribute("pageNum") !=
 * null) { sespageNum = Integer.parseInt((String)
 * (session.getAttribute("pageNum"))); } }
 * 
 * @RequestMapping("test") public String pub(Model m) { m.addAttribute("test",
 * "board �Դϴ�"); return "index"; }
 * 
 * @RequestMapping("list") public String list(String page, String boardid, Model
 * m, HttpSession session) { System.out.println("list ����"); int pageNum = 1;
 * try { pageNum = Integer.parseInt(page); session.setAttribute("pageNum",
 * pageNum); sespageNum = pageNum;
 * 
 * } catch (NumberFormatException e) { }
 * 
 * if (boardid != null) { session.setAttribute("boardid", boardid); sesboardid =
 * boardid; session.setAttribute("pageNum", 1); sespageNum = 1; } int limit = 3;
 * // ���������� ����� �Խù� �Ǽ�
 * 
 * int boardcount = dao.boardCount(sesboardid);// ��ϵ� ��ü �Խù��� �Ǽ�
 * 
 * List<Board> list = dao.list(pageNum, limit, boardcount, sesboardid); // ȭ�鿡
 * ��µ� �Խù� ������ // 13 ---> boardcount/limit : 4 + 1 int maxpage = (int)
 * (boardcount / limit) + (boardcount % limit == 0 ? 0 : 1); int bottomLine = 3;
 * // page 1,2,3 : 1, 4,5,6: 2 int startpage = 1 + (pageNum - 1) / bottomLine *
 * bottomLine; int endpage = startpage + bottomLine - 1; if (endpage > maxpage)
 * endpage = maxpage; int boardnum = boardcount - (pageNum - 1) * limit; String
 * boardname = "��������"; if (sesboardid.equals("2")) boardname = "�����Խ���"; if
 * (sesboardid.equals("3")) boardname = "QNA";
 * 
 * m.addAttribute("boardcount", boardcount); m.addAttribute("list", list);
 * m.addAttribute("boardnum", boardnum); m.addAttribute("startpage", startpage);
 * m.addAttribute("bottomLine", bottomLine); m.addAttribute("endpage", endpage);
 * m.addAttribute("maxpage", maxpage); m.addAttribute("pageNum", pageNum);
 * m.addAttribute("boardname", boardname);
 * 
 * return "board/list"; }
 * 
 * @RequestMapping("write") public String write(MultipartHttpServletRequest
 * request, Board board, Model m) {
 * 
 * 1. �Ķ���� ���� model.Board ��ü ����. 2. �Խù� ��ȣ num ���� ��ϵ� num�� �ִ밪�� ��ȸ. �ִ밪 +1 ��ϵ�
 * �Խù��� ��ȣ. db���� maxnum �� ���ؼ� +1 ������ num �����ϱ�
 * 
 * // 1. �Ķ���� ���� model.Board ��ü ����. String uploadpath =
 * request.getServletContext().getRealPath("/upfile"); MultipartFile multiFile =
 * request.getFile("uploadfile"); if (!multiFile.isEmpty()) { File file = new
 * File(uploadpath, multiFile.getOriginalFilename()); try {
 * multiFile.transferTo(file); board.setFile1(multiFile.getOriginalFilename());
 * } catch (IllegalStateException e) { board.setFile1(""); // TODO
 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) {
 * board.setFile1(""); // TODO Auto-generated catch block e.printStackTrace(); }
 * } else { board.setFile1(""); } // 2. sequence nextval �Է� // db���� maxnum �� ���ؼ�
 * +1 ������ num �����ϱ�
 * 
 * // 3. board ��ü�� ������ db�� insert �ϱ� String msg = "�Խù� ��� ����"; String url =
 * "writeForm"; board.setBoardid(sesboardid); // �Է½� boardid �Է��� if
 * (dao.insert(board)) { msg = "�Խù� ��� ����"; url = "list"; }
 * request.setAttribute("msg", msg); request.setAttribute("url", url); return
 * "board/alert"; }
 * 
 * @RequestMapping("info") public String info(int num, Model m) {
 * 
 * : �Խù� �� ���� :board/info?num=41 1. num �Ķ���͸� �̿��Ͽ� db�� �ش� �Խù� ��ȸ Board board =
 * new BoardDao().selectOne(num); 2. ��ȸ�� ������Ű��. readcnt+1 new
 * BoardDao().readcntadd(num); 3. 1������ ��ȸ�� �Խù������͸� ȭ�鿡 ����ϱ�
 * 
 * 
 * // �Ķ���Ͱ��б�
 * 
 * Board board = dao.selectOne(num); // �Խù� ��ȸ dao.readcntadd(num); // ��ȸ�Ǽ�����
 * m.addAttribute("board", board); m.addAttribute("num", num); return
 * "board/info"; }
 * 
 * @RequestMapping("updateForm") public String updateForm(int num, Model m) {
 * 
 * /WebContent/model1/board/updateForm.jsp 1. num ���� �Խù��� ��ȸȭ�� ȭ�� ����ϱ�
 * 
 * Board board = dao.selectOne(num); m.addAttribute("board", board); return
 * "board/updateForm"; }
 * 
 * @RequestMapping("update") public String update(MultipartHttpServletRequest
 * request, Board board, Model m) {
 * 
 * /WebContent/model1/board/update.jsp 1. �Ķ������������ Board ��ü ����. 2. ��й�ȣ ���� ��й�ȣ
 * ��ġ : ��������. ��й�ȣ ����ġ : ��й�ȣ ���� �޼��� ����ϰ�, updateForm.jsp�� ������ �̵� 3. �������� : ��������
 * �޽��� ��� �� list.jsp ������ �̵� �������� : �������� �޽��� ��� �� updateForm.jsp ������ �̵�
 * 
 * 
 * // �Ķ���� ���� Board ��ü�� ����
 * 
 * String uploadpath = request.getServletContext().getRealPath("/upfile");
 * MultipartFile multiFile = request.getFile("uploadfile"); if
 * (!multiFile.isEmpty()) { File file = new File(uploadpath,
 * multiFile.getOriginalFilename()); try { multiFile.transferTo(file);
 * board.setFile1(multiFile.getOriginalFilename()); } catch
 * (IllegalStateException e) { board.setFile1(""); // TODO Auto-generated catch
 * block e.printStackTrace(); } catch (IOException e) { board.setFile1(""); //
 * TODO Auto-generated catch block e.printStackTrace(); } } else {
 * board.setFile1(""); } // ��й�ȣ ����
 * 
 * Board dbBoard = dao.selectOne(board.getNum()); String msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
 * String url = "updateForm?num=" + board.getNum();
 * 
 * if (board.getPass().equals(dbBoard.getPass())) { // �����ϱ� if
 * (dao.update(board)) { msg = "�Խù� ���� �Ϸ�"; url = "list"; } else { msg =
 * "�Խù� ���� ����"; } } request.setAttribute("url", url);
 * request.setAttribute("msg", msg);
 * 
 * return "alert"; }
 * 
 * @RequestMapping("deleteForm") public String deleteForm(int num, Model m) {
 * m.addAttribute("num", num); return "board/deleteForm"; }
 * 
 * @RequestMapping("delete") public String delete(int num, String pass, Model m)
 * throws Throwable {
 * 
 * /WebContent/model1/board/delete.jsp 1. num,pass �Ķ���͸� ������ ����. 2. �Էµ� ��й�ȣ�� db
 * ��й�ȣ ���� Ʋ����� : ��й�ȣ ���� �޽��� ���, deleteForm.jsp ������ �̵� 3. �Խù� ����. ���� ���� : ���� ����
 * �޽��� ���, list.jsp ������ �̵� ���� ���� : ���� ���� �޽��� ���, info.jsp ������ �̵�
 * 
 * String msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�!"; String url = "deleteForm?num=" + num;
 * 
 * Board board = dao.selectOne(num); // board.getPass() : db�� ����� ��й�ȣ if
 * (pass.equals(board.getPass())) { if (dao.delete(num)) { msg =
 * "�Խñ��� ���������� �����Ͽ����ϴ�."; url = "list"; } else { msg = "�Խñ��� �����ϴµ� �����Ͽ����ϴ�!";
 * url = "info?num=" + num; } }
 * 
 * m.addAttribute("url", url); m.addAttribute("msg", msg); return "alert"; }
 * 
 * @RequestMapping("replyForm") public String replyForm(int num, Model m) {
 * 
 * /WebContent/model1/board/replyForm.jsp : �亯�� ���� ȭ�� 1. ������ num�� �Ķ���ͷ� �޴´�. 2.
 * ������ num,ref,reflevel,refstep ������ ���� 3. �Է� ȭ�� ǥ��
 * 
 * 
 * Board board = dao.selectOne(num); // �Խù� ��ȸ
 * 
 * m.addAttribute("board", board);
 * 
 * return "board/replyForm"; }
 * 
 * @RequestMapping("reply") public String reply(Board board, Model m) {
 * 
 * /WebContent/model1/board/reply.jsp : ��� ��� 1. �Ķ���� ���� Board ��ü�� �����ϱ� �������� :
 * num, ref, reflevel(��), refstep(print) ������� : name, pass, subject, content 2.
 * ���� ref ���� ����ϴ� �Խù����� refstep ���� 1 ���� ��Ű�� 1 1 0 0 2 2 0 0 3 1 1 2 4 1 1 1
 * ======================== print 2 2 0 0 1 1 0 0 4 1 1 1 3 1 1 2 3. Board ��ü��
 * db�� insert �ϱ�. 4. ��� ������ : "�亯��� �Ϸ�"�޽��� ��� ��, list.jsp�� ������ �̵� ��� ���н� :
 * "�亯��Ͻ� �����߻�"�޽��� ��� ��, replyForm.jsp�� ������ �̵��ϱ� 1. �Ķ���� ���� Board ��ü�� �����ϱ�
 * 
 * 
 * board.setBoardid(sesboardid); // �Է½� boardid �Է���
 * dao.refstepadd(board.getRef(), board.getRefstep()); // 3. Board ��ü�� db��
 * insert �ϱ�. String msg = "�亯��Ͻ� �����߻�"; String url = "replyForm?num=" +
 * board.getNum(); if (dao.insert(board)) { msg = "�亯��� �Ϸ�"; url = "list"; }
 * 
 * m.addAttribute("url", url); m.addAttribute("msg", msg);
 * 
 * return "alert"; }
 * 
 * }
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import service.NoticeDaoMybatis;
import model.Notice;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	NoticeDaoMybatis dao;
	
	@RequestMapping("test")
	public String pub(Model m) {
		m.addAttribute("test", "notice");// �� �׽�Ʈ�� index.jsp�� �׽�Ʈ
		return "index";
	}

	@RequestMapping("list")
	public String list(String page, Model m) throws Throwable {
		/*
		 * �Խù� ��� ���� 1. pageNum �Ķ���� ����. pageNum �Ķ���� ������ 1�� ����. 2. 10���� �Խù� ���. => db����
		 * �ش� �������� ��µǴ� �Խù��� ��ȸ. ���� : �ֱ� �Խù� ������ 3. ȭ�鿡 ���.
		 */
		System.out.println("list �Դϴ�");
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(page);
		} catch (NumberFormatException e) {
		}

		int limit = 10; // ���������� ����� �Խù� �Ǽ�
		
		int noticecount = dao.noticeCount();// ��ϵ� ��ü �Խù��� �Ǽ�

		List<Notice> list = dao.list(pageNum, limit, noticecount); // ȭ�鿡 ��µ� �Խù� ������
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
		m.addAttribute("list", list);
		m.addAttribute("noticenum", noticenum);
		m.addAttribute("startpage", startpage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endpage", endpage);
		m.addAttribute("maxpage", maxpage);
		m.addAttribute("pageNum", pageNum);

		return "notice/list";
	}

	@RequestMapping("info")
	public String info(int num, Model m) {
		/*
		 * : �Խù� �� ���� :board/info?num=41 1. num �Ķ���͸� �̿��Ͽ� db�� �ش� �Խù� ��ȸ Board board =
		 * new BoardDao().selectOne(num); 2. ��ȸ�� ������Ű��. readcnt+1 new
		 * BoardDao().readcntadd(num); 3. 1������ ��ȸ�� �Խù������͸� ȭ�鿡 ����ϱ�
		 */

		// �Ķ���Ͱ��б�
		
		Notice notice = dao.selectOne(num); // �Խù� ��ȸ
		dao.readcntadd(num); // ��ȸ�Ǽ�����
		m.addAttribute("notice", notice);
		m.addAttribute("num", num);
		return "notice/info";
	}

	@RequestMapping("updateForm")
	public String updateForm(int num, Model m) throws Throwable {
		/*
		 * /WebContent/model1/board/updateForm.jsp 1. num ���� �Խù��� ��ȸȭ�� ȭ�� ����ϱ�
		 */

		Notice notice = dao.selectOne(num);
		m.addAttribute("notice", notice);
		return "notice/updateForm";
	}
	
	@RequestMapping("writeForm")
	public String writeForm() throws Throwable {
		
		return "notice/writeForm";
	}

	@RequestMapping("deleteForm")
	public String deleteForm(int num, Model m) {
		m.addAttribute("num", num);
		return "/notice/deleteForm";
	}

	@RequestMapping("replyForm")
	public String replyForm(int num, Model m) throws Throwable {
		/*
		 * /WebContent/model1/board/replyForm.jsp : �亯�� ���� ȭ�� 1. ������ num�� �Ķ���ͷ� �޴´�. 2.
		 * ������ num,ref,reflevel,refstep ������ ���� 3. �Է� ȭ�� ǥ��
		 */
		
		Notice notice = dao.selectOne(num); // �Խù� ��ȸ

		m.addAttribute("notice", notice);

		return "/notice/replyForm";
	}

	/*
	 * kic.xml�� �丸 �����س��� �װ������ mapping�ص� ������
	 * 
	 * @RequestMapping("wirteForm") public String writeForm(HttpServletRequest
	 * request, HttpServletResponse response) throws Throwable {
	 * 
	 * return "/board/writeForm"; }
	 */

	@RequestMapping("write")
	public String write(MultipartHttpServletRequest request, Notice notice, Model m) throws Throwable {
		/*
		 * MultipartHttpServletRequest request, Board board <- �� ���ϵ��� �ڵ����� board��
		 * �÷���(multipartResolver�� xml�� �߰����� ���!) 1. �Ķ���� ���� model.Board ��ü ����. 2. �Խù� ��ȣ
		 * num ���� ��ϵ� num�� �ִ밪�� ��ȸ. �ִ밪 +1 ��ϵ� �Խù��� ��ȣ. db���� maxnum �� ���ؼ� +1 ������ num
		 * �����ϱ�
		 */
		// 1. �Ķ���� ���� model.Board ��ü ����.
		// String uploadpath = application.getRealPath("/") +"chap09_board/upfile/";
		String uploadpath = request.getServletContext().getRealPath("/upfile");
		MultipartFile multiFile = request.getFile("uploadfile");
		if (!multiFile.isEmpty()) {
			File file = new File(uploadpath, multiFile.getOriginalFilename());
			try {
				multiFile.transferTo(file);
				notice.setFile1(multiFile.getOriginalFilename());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			notice.setFile1("");
		}
		// 2. sequence nextval �Է�
		// db���� maxnum �� ���ؼ� +1 ������ num �����ϱ�
		
		// 3. board ��ü�� ������ db�� insert �ϱ�
		String msg = "�Խù� ��� ����";
		String url = "writeForm";
		if (dao.insert(notice)) {
			msg = "�Խù� ��� ����";
			url = "list";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "notice/alert";
	}

	@RequestMapping("update")
	public String update(MultipartHttpServletRequest request, Notice notice, Model m) throws Throwable {
		/*
		 * /WebContent/model1/board/update.jsp 1. �Ķ������������ Board ��ü ����. 2. ��й�ȣ ���� ��й�ȣ
		 * ��ġ : ��������. ��й�ȣ ����ġ : ��й�ȣ ���� �޼��� ����ϰ�, updateForm.jsp�� ������ �̵� 3. �������� : ��������
		 * �޽��� ��� �� list.jsp ������ �̵� �������� : �������� �޽��� ��� �� updateForm.jsp ������ �̵�
		 */
		System.out.println("0");
		String uploadpath = request.getServletContext().getRealPath("/upfile");
		MultipartFile multiFile = request.getFile("uploadfile");
		if (!multiFile.isEmpty()) {
			File file = new File(uploadpath, multiFile.getOriginalFilename());
			try {
				multiFile.transferTo(file);
				notice.setFile1(multiFile.getOriginalFilename());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			notice.setFile1("");
		}
		System.out.println("1");
		
		if (notice.getFile1() == null || notice.getFile1().equals("")) {
			notice.setFile1(request.getParameter("file2"));
		}
		
		Notice dbNotice = dao.selectOne(notice.getNum());
		String msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
		String url = "updateForm?num=" + notice.getNum();

		if (notice.getPass().equals(dbNotice.getPass())) {
			// �����ϱ�
			System.out.println("2");
			if (dao.update(notice)) {
				msg = "�Խù� ���� �Ϸ�";
				url = "list";
			} else {
				msg = "�Խù� ���� ����";
			}
		}
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);

		return "notice/alert";
	}
	
	@RequestMapping("delete")
	public String delete(int num, String pass, Model m) throws Throwable {
		/*
		 * /WebContent/model1/board/delete.jsp 1. num,pass �Ķ���͸� ������ ����. 2. �Էµ� ��й�ȣ�� db
		 * ��й�ȣ ���� Ʋ����� : ��й�ȣ ���� �޽��� ���, deleteForm.jsp ������ �̵� 3. �Խù� ����. ���� ���� : ���� ����
		 * �޽��� ���, list.jsp ������ �̵� ���� ���� : ���� ���� �޽��� ���, info.jsp ������ �̵�
		 */

		String msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�!";
		String url = "deleteForm?num=" + num;
		
		Notice notice = dao.selectOne(num);
		// board.getPass() : db�� ����� ��й�ȣ
		if (pass.equals(notice.getPass())) {
			if (dao.delete(num)) {
				msg = "�Խñ��� ���������� �����Ͽ����ϴ�.";
				url = "list";
			} else {
				msg = "�Խñ��� �����ϴµ� �����Ͽ����ϴ�!";
				url = "info?num=" + num;
			}
		}

		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "notice/alert";
	}
	@RequestMapping("reply")
	public String reply(Notice notice, Model m) throws Throwable {
		/*
		 * /WebContent/model1/board/reply.jsp : ��� ��� 1. �Ķ���� ���� Board ��ü�� �����ϱ� �������� :
		 * num, ref, reflevel(��), refstep(print) ������� : name, pass, subject, content 2.
		 * ���� ref ���� ����ϴ� �Խù����� refstep ���� 1 ���� ��Ű�� 1 1 0 0 2 2 0 0 3 1 1 2 4 1 1 1
		 * ======================== print 2 2 0 0 1 1 0 0 4 1 1 1 3 1 1 2 3. Board ��ü��
		 * db�� insert �ϱ�. 4. ��� ������ : "�亯��� �Ϸ�"�޽��� ��� ��, list.jsp�� ������ �̵� ��� ���н� :
		 * "�亯��Ͻ� �����߻�"�޽��� ��� ��, replyForm.jsp�� ������ �̵��ϱ� 1. �Ķ���� ���� Board ��ü�� �����ϱ�
		 */
		
		
		System.out.println("reply");
		
		System.out.println("dao");
		dao.refstepadd(notice.getRef(), notice.getRefstep());
		System.out.println("1");
		// 3. Board ��ü�� db�� insert �ϱ�.
		String msg = "�亯��Ͻ� �����߻�";
		String url = "replyForm?num=" + notice.getNum();
		
		if (dao.insert(notice)) {
			msg = "�亯��� �Ϸ�";
			url = "list";
		}

		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "notice/alert";
	}
}

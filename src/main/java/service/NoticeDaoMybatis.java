/*
 * package service;
 * 
 * 
 * import java.util.HashMap; import java.util.List; import java.util.Map;
 * 
 * 
 * import org.mybatis.spring.SqlSessionTemplate; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component; import
 * org.springframework.stereotype.Repository;
 * 
 * 
 * import model.Board;
 * 
 * @Component public class BoardDaoMybatis { private static final String
 * ns="mapper.BoardMapper."; private static Map map = new HashMap();
 * 
 * 
 * @Autowired SqlSessionTemplate sqlSession;
 * 
 * 
 * public int boardCount(String boardid) { int count =
 * sqlSession.selectOne(ns+"count", boardid);
 * 
 * return count; }
 * 
 * 
 * public List<Board> list(int pageNum, int limit, int boardcount, String
 * boardid) { // limit =3
 * 
 * // --------------------------------- int start = (pageNum - 1) * limit + 1;
 * int end = start + limit - 1; map.clear(); map.put("start", start);
 * map.put("end", end); map.put("boardid", boardid);
 * 
 * List<Board> list = sqlSession.selectList(ns+"list", map);
 * 
 * 
 * return list; } public boolean insert(Board board) {
 * 
 * 
 * int num = sqlSession.selectOne(ns+"max"); if (board.getNum() > 0) { //답글
 * board.setRef(board.getRef()); board.setReflevel(board.getReflevel() + 1);
 * board.setRefstep(board.getRefstep() + 1); } else { //새글 board.setRef(num); }
 * 
 * board.setNum(num); if (board.getFile1()==null) board.setFile1("");
 * 
 * int count = sqlSession.insert(ns+"insert", board);
 * 
 * if (count>0) return true; else return false;
 * 
 * } public Board selectOne(int num) {
 * 
 * Board board = (Board) sqlSession.selectOne(ns+"selectOne", num);
 * 
 * return board; }
 * 
 * public void readcntadd(int num) {
 * 
 * sqlSession.update(ns+"readcntadd", num);
 * 
 * }
 * 
 * public boolean update(Board board) {
 * 
 * int count = sqlSession.insert(ns+"update", board);
 * 
 * if (count>0) return true; else return false; }
 * 
 * 
 * public boolean delete(int num) {
 * 
 * int count = sqlSession.insert(ns+"delete", num);
 * 
 * if (count>0) return true; else return false; }
 * 
 * public void refstepadd(int ref, int refstep) {
 * 
 * map.clear(); map.put("ref", ref); map.put("refstep", refstep); int count =
 * sqlSession.update(ns+"refstepadd", map); } } //end class
 */
package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Notice;

@Repository
 public class NoticeDaoMybatis {
	 private static final String ns="mapper.NoticeMapper.";
	 private static Map map = new HashMap();
	
	 @Autowired
	 SqlSessionTemplate session;
	 
	 
	 public int noticeCount() {
		int count = (Integer) session.selectOne(ns+"count");
		return count;
	}
	
	
	public List<Notice> list(int pageNum, int limit, int noticecount) { // limit =3
		
		
		// ---------------------------------
		int start = (pageNum - 1) * limit + 1;
		int end = start + limit - 1;
		map.clear();
		map.put("start", start);
		map.put("end", end);
		List<Notice>  list = session.selectList(ns+"list", map);
		
		
		return list;
	}
	public boolean insert(Notice notice) {
		
		
		int num = (Integer) session.selectOne(ns+"max");
		if (notice.getNum() > 0) {  //답글
			notice.setRef(notice.getRef());
			notice.setReflevel(notice.getReflevel() + 1);
			notice.setRefstep(notice.getRefstep() + 1);
		} else {  //새글
			notice.setRef(num);
		}
		
		notice.setNum(num);
		if (notice.getFile1()==null)  notice.setFile1("");
		
		int count = session.insert(ns+"insert", notice);
		
		if (count>0)  return true;
		else return false;
		
	}
	public Notice selectOne(int num) {
        
		Notice  notice = (Notice) session.selectOne(ns+"selectOne", num);
		
		return notice;
	}
	
	public void readcntadd(int num) {
		 
			session.update(ns+"readcntadd", num);
			
	}
	
	public boolean update(Notice notice) {
		
		int count = session.insert(ns+"update", notice);
		
		if (count>0)  return true;
		else return false;
	}
	
	
	public boolean delete(int num) {
		
		int count = session.insert(ns+"delete", num);
		
		if (count>0)  return true;
		else return false;
	}
	
	public void refstepadd(int ref, int refstep) {
		
		System.out.println("stepadd");
		map.clear();
		map.put("ref", ref);
		map.put("refstep", refstep);
		int count = session.insert(ns+"refstepadd", map);
		System.out.println("2");
	}
}  //end class

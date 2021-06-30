package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Letter;
import model.MemberL;
import model.Notice;
import model.Schedule;

@Repository
public class LetterDaoMybatis {
	private static final String ms = "mapper.LetterMapper.";

	@Autowired
	SqlSessionTemplate sqlSession;

	public List<Letter> listletter() { // limit =3

		// ---------------------------------
		List<Letter> listletter = sqlSession.selectList(ms + "list");

		return listletter;
	}

	public boolean letterinsert(Letter letter) {

		int num = (Integer) sqlSession.selectOne(ms + "max");
		letter.setEML_SQ(num);
		if (letter.getEML_PL_NM() == null)
			letter.setEML_PL_NM("");
		int count = sqlSession.insert(ms + "letterinsert", letter);

		if (count > 0)
			return true;
		else
			return false;
	}

	public boolean letterdelete(Letter letter) {
		System.out.println("mapper삭제전");

		System.out.println("mapper접속전");
		sqlSession.delete(ms + "letterdelete", letter);
		System.out.println("mapper삭제");

		return true;
	}

	public boolean delete(String ajaxMsg) {
		System.out.println("mapper전");
		sqlSession.update(ms + "delete", ajaxMsg);
		System.out.println("mapper후");
		return true;
	}

	public boolean delete1(String ajaxMsg) {
		System.out.println("mapper전");
		sqlSession.update(ms + "delete1", ajaxMsg);
		System.out.println("mapper후");
		return true;
	}

	public MemberL letterselectOne(String STF_ID) {
		System.out.println("STF_ID:" + STF_ID);
		MemberL m = sqlSession.selectOne(ms + "selectOnestf_tb", STF_ID);
		return m;
	}

	public void readcntadd(int num) {
		sqlSession.update(ms + "readcntadd", num);
	}

	public Letter selectOne(int num) {// eml_sq 편지번호 int
		Letter letter = (Letter) sqlSession.selectOne(ms + "selectOne", num);
		return letter;
	}

	public boolean insert(MemberL mem) {
		// int num = (Integer) session.selectOne(ms+"max");
		int count = sqlSession.insert(ms + "insert", mem);
		if (count > 0)
			return true;
		else
			return false;
	}

	public boolean cmtinsert(MemberL mem) {
		int count = sqlSession.insert(ms + "cmtinsert", mem);
		if (count > 0)
			return true;
		else
			return false;
	}

	public List<MemberL> memlist() { // limit =3
		List<MemberL> listmember = sqlSession.selectList(ms + "memlist");
		return listmember;
	}

	public boolean memdelete(String id) {
		sqlSession.delete(ms + "memdelete", id);
		return true;
	}

	public boolean cmtdelete(String id) {
		sqlSession.delete(ms + "cmtdelete", id);
		return true;
	}

	public boolean memupdate(MemberL mem) {
		int count = sqlSession.insert(ms + "memupdate", mem);
		if (count > 0)
			return true;
		else
			return false;
	}
	
	public List<Schedule> scheduleList() { // limit =3
		List<Schedule> schedule = sqlSession.selectList(ms + "scheduleList");
		return schedule;
	}

	public boolean addSchedule(Schedule schedule) {
		System.out.println("스케쥴");
		int num = (Integer) sqlSession.selectOne(ms + "smax");
		schedule.setSchedule_sq(num);
		int count = sqlSession.insert(ms + "addSchedule", schedule);
		System.out.println("끝");
		if (count > 0)
			return true;
		else
			return false;
	}
	
	public boolean scheduleDelete(String id) {
		sqlSession.delete(ms + "scheduleDelete", id);
		return true;
	}
	
	
	public Schedule scheduleselectOne(String schedule_sq) {
		System.out.println("schedule_sq:" + schedule_sq);
		Schedule schedule = sqlSession.selectOne(ms + "selectOneschedule_tb", schedule_sq);
		return schedule;
	}
	
public boolean scheduleUpdate(Schedule schedule) {
		System.out.println("2");
		int count = sqlSession.update(ms+"scheduleUpdate", schedule);
		System.out.println("3");
		if (count>0)  return true;
		else return false;
	}
}

// end class

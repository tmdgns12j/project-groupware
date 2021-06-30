package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.MemberL;

@Repository
public class CalendarDao {
	private static final String ms = "mapper.CalendarMapper.";

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<MemberL> memberlist() { // limit =3		
		List<MemberL> memberlist = sqlSession.selectList(ms + "list");
		return memberlist;
	}
	
	public MemberL selectOne(String id) {// eml_sq 편지번호 int		
		MemberL memberlist= sqlSession.selectOne(ms + "selectOne", id);
		return memberlist;
	}
	public String selectbirth(String id) {
		String birth= sqlSession.selectOne(ms + "selectbirth", id);
		return birth;
	}
	public List<MemberL> selectBM() {
		List<MemberL> birthM= sqlSession.selectList(ms + "selectBM");
		return birthM;
	}
	public List<MemberL> selectBD() {
		List<MemberL> birthD= sqlSession.selectList(ms + "selectBD");
		return birthD;
	}
	public List<MemberL> selectName() {
		List<MemberL> birthName= sqlSession.selectList(ms + "selectName");
		System.out.println("sd");
		System.out.println(birthName);
		return birthName;
	}
}

package service;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Commute;
@Repository
public class CommuteDaoMybatis {
	private static final String ms="mapper.CommuteMapper.";
	
	 @Autowired
	 SqlSessionTemplate  sqlSession;
	 
	 public Date starttime(String stf_id) {
		 sqlSession.update(ms+"starttime", stf_id);
		 Date starttm = sqlSession.selectOne(ms+"StartCmt_tb", stf_id);
		 System.out.println(starttm);
		 return starttm;
	 }
	 
	 public Date endtime(String stf_id) {
		 sqlSession.update(ms+"endtime", stf_id);
		 Date endtm = sqlSession.selectOne(ms+"EndCmt_tb", stf_id);
		 System.out.println(endtm);
		 return endtm;
	 }

}

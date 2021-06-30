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

import model.Mail;
import model.Mail2;
import model.MemberL;

@Repository
 public class MailDaoMybatis {
	 private static final String ms="mapper.MailMapper.";
	 private static Map map = new HashMap();
	
	 @Autowired
	 SqlSessionTemplate  sqlSession;
	 
	public List<Mail> listmail() { // limit =3
	   
	      
	      // ---------------------------------
	      List<Mail>  listmail = sqlSession.selectList(ms+"list");
	 
	      
	      return listmail;
	   }

	public boolean mailinsert(Mail mail) {
		
		int num = (Integer) sqlSession.selectOne(ms+"max");
		mail.setNum(num);
		int count = sqlSession.insert(ms+"mailinsert", mail);

		if (count>0)
			return true;
		else
			return false;		
	}


	public boolean maildelete(Mail2 mail) {
		System.out.println("mapper삭제전");

		System.out.println("mapper접속전");
		sqlSession.delete(ms + "maildelete", mail);
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
 
	public MemberL mailselectOne(String STF_ID) {
		System.out.println("STF_ID:"+STF_ID);
		MemberL m = sqlSession.selectOne(ms+"selectOnestf_tb", STF_ID);
		return m;		
	}
	
	public void readcntadd(int num) {
		sqlSession.update(ms + "readcntadd", num);
	}
	
	public Mail2 selectOne(int num) {// eml_sq 편지번호 int
		Mail2 mail = (Mail2) sqlSession.selectOne(ms + "selectOne", num);
		return mail;
	}
}
 
 
 //end class

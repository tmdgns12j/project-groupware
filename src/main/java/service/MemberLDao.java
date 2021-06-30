package service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MemberL;

@Repository
public class MemberLDao {
	private static final String ms="mapper.MemberLMapper.";
	
	@Autowired
	SqlSessionTemplate session;
	
	public boolean insert(MemberL mem) {
		//int num = (Integer) session.selectOne(ms+"max");
		int count = session.insert(ms+"insert", mem);
		if(count > 0) return true;
		else return false;
	}
}

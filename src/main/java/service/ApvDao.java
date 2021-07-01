package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Apv;

@Repository
public class ApvDao {
	 private static final String as="mapper.ApvMapper.";
	 @Autowired
	 SqlSessionTemplate  sqlSession;
	 
	 public List<Apv> list() {//리스트 불러오기
	      List<Apv>  list = sqlSession.selectList(as+"list");
	      return list;
	 }
	 
	 public boolean insert(Apv apv) {
		 int num = (Integer) sqlSession.selectOne(as+"max");//dual에서 번호 불러움
		 apv.setAPV_SQ(num);//번호 저장
		 apv.setAPV_OK_SQ(num);
		 int count = sqlSession.insert(as+"insert",apv);//결재정보 삽입
		 if(count>0)
			 return true;
		 else
			 return false;
	 }
	 
	 public Apv selectOne(int num) {//해당하는 번호(결재목록)불러옴
		 Apv apv = (Apv) sqlSession.selectOne(as+"selectOne", num);
		 return apv;
	 }
	 
	 public boolean update(Apv apv) {//중간승인자 확인
		 int count = (Integer) sqlSession.insert(as+"update", apv);
		 if(count > 0)	return true;
		 else	return false;
	 }
	 public boolean fnlupdate(Apv apv) {//최종승인자 확인
		 int count = (Integer) sqlSession.insert(as+"fnlupdate", apv);
		 if(count > 0)	return true;
		 else	return false;
	 }
}

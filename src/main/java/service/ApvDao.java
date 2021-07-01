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
	 
	 public List<Apv> list() {//����Ʈ �ҷ�����
	      List<Apv>  list = sqlSession.selectList(as+"list");
	      return list;
	 }
	 
	 public boolean insert(Apv apv) {
		 int num = (Integer) sqlSession.selectOne(as+"max");//dual���� ��ȣ �ҷ���
		 apv.setAPV_SQ(num);//��ȣ ����
		 apv.setAPV_OK_SQ(num);
		 int count = sqlSession.insert(as+"insert",apv);//�������� ����
		 if(count>0)
			 return true;
		 else
			 return false;
	 }
	 
	 public Apv selectOne(int num) {//�ش��ϴ� ��ȣ(������)�ҷ���
		 Apv apv = (Apv) sqlSession.selectOne(as+"selectOne", num);
		 return apv;
	 }
	 
	 public boolean update(Apv apv) {//�߰������� Ȯ��
		 int count = (Integer) sqlSession.insert(as+"update", apv);
		 if(count > 0)	return true;
		 else	return false;
	 }
	 public boolean fnlupdate(Apv apv) {//���������� Ȯ��
		 int count = (Integer) sqlSession.insert(as+"fnlupdate", apv);
		 if(count > 0)	return true;
		 else	return false;
	 }
}

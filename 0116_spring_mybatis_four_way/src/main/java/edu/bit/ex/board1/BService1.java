package edu.bit.ex.board1;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class BService1 {
	
	//@Autowired�� �ص� �������
	@Inject
	SqlSession sqlSession;	
	//mybatis��ü !!!
	//new�ؼ� ���ο� ��ü�� �����ϴ°� �ƴ϶� root-context.xml�� �ִ� SQLSession ��ü�� �ּҸ� �������°�! ������ ����............! ! 
	
	public List<BoardVO> selectBoardList() throws Exception{
		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.listDao();
	}
	
	

	

}

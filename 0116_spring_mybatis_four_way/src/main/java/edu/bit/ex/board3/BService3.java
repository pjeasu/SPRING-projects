package edu.bit.ex.board3;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class BService3 {
	
	@Inject
	BoardMapper boardMapper;
	//���̹�Ƽ���� ������ ��ü.. �������̽��� scan�ؼ�.. �ش� ��ü�� ����°�...

	public List<BoardVO> selectBoardList() throws Exception{
		return boardMapper.selectBoardList();
		
	}
}


package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {//����Ͻ�����~~~
	
	@Autowired
	BoardMapper boardMapper;
	
	//�Խ��� List�� ����ϱ� ���� ����
	public List<BoardVO> selectBoardList(){
		return boardMapper.selectBoardList();
	}
	
	
	//�Խ��ǿ��� ������ ���� ����
	public void writeReply(BoardVO boardVO) {
		
		//step�� indent�� +1 ���ִ� ���� �ʿ� 
		boardMapper.updateShape(boardVO);
		boardMapper.insertReply(boardVO);
	}

	//���ۼ�
	public void insertBoard(BoardVO boardVO) {
		boardMapper.insertBoard(boardVO);

	}

	//�ۺ���
	public BoardVO selectBoardOne(String bId) {
		boardMapper.upHit(bId);
		return boardMapper.selectBoardOne(bId);
	}
	
	//�ۼ���
	public void updateBoard(BoardVO boardVO) {
		boardMapper.updateBoard(boardVO);
	}
	
	//�ۻ���
	public void delete(BoardVO boardVO) {
		boardMapper.delete(boardVO);
	}


	public int selectCountBoard() {
		return boardMapper.selectCountBoard();
	}


	public List<BoardVO> selectBoardListPage(Criteria criteria) {
		return boardMapper.selectBoardListPage(criteria);
	}
	
}

package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.mapper.EmpMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.EmpVO;

@Service
public class EmpService {//����Ͻ�����~~~
	
	@Autowired
	EmpMapper empMapper;
	
	public List<EmpVO> selectBoardList(){
		return empMapper.selectBoardList();
	}
	
	
//	//�Խ��ǿ��� ������ ���� ����
//	public void writeReply(BoardVO boardVO) {
//		
//		//step�� indent�� +1 ���ִ� ���� �ʿ� 
//		boardMapper.updateShape(boardVO);
//		boardMapper.insertReply(boardVO);
//	}
//
//	//���ۼ�
//	public void insertBoard(BoardVO boardVO) {
//		boardMapper.insertBoard(boardVO);
//
//	}
//
	//�ۺ���
	public EmpVO selectBoardOne(String empno) {
		return empMapper.selectBoardOne(empno);
	}
//	
//	//�ۼ���
//	public void updateBoard(BoardVO boardVO) {
//		boardMapper.updateBoard(boardVO);
//	}
//	
//	//�ۻ���
//	public void delete(BoardVO boardVO) {
//		boardMapper.delete(boardVO);
//	}
//
//
//	public int selectCountBoard() {
//		return boardMapper.selectCountBoard();
//	}
//
//
//	public List<BoardVO> selectBoardListPage(Criteria criteria) {
//		return boardMapper.selectBoardListPage(criteria);
//	}
	
}

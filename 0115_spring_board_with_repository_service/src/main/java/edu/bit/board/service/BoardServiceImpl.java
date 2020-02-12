package edu.bit.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.dao.BoardDAO;
import edu.bit.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	BoardDAO boardDAO;
	//��ü�� �ڵ����� ����
	//BoardDAO boardDAO = new BoardDAO();
	//Ioc �����̳ʿ��� �����ϰԵ�
	
	
	@Override
	public List<BoardVO> getBoardList() {
		
		return boardDAO.getBoardList();
	}
	
	
	@Override
	public int boardWrite(String bName, String bTitle, String bContent) {
		
		return boardDAO.write(bName, bTitle, bContent);
	}


	@Override
	public BoardVO contentView(String bId) {
		
		return boardDAO.contentView(bId);
	}
	
}


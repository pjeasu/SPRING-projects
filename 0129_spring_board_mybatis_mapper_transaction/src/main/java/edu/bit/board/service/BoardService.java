package edu.bit.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

//객체 생성을 위한 어노테이션 주의(까먹으면 곤란해짐)
//서비스에서는 비즈니스 로직이 들어감
@Service
public class BoardService {
	@Inject
	BoardMapper boardMapper;
	
    public List<BoardVO> selectBoardList()  {
		return boardMapper.selectBoardList();
    }
    
	//@Transactional(propagation=Propagation.REQUIRES_NEW)  
	//@Transactional()  
    public void insertBoard(BoardVO boardVO)  {
    	boardMapper.insertBoard(boardVO);
    	
    	System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
    }

    public BoardVO selectBoardOne(String bId)  {
		return boardMapper.selectBoardOne(bId);
    }
    
    public List<BoardVO> selectBoardListPage(Criteria criteria)  {
		return boardMapper.selectBoardListPage(criteria);
    }
    
    public int selectAllBoard() {
		return boardMapper.selectAllBoard();
    }
    
    public void updateShape(BoardVO param)  {
    	boardMapper.updateShape(param);
    }
    
    public void insertReply(BoardVO param)  {
    	boardMapper.insertReply(param);
    }
    
    //트랜잭션 테스트
    //@Transactional
    public void transactionTest(BoardVO boardVO) {
    	insertBoard(boardVO);
    	//service단에는 비즈니스 로직이 들어간다. 넓은 범위에서는 트랜젝션 단위 하나가 비즈니스 로직이 됨 
    	//트랜잭션은 service안에 ! 
    
    	boardVO = null;
    	
    	insertBoard(boardVO);     	
    }
    
  
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
    @Transactional()
	public void tranTest() 
	{
		
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
/*		
		try {*/
			
			BoardVO bo = new BoardVO();
			bo.setbName("bName");
			bo.setbContent("bContent");
			bo.setbTitle("bTitle");	
			
			boardMapper.insertBoard(bo);
			bo=null;
			boardMapper.insertBoard(bo);	
			
/*		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/

	}
    
    /*
    public List<BoardVO> selectBoardListPage(Criteria criteria)  {
		return sqlSession.selectList("selectBoardListPage",criteria);
    }
    
    public int selectTotal() throws Exception {
		return sqlSession.selectOne("selectTotal");
    }
    
    public void updateShape(BoardVO param) throws Exception {
		sqlSession.insert("updateShape", param);
    }
    
    public void insertReply(BoardVO param) throws Exception {
		sqlSession.insert("insertReply", param);
    }
    
    public void updateBoard(BoardVO param) throws Exception {
		sqlSession.insert("updateBoard1", param);
    }
     
    public BoardVO selectBoardOne(String bId) throws Exception {
		return sqlSession.selectOne("selectBoardOne", bId);
    }
    public void deleteBoardOne(String bId) throws Exception {
		sqlSession.delete("deleteBoardOne", bId);
    }
    */


    
}
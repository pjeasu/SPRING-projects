package edu.bit.ex.board4;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper4 {

	public List<BoardVO> selectBoardList();
	
	@Select("select bid from mvc_board order by bGroup desc, bStep asc")
	public List<BoardVO> selectBoardList_();
	//����°, �׹�° ����� ���� ����ϴ°� ��κ��̴�.
	//���������δ� BoardVO ��ü�� ������... �÷���� BoardVo�� �������� ���缭 setter�Լ��� ȣ���� ���� �����ϴ°� 
	//bid�� �ҷ��͵� �� ���� �Է��ϰ� ������ ���� �Է����� �����Ƿ� ������ ���� �ʰ� bid�� ��µȴ� 
	
	
	public void selectBoardWrite();
}


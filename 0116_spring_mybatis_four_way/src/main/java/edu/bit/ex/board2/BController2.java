package edu.bit.ex.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//�ι�° ���
//1. interface�� �ʿ����
//2. sqlSession���� �����ϴ� �Լ�(selectList, selectOne..)�� �̿���
//3. ���������� ���� XML�� �ʿ���. �ش� XML�� namespace�� �����ڰ� ���Ѵ�.

@Controller
public class BController2 {
	
	@Autowired
	BService2 bservice;
	
	@RequestMapping("/list2")
	public String list2(Model model) throws Exception{
		System.out.println("list2()");
		
		model.addAttribute("list", bservice.selectBoardList());
		return "list";
	}
	
	
}

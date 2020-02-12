package edu.bit.ex.board4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//�׹�° ���
//1. ù��°�� ���� �����, ��� sqlSession.getMapper �Լ��� ������� �ʴ´�.
//2. �����ϰ�,, �����ϴ�,,
//3. <!-- 	Mapper Interface -->
//	 <mybatis-spring:scan base-package="edu.bit.ex.*"/> 
//	 root-context.xml�� �߰��ؾ���
//	 xml������ �д°� �ƴ϶� �������̽��� �о����

//ù��° �ι�° ����� �����ҽ����� ���� �����ְ� ������ �׹�°�� ���� ���� ����Ѵ�

@Controller
public class BController4 {
	
	@Autowired
	BService4 bservice;
	
	@RequestMapping("/list4")
	public String list4(Model model) throws Exception{
		System.out.println("list4()");
		
		model.addAttribute("list", bservice.selectBoardList());
		return "list";
	}
	

	
	
}

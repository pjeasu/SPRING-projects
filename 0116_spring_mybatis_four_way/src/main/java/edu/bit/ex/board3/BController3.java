package edu.bit.ex.board3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//����° ���
//1. �������̽� �ȿ� �ִ� �޼ҵ忡 @�� ���̴� ���
//2. XML���ϰ�, sqlSession ��ü �ʿ����
//3. ������ ������� ����ϱ� �����
//4. <!-- 	Mapper Interface -->
//	 <mybatis-spring:scan base-package="edu.bit.ex.*"/> 
//	 root-context.xml�� �߰��ؾ���
//	 xml������ �д°� �ƴ϶� �������̽��� �о����

@Controller
public class BController3 {
	
	@Autowired
	BService3 bservice;
	
	@RequestMapping("/list3")
	public String list3(Model model) throws Exception{
		System.out.println("list3()");
		
		model.addAttribute("list", bservice.selectBoardList());
		return "list";
	}
	
	
}

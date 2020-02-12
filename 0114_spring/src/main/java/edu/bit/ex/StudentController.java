package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.member.Member;
import edu.bit.ex.student.StudentInformation;

//14��

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("student/index")
	public String index() {
		logger.info("index");

		return "student/index";
	}
	
	//post ������� �ޱ����ؼ� �Ķ���� 2���� �޾ƾ��Ѵ� �׷������ؼ��� value, method �������� �޾ƾ���
	//����Ʈ ������ �޼ҵ带 �ްڴٴ� �� 
	@RequestMapping(value= "student/student", method = RequestMethod.POST)
	public String student(HttpServletRequest req, Model model) {
		logger.info("RequestMethod.POST");//������ڵ�
		
		String id = req.getParameter("id");
		System.out.println("id : " + id);
		
		model.addAttribute("id", id);
		
		return "student/student";
	}
	
	//Get ������ �޼ҵ常 �ްڴٴ� �� 
	//�Լ��̸��� ������ �Ķ������ ������ �ٸ���, ����Ÿ���� �ٸ��Ƿ� ���� > �����ε�
	@RequestMapping(value= "student/student", method = RequestMethod.GET)
	public ModelAndView student(HttpServletRequest req) {
		logger.info("RequestMethod.GET");//������ڵ�
		
		String id = req.getParameter("id");
		System.out.println("id : " + id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("student/student");
		
		return mv;
	}
	
	@RequestMapping("student/index2")
	public String index2() {
		logger.info("index2");

		return "student/index2";
	}
	

	//Ŀ�ǵ� ��ü �̸��� �ʹ� �涧, ��ü�� �̸��� �����Ҽ��ִ�
	@RequestMapping("student/studentView")
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInformation) {
		logger.info("studentView");
		//post, get ����� �������� �ʾƵ�, Ŀ�ǵ� ��ü�� post ��������!

		return "student/studentView";
	}
	
	
	
	
	
}

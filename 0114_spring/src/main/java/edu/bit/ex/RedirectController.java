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

//13��

/**
 * Handles requests for the application home page.
 */
@Controller
public class RedirectController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);

	
	@RequestMapping("student/studentConfirm")
	public String studentRedirect(HttpServletRequest req, Model model) {
		logger.info("StudentConfirm");
		String id = req.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
			//�տ� redirect, forward �� �ٰԵǸ� studentOk.jsp�� �ƴ�  �ش� �̸��� ���� �޼ҵ�� �̵���
			//redirect�� �ּҰ� �ٲ��, forward�� �ٲ��� �ʴ´�.
		}
		return "redirect:studentNg";
	}
	
	
	@RequestMapping("student/studentOk")
	public String studentOk(Model model) {
		
		return "student/studentOk";
	}
	@RequestMapping("student/studentNg")
	public String studentNg(Model model) {
		
		return "student/studentNg";
	}
	
}





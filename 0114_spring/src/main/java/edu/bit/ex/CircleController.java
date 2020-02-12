package edu.bit.ex;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.bit.ex.circle.Circle;


//��������

/**
 * Handles requests for the application home page.
 */
@Controller
public class CircleController {

	private static final Logger logger = LoggerFactory.getLogger(CircleController.class);

	
	@RequestMapping("circle/circle")
	public String circle() {
		logger.info("circle");
		return "circle/circle";
	}
	
	
	@RequestMapping("circle/area")
	public String circle(Circle circle) { 
		logger.info("area");
		return "circle/area";
	}
	
	
//	@RequestMapping("circle/area")
//	public String area(HttpServletRequest req, Model model) { 
//		logger.info("area");
//
//		String radius = req.getParameter("radius");
//		String width = req.getParameter("width");
//		String height = req.getParameter("height");
//		double area = Integer.parseInt(radius) *Integer.parseInt(radius)* Math.PI;
//		int area2 = Integer.parseInt(width) * Integer.parseInt(height);
//		model.addAttribute("radius", radius);
//		model.addAttribute("area", area);
//		model.addAttribute("area2", area2);
//		model.addAttribute("height", height);
//		model.addAttribute("width", width);
//		return "circle/area";
//	}

	//form �±׿��� �� �������� ��� ������! 
	//.getParameter
	//������̼�
	//Ŀ�ǵ尴ü >> �ɼ������� Ŀ�ǵ� ��ü ����!!!
	
	
	
}

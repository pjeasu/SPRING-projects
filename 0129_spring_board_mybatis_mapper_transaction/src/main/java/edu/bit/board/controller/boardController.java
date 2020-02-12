package edu.bit.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageMaker;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class boardController {
	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		System.out.println("list()");
		model.addAttribute("list", boardService.selectBoardList());
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	

	@RequestMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception {
		System.out.println("write()");
		
		boardService.transactionTest(boardVO);
				
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) throws Exception{
		System.out.println("content_view()");

		String bId = request.getParameter("bId");		
		model.addAttribute("content_view", boardService.selectBoardOne(bId));
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST )
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) throws Exception{
		System.out.println("reply_view()");

		String bId = request.getParameter("bId");		
		model.addAttribute("reply_view", boardService.selectBoardOne(bId));
		return "reply_view";
	}
	
	//@Transactional(rollbackFor=Exception.class)
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO,HttpServletRequest request, Model model) throws Exception {
		System.out.println("reply()");

		//controller단에는 transaction이 들어가면 안됨... 다 service에 있어야한다. 
		
		boardService.updateShape(boardVO);
		

		boardVO.setbName(null);
		boardService.insertReply(boardVO);	
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) throws Exception {
		System.out.println("delete()");

		//String bId = request.getParameter("bId");
		//boardService.deleteBoardOne(bId); 
		
		return "redirect:list";
	}
	
	@RequestMapping("/list2")
	public void list3(Criteria criteria, Model model) throws Exception {
		System.out.println("list2()");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		System.out.println(criteria.getPerPageNum());
		System.out.println(criteria.getPage());
		
   
	    int totalCount = boardService.selectAllBoard();
	    System.out.println(totalCount);
	    System.out.println("��ü �Խù� ���� ����:" + totalCount);
		pageMaker.setTotalCount(totalCount);
       
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria); 
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageMaker", pageMaker);

		//return "redirect:list";
	}
	
}
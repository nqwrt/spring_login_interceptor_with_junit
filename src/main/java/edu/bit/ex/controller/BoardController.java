package edu.bit.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.service.LoginService;
import edu.bit.ex.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(HttpSession session,Model model) throws Exception{
		System.out.println("list()");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		/* 첫번째 방법
		if(member == null) {
			System.out.println("멤버세션값 없음");
			return "redirect:/";
		}*/
		
		model.addAttribute("list", boardService.selectBoardList());
		return "list";
	}
}

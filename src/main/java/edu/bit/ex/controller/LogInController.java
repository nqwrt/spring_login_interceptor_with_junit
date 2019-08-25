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

import edu.bit.ex.service.LoginService;
import edu.bit.ex.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/member")
public class LogInController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogInController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	LoginService loginService;
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req,RedirectAttributes rttr) throws Exception {
		
		logger.info("post login");
		 
		 //Session 처리를 위한 Session 객체 HttpServletRequest 안에 있음
		HttpSession session = req.getSession();
		 
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		 
		MemberVO login = loginService.logInMember(id,pw);
		 
		if(login == null) {
		  session.setAttribute("member", null);
		/*
			Spring3 에서 제공하는 RedirectAttributes를 사용하면 
			redirect post 구현이 가능합니다.
	
			하지만 일회성입니다. 
			새로고침하면 날라가는 데이터이므로 사용목적에 따라서 사용/불가능 판단을 잘 하셔야 할거 같습니다.
		 */
		  rttr.addFlashAttribute("msg", false);
		} else {
		  session.setAttribute("member", login);
		}
		


		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		logger.info("/member/logout");
		 
		session.invalidate();
		   
		   
		return "redirect:/";
	}
	
}

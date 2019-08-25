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
	
	// �α���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req,RedirectAttributes rttr) throws Exception {
		
		logger.info("post login");
		 
		 //Session ó���� ���� Session ��ü HttpServletRequest �ȿ� ����
		HttpSession session = req.getSession();
		 
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		 
		MemberVO login = loginService.logInMember(id,pw);
		 
		if(login == null) {
		  session.setAttribute("member", null);
		/*
			Spring3 ���� �����ϴ� RedirectAttributes�� ����ϸ� 
			redirect post ������ �����մϴ�.
	
			������ ��ȸ���Դϴ�. 
			���ΰ�ħ�ϸ� ���󰡴� �������̹Ƿ� �������� ���� ���/�Ұ��� �Ǵ��� �� �ϼž� �Ұ� �����ϴ�.
		 */
		  rttr.addFlashAttribute("msg", false);
		} else {
		  session.setAttribute("member", login);
		}
		


		return "redirect:/";
	}

	// �α׾ƿ�
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		logger.info("/member/logout");
		 
		session.invalidate();
		   
		   
		return "redirect:/";
	}
	
}

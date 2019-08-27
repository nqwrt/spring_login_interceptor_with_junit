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
@RequestMapping("/error")
public class ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	LoginService loginService;
	
	// �α���
	@RequestMapping(value = "/404")
	public String login(HttpServletRequest req,RedirectAttributes rttr) throws Exception {
		
		/*404 ���� �߻��� ó���� ������ ������ ó���� ��Ŵ*/
		
		return "error/error404";
	}
}

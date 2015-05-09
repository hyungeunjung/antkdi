package com.konantech.gw.business.login.contoller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.konantech.gw.business.authentic.CustomUserDetails;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	

	
	/*@RequestMapping(value = "/loginProcess.do", method = RequestMethod.GET)
	public String loginProcess(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.debug("로그인프로세스");
	   
		return "home";
	}*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(HttpSession session) {
		logger.info("Welcome login! /login {}", session.getId());
		logger.debug("jUnit Test");
		
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("logOutController");
		CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
		
		logger.info("Welcome logout! {}", session.getId());
		logger.info("Welcome logout! {}", userDetails.getUsername());
		
		
		session.invalidate();
		
		logger.debug("삭제한뒤"+session.getId());
		logger.debug("삭제한뒤"+userDetails.getUsername());
		return "login/logout";
	}
	
	@RequestMapping(value = "login_success", method = RequestMethod.GET)
	public String login_success(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
		return "login/login_success";
	}
	
	@RequestMapping(value = "page1", method = RequestMethod.GET)
	public void page1() {		
	}
	
	@RequestMapping(value = "login_duplicate", method = RequestMethod.GET)
	public void login_duplicate() {		
		logger.info("Welcome login_duplicate!");
	}

}

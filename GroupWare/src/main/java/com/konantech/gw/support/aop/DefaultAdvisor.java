package com.konantech.gw.support.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class DefaultAdvisor {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultAdvisor.class);
	
	//Pointcut to execute on all the methods of classes in a package    
	/*@Pointcut("within(com.konantech.gw.business.main.controller.*)")    
	public void allMethodsPointcut(){}*/

	//com.konantech.gw.main.controller;@Before("execution(* getUserInfo(..))") 
	//@Before("@annotation(com.konantech.gw.business.main.controller.MainController)") 
	/*@Before("allMethodsPointcut()")    
	public void allServiceMethodsAdvice(){        
		System.out.println("컨트롤러진입전");    
		}*/

	@After("execution(* com.konantech.gw.business.main.controller.MainController.*(..))")
	public void afterController(){
		logger.debug("컨트롤러 진입");
	}

}

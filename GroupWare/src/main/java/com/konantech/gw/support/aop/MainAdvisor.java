package com.konantech.gw.support.aop;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MainAdvisor {

	private static final Logger logger = LoggerFactory.getLogger(MainAdvisor.class);

	
	/**
	 * 컨트롤러 AOP
	 */
	/*@Pointcut("execution(* com.konantech.gw.business.main.controller.*(..))")
	public void mainControllerPointCut(){}*/
	
	
	/*@Before("mainControllerPointCut()")
	public void startContorller(){
		System.out.println("시작");
	}*/
	
	/**
	 * 포인트컷 생성 getUserInfo 메서드에 대해서 포인트컷을 설정한다.
	 * 포인트컷으로 명시된 메소드를 대상으로 @before 등 어드바이스 설정이 가능
	 */
	/*@Pointcut("execution(* * getUserInfo(..))")    
	public void userPointCut(){}*/
	
	@Before("execution(* getUserInfo(..))") 
	public void getString(JoinPoint point){
		String arg = "";

		Object [] args = point.getArgs();
		if(args.length >= 1)
			arg = (String)args[0];

		logger.debug(arg +"에 대한 유저 정보를 가져옵니다.");
	}
	
	
	
	// 반환형에 상관없고, 인자도 상관없는 getUserInfo라는 함수가 나오고 나서 후에
	@AfterReturning(returning="map", value="execution(* getUserInfo(..))") 
	public void getAfterString(HashMap<String,String> map){
		logger.debug("----------------------------USER INFO------------------------------");
		logger.debug(map.toString());
		logger.debug("----------------------------/USER INFO-----------------------------");
	}




}

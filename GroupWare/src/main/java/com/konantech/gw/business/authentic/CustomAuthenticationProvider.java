package com.konantech.gw.business.authentic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;


@Controller
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	AuthenticationService authService;
	
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = (String) auth.getPrincipal();
		String password = (String) auth.getCredentials();
		
		logger.info("Welcome authenticate! {}", username + "/" + password);
		
		HashMap<String,String> map ;
		map = authService.getAuthentication(username, password);
		
		logger.debug(map.get("PASSWORD"));
		if(password.equals(map.get("PASSWORD"))){
			logger.debug("오키");
		}
		/*logger.debug("패스워드:"+map.get("password"));*/
		//검증
		/*if(password.equals((map.get("password")))){
			logger.debug("비밀번호 체크 완료");
		}else{
			logger.debug("비밀번호 틀림");
		}*/
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(username, password, roles);
        result.setDetails(new CustomUserDetails(username, password));
		return result;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

}

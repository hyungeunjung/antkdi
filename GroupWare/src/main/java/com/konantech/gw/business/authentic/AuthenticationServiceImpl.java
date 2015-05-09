package com.konantech.gw.business.authentic;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konantech.gw.orm.mybatis.dao.AuthenticationDaoMapper;


@Service("authService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationDaoMapper authDao;

	@Override
	public HashMap<String, String> getAuthentication(String username,
			String password) {
		// TODO Auto-generated method stub
		return authDao.getAuthentication(username, password);
	}

	
	
	
	

}

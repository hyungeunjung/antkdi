package com.konantech.gw.orm.mybatis.dao;

import java.util.HashMap;

public interface AuthenticationDaoMapper {

	public HashMap<String,String> getAuthentication(String username,String password);

}

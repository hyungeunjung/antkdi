package com.konantech.gw.business.main.service;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.konantech.gw.orm.mybatis.dao.MainDaoMapper;

@Transactional(propagation=Propagation.REQUIRED,
				isolation=Isolation.DEFAULT,
				rollbackFor={Exception.class,SQLException.class},readOnly=false)
@Service("mainService")
public class MainServiceImpl implements MainService {
 
	@Autowired
	private MainDaoMapper mainDao;
	
	@Override
	public HashMap<String,String> getUserInfo(String a) {
		// TODO Auto-generated method stub
		return mainDao.getUserInfo(a);
	}

}

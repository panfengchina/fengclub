package com.fengclub.biz.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengclub.biz.dao.core.BaseMongoDao;
import com.fengclub.biz.entity.ClubUser;
import com.fengclub.biz.service.user.ClubUserService;

@Service
public class ClubUserServiceImpl implements ClubUserService {

	@Autowired
	private BaseMongoDao<ClubUser> clubUserdao;
	
	public void insert() {
		ClubUser cb=new ClubUser();
		cb.setName("潘峰测试数据5月19日");
		clubUserdao.save(cb);
	}

	
}

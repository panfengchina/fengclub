package com.fengclub.biz.service.impl.user;

import java.util.List;

import org.fengclub.core.dao.BaseMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengclub.biz.entity.ClubUser;
import com.fengclub.biz.service.user.ClubUserService;

@Service
public class ClubUserServiceImpl implements ClubUserService {

	@Autowired
	private BaseMongoDao<ClubUser> clubUserdao;
	
	public ClubUser insertClubUser() {
		ClubUser cb=new ClubUser();
		cb.setName("潘峰测试数据6月30日");
		cb=clubUserdao.save(cb);
		return cb;
	}

	public List<ClubUser> findClubUser() {
		List<ClubUser> list=clubUserdao.findAll();
		return list;
	}

	
}

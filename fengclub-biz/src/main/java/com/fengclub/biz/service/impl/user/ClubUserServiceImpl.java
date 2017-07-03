package com.fengclub.biz.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengclub.biz.dao.user.ClubUserDAO;
import com.fengclub.biz.entity.user.ClubUser;
import com.fengclub.biz.service.user.ClubUserService;

@Service
public class ClubUserServiceImpl implements ClubUserService {

	@Autowired
	private ClubUserDAO clubUserdao;
	
	public ClubUser insertClubUser() {
		ClubUser cb=new ClubUser();
		cb.setName("潘峰测试数据6月30日");
		cb=clubUserdao.save(cb);
		return cb;
	}

	public List<ClubUser> findClubUser() {
		List<ClubUser> list=clubUserdao.findAll(ClubUser.class);
		return list;
	}

	
}

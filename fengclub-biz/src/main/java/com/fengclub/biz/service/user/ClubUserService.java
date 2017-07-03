package com.fengclub.biz.service.user;

import java.util.List;

import com.fengclub.biz.entity.user.ClubUser;

public interface ClubUserService {

	ClubUser insertClubUser();

	List<ClubUser> findClubUser();

}

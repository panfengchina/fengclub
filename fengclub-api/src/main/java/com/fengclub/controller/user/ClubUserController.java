package com.fengclub.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fengclub.biz.service.user.ClubUserService;

@Controller
@RequestMapping(value = "/ClubUser")
public class ClubUserController {

	@Autowired
	private ClubUserService clubUserService;
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Boolean add(){
		clubUserService.insertClubUser();
		return true;
	}
}

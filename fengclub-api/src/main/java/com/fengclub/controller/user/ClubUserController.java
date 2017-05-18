package com.fengclub.controller.user;

import org.fengclub.biz.service.user.ClubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClubUserController {

	@Autowired
	private ClubUserService clubUserService;
	
}

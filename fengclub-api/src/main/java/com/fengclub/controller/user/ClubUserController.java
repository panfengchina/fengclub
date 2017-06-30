package com.fengclub.controller.user;

import java.util.List;

import org.fengclub.view.ResponseValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengclub.biz.entity.ClubUser;
import com.fengclub.biz.service.user.ClubUserService;

@Controller
@RequestMapping(value = "/ClubUser")
public class ClubUserController {

	@Autowired
	private ClubUserService clubUserService;
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody ClubUser add(){
		return clubUserService.insertClubUser();
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ResponseValues get(){
		List<ClubUser> list=clubUserService.findClubUser();
		ResponseValues rv=new ResponseValues();
		rv.setData(list);
		return rv;
	}
}

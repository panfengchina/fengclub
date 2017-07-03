package com.fengclub.api.controller.user;

import java.util.List;

import org.fengclub.view.ResponseValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fengclub.biz.entity.user.ClubUser;
import com.fengclub.biz.service.user.ClubUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/ClubUser")
@Api(value = "/ClubUser", description = "普通用户的操作")
public class ClubUserController {

	@Autowired
	private ClubUserService clubUserService;
	
	@ApiOperation(value = "创建用户", notes = "自動创建用户")   
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ClubUser add(){
		return clubUserService.insertClubUser();
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseValues get(){
		ResponseValues rv=new ResponseValues();
		List<ClubUser> list=clubUserService.findClubUser();
		rv.setData(list);
		return rv;
	}

}

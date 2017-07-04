package com.fengclub.api.controller.demo;


import org.fengclub.view.ResponseValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fengclub.biz.entity.demo.Test;
import com.fengclub.biz.service.demo.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/Test")
@Api(value = "/Test", description = "普通用户的操作")
public class TestController {

	@Autowired
	private TestService testService;
	
	@ApiOperation(value = "创建调试类", notes = "创建调试类")   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseValues add(@RequestBody @ApiParam(value = "创建调试类Test", required = true)  Test test){
		ResponseValues rv=new ResponseValues();
		Test t=testService.addTest(test);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取Test", response = ResponseValues.class)
	public ResponseValues get(@PathVariable("orderId") String id){
		ResponseValues rv=new ResponseValues();
		Test t=testService.findTestById(id);
		rv.setData(t);
		return rv;
	}
}

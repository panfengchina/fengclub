package com.fengclub.api.controller.demo;


import java.util.List;
import java.util.Map;

import org.fengclub.core.dao.Page;
import org.fengclub.view.ResponseValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengclub.biz.entity.demo.Test;
import com.fengclub.biz.service.demo.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/Test")
@Api(value = "/Test", description = "调试类的操作")
public class TestController {

	@Autowired
	private TestService testService;
	
	  
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "创建Test", response = ResponseValues.class) 
	public ResponseValues add(
			@RequestBody @ApiParam(value = "创建调试类Test", required = true)  Test test){
		ResponseValues rv=new ResponseValues();
		Test t=testService.addTest(test);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取Test", response = ResponseValues.class)
	public ResponseValues getById(
			@ApiParam(value="id",required = true) @RequestParam(value="id") String id){
		ResponseValues rv=new ResponseValues();
		Test t=testService.findTestById(id);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ApiOperation(value = "获取所有Test", response = ResponseValues.class)
	public ResponseValues getAll(){
		ResponseValues rv=new ResponseValues();
		List<Test> t=testService.findTestByAll();
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	@ApiOperation(value = "分页获取Test", response = ResponseValues.class)
	public ResponseValues getPage(
			@ApiParam(value="currentPage",required = true) @RequestParam(value="currentPage")  int currentPage,
			@ApiParam(value="pageSize",required = true) @RequestParam(value="pageSize")  int pageSize){
		ResponseValues rv=new ResponseValues();
		Page<Test> t=testService.findTestByPage(currentPage, pageSize);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ApiOperation(value = "根据id删除Test", response = ResponseValues.class)
	public ResponseValues delete(
			@ApiParam(value="id",required = true) @RequestParam(value="id") String id){
		ResponseValues rv=new ResponseValues();
		boolean t=testService.deleteTestById(id);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/deleteDeep", method = RequestMethod.DELETE)
	@ApiOperation(value = "根据id删除Test", response = ResponseValues.class)
	public ResponseValues deleteDeep(
			@ApiParam(value="id",required = true) @RequestParam(value="id") String id){
		ResponseValues rv=new ResponseValues();
		boolean t=testService.deleteTestByIdDeep(id);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ApiOperation(value = "修改Test", response = ResponseValues.class)
	public ResponseValues update(@RequestBody @ApiParam(value = "创建调试类Test", required = true)  Test test){
		ResponseValues rv=new ResponseValues();
		Boolean t=testService.updateTest(test);
		rv.setData(t);
		return rv;
	}
	
	@RequestMapping(value = "/updateByCustom", method = RequestMethod.PUT)
	@ApiOperation(value = "修改Test只修改修改过的值", response = ResponseValues.class)
	public ResponseValues updateByCustom(@RequestBody @ApiParam(value = "创建调试类Test", required = true) Map<String,Object> map){
		ResponseValues rv=new ResponseValues();
		System.out.println(map);
		Test t=testService.updateTestByCustom(map);
		rv.setData(t);
		return rv;
	}
}

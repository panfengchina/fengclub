package com.fengclub.api.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/** 
	* 默认首页控制器 
	*/  
	@RequestMapping("/index")  
	public String login(HttpServletRequest request, HttpServletResponse response){  
	    return "index";  
	}
}

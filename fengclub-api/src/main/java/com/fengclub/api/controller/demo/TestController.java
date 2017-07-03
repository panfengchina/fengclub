package com.fengclub.api.controller.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/Test")
@Api(value = "/Test", description = "普通用户的操作")
public class TestController {

}

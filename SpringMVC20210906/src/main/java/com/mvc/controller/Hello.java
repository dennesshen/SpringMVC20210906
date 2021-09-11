package com.mvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class Hello {
	
	@RequestMapping(value = "/greet")
	@ResponseBody
	public String greet() {
		return "Hello Spring MVC";
	}
	
	@RequestMapping(value = "/time")
	@ResponseBody
	public String time() {
		return new Date().toString();
	}
    
}

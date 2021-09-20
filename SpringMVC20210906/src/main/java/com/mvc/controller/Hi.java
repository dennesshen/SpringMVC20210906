package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hi")
public class Hi {
	
	@RequestMapping(value = "/greet")
	@ResponseBody
	public String greet(@RequestParam(value = "name") String name) {
		return "嗨！ "+ name;
	}

	@GetMapping(value = "/abc" )
	public ModelAndView sayhi() {
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("/sayhi.jsp");
		mav.addObject("username","John");
		return mav;
	}
	
	@GetMapping(value = "/def" )
	public ModelAndView sayhi2() {
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("/sayhi.jsp");
		mav.addObject("username","Vincent");
		return mav;
	}
	
}

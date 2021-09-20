package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hi")
public class Hi {
	

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

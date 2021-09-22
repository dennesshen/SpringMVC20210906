package com.mvc.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hi")
public class Hi {
	
	@RequestMapping(value = "/{welcome}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String greet(@PathVariable(value = "welcome") String welcome,
						@RequestParam(value = "name") String name)  {
		//解決中文路徑問題
		//預設的編碼是 ISO-8859-1
		//改變編碼：UTF-8
		try {
			welcome = new String(welcome.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return welcome +" " + name + " !";
	}

	@GetMapping(value = "/sayhi" )
	public ModelAndView sayhi() {
		ModelAndView mav = new ModelAndView();	
		//mav.setViewName("/sayhi.jsp");
		mav.setViewName("sayhi");//已經在servlet.xml設定好ViewResolver的標籤，前後綴路徑
		mav.addObject("username","John");
		return mav;
	}
	
	@GetMapping(value = "/sayhi2" )
	//不可以加上＠RespondBody
	public String sayhi2(Model model) {
		model.addAttribute("username","Mary");
		return "sayhi";
	}
	
	
	
}

package com.mvc.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class Hello {

	@RequestMapping(value = "/greet")
	@ResponseBody
	public String greet() {
		return "Hello Spring MVC";
	}

	@RequestMapping(value = "/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name", defaultValue = "unkown", required = false) String name,
			@RequestParam("age") Integer age) {
		return "Hello " + name + "," + age;
	}

	@RequestMapping(value = "/bmi")
	@ResponseBody
	public String bmiCalc(@RequestParam("h") Double height, @RequestParam("w") Double weight) {
		Double bmi = weight / Math.pow(height / 100, 2);

		return String.format("BMI:%.2f", bmi);
	}

	@RequestMapping(value = "/exam/{score}")
	@ResponseBody
	public String exam(@PathVariable("score") Integer score) {
		return score + " " + (score >= 60 ? "pass" : "Fail");
	}

	@RequestMapping(value = "/calc/{exp}")
	@ResponseBody
	public String calc(@PathVariable("exp") String exp,
			           @RequestParam(value = "x", required = false) Optional<Integer> x,
			           @RequestParam(value = "y", required = false) Optional<Integer> y) {
		if(x.isPresent() && y.isPresent()) {
			switch (exp) {
				case "add":
					return x.get() + y.get() + "";
				case "sub":
					return x.get() - y.get() + "";
				default:
					return "None";
			}
		}
		if(x.isPresent()) {
			return x.get() + "";
		}
		if(y.isPresent()) {
			return y.get() + "";
		}
		return "0";
	}

}

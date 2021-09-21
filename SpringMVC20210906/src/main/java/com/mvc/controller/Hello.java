package com.mvc.controller;

import java.util.List;

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
			           @RequestParam(value = "x", required = false) String x,
			           @RequestParam(value = "y", required = false) String y) {
		if( x != null && y != null ) {
			Integer xInteger = Integer.parseInt(x);
			Integer yInteger = Integer.parseInt(y);
			switch (exp) {
				case "add":
					return xInteger + yInteger + "";
				case "sub":
					return xInteger - yInteger + "";
				default:
					return "None";
			}
		}
		if( x != null) {
			return x ;
		}
		if( y != null) {
			return y;
		}
		return "0";
	}
	
	//�`��PathVariable�U�Φr�� * ���N�h�r�B? ���N�@�r
	
	@RequestMapping(value = "/any/*/java?")
	@ResponseBody
	public String any() {
		return "Any" ;
	}
	
	
	//�o��h�����
	//���|:age?a=18&a=19&a=20
	//���G: average = 19
	@RequestMapping(value = "/age")
	@ResponseBody
	public String age(@RequestParam("a") List<Integer> ageList) {
		double avg = ageList.stream().mapToInt(age -> age).average().getAsDouble();
		return String.format("%s , average of age = %.2f", ageList, avg);
	}
	
	/* Lab
	 * �o��h�� score ���
     * ���}��J�G/max?score=80&score=100&score=50
     * ���}��J�G/min?score=80&score=100&score=50
     * ���G�o��Gmax score = 100
	 * ���G�o��Gmin score = 80
	 * ��ĳ�ϥΡGIntSummaryStatistics
	 * */
	@RequestMapping(value = "/getStatistic/{method}")
	@ResponseBody
	public String getStatistic(@PathVariable(value = "method",required = false) String method,
							   @RequestParam(value = "score",required = false) List<Integer> scoreList) {
		switch (method) {
		case "max":
		    int maxNumber = scoreList.stream().mapToInt(score -> score)
		    						 		  .summaryStatistics().getMax();
			return "The maximum : "+maxNumber;
		case "min":
		    int minNumber = scoreList.stream().mapToInt(score -> score)
		    						 		  .summaryStatistics().getMin();
			return "The minimum  : "+minNumber;
		default:
			return "Not enter method";
		}
		
	}
	
	
	
	

}

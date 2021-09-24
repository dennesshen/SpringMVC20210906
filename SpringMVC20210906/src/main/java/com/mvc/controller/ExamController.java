package com.mvc.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.entity.Exam;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	private static List<Exam> exams = new CopyOnWriteArrayList<Exam>();
	
	@RequestMapping(value = {"/", "index"})
	public String index(Model model) {
		Exam e = new Exam();
		e.setId("101");
		e.setName("809");
		e.setSlot(new String[] {"A","C"});
		e.setPay("true");
		e.setNote("Thanks.....");
		model.addAttribute("exam",e);
		return "exam";
	}
	
	
	@RequestMapping(value = "/create")
	public String create(Exam exam, Model model) {
		exams.add(exam);
		System.out.println(exams);
		return "redirect:/mvc/exam/";
	}
	
	
}

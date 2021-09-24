package com.mvc.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.entity.Exam;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	private static List<Exam> exams = new CopyOnWriteArrayList<Exam>();
	
	@RequestMapping(value = {"/", "index"})
	public String index(Model model) {
		Exam e = new Exam();
		model.addAttribute("exam",e);//給表單使用
		model.addAttribute("exams",exams);//給資料呈現使用
		model.addAttribute("action","create");
		return "exam";
	}
	
	
	@RequestMapping(value = "/create")
	public String create(Exam exam, Model model) {
		exams.add(exam);
		return "redirect:/mvc/exam/";
	}
	
	@RequestMapping(value = "/get/{id}")
	public String get(@PathVariable("id") String id, Model model ) {
		Optional<Exam> optExam = exams.stream()
								      .filter(e -> e.getId().equals(id))
								      .findFirst();
		model.addAttribute("exam", optExam.isPresent() ? optExam.get(): new Exam());//給表單使用
		model.addAttribute("exams",exams);//給資料呈現使用
		model.addAttribute("action","update");
		return "exam";
	}
	
	@RequestMapping(value = "/update")
	public String update(Exam exam) {
		Optional<Exam> optExam = exams.stream()
			      .filter(e -> e.getId().equals( exam.getId() ) )
			      .findFirst();
		if(optExam.isPresent()) {
			Exam oExam = optExam.get();
			oExam.setName(exam.getName());
			oExam.setNote(exam.getNote());
			oExam.setPay(exam.getPay());
			oExam.setSlot(exam.getSlot());
		}
		return "redirect:/mvc/exam/";
	}
	
	
		
}

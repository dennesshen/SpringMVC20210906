package com.mvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.entity.Exam;
import com.mvc.entity.ExamName;
import com.mvc.validator.ExamValidator;
import static java.util.stream.Collectors.groupingBy;
import java.util.ArrayList;
import static java.util.stream.Collectors.counting;

@Controller
@RequestMapping("/exam")
public class ExamController {

	private static List<Exam> exams = new CopyOnWriteArrayList<Exam>();
	private static List<ExamName> examNames = new ArrayList<ExamName>();
	static {
		examNames.add(new ExamName("808","OCP I 808"));
		examNames.add(new ExamName("809","OCP II 809"));
		examNames.add(new ExamName("900","OCAD 900"));
		examNames.add(new ExamName("819","1Z0-819"));
	}
	
	@Autowired
	private ExamValidator examValidator;
	
	
	private Map<String, Long> getStat1() {
		return exams.stream().collect(groupingBy(Exam::getName, counting()));
	}
	private Map<String, Long> getStat2() {
		return exams.stream().collect(groupingBy(Exam::getPay, counting()));
	}
	
	private Model commModel(Model model) {
		model.addAttribute("exams", exams);
		model.addAttribute("examNames", examNames);
		model.addAttribute("stat1", getStat1());
		model.addAttribute("stat2", getStat2());
		return model;
	}
	
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		Exam e = new Exam();
		model.addAttribute("exam", e);// 給表單使用
		//model.addAttribute("exams", exams);// 給資料呈現使用
		//model.addAttribute("examNames", examNames);
		// 統計資料
		// 各科報名人數
		//model.addAttribute("stat1", getStat1());
		//model.addAttribute("stat2", getStat2());
		model = commModel(model);
		model.addAttribute("action", "create");
		return "exam";
	}

	@RequestMapping(value = "/create")
	public String create(Exam exam, BindingResult result, Model model) {
		//驗證exam物件
		examValidator.validate(exam, result);
		if(result.hasErrors()) {
			//model.addAttribute("examNames", examNames);
			//model.addAttribute("exams", exams);
			model = commModel(model);
			model.addAttribute("action", "create");
			//model.addAttribute("stat1", getStat1());
			//model.addAttribute("stat2", getStat2());
			return "exam";		
		}
		exams.add(exam);
		return "redirect:/mvc/exam/";
	}

	@RequestMapping(value = "/get/{id}")
	public String get(@PathVariable("id") String id, Model model) {
		Optional<Exam> optExam = exams.stream().filter(e -> e.getId().equals(id)).findFirst();
		model.addAttribute("exam", optExam.isPresent() ? optExam.get() : new Exam());
		//model.addAttribute("exams", exams);
		//model.addAttribute("examNames", examNames);
		//model.addAttribute("stat1", getStat1());
		//model.addAttribute("stat2", getStat2());
		model = commModel(model);
		model.addAttribute("action", "update");
		return "exam";
	}

	@RequestMapping(value = "/update")
	public String update(Exam exam, BindingResult result,Model model) {
		examValidator.validate(exam, result);
		if(result.hasErrors()) {
			//model.addAttribute("examNames", examNames);
			//model.addAttribute("exams", exams);
			model = commModel(model);
			model.addAttribute("action", "update");
			//model.addAttribute("stat1", getStat1());
			//model.addAttribute("stat2", getStat2());
			return "exam";		
		}
		
		Optional<Exam> optExam = exams.stream().filter(e -> e.getId().equals(exam.getId())).findFirst();
		if (optExam.isPresent()) {
			Exam oExam = optExam.get();
			oExam.setName(exam.getName());
			oExam.setNote(exam.getNote());
			oExam.setPay(exam.getPay());
			oExam.setSlot(exam.getSlot());
		}
		return "redirect:/mvc/exam/";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		exams.removeIf(e -> e.getId().equals(id));
		return "redirect:/mvc/exam/";
	}
	
}

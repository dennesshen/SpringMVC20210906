package com.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.product.Product;
import com.mvc.service.ProductService;

@Controller
@RequestMapping("/product")
@SessionAttributes(value = {"groups","products"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/","/index"})
	public String index(Model model) {
		model.addAttribute("product",new Product() );
		model.addAttribute("groups", productService.groups.values());
		model.addAttribute("products", productService.query());
		model.addAttribute("action", "save");
		return "product";
	}
	
	@PostMapping(value = "/save")
	//若要使用 JSR 303 驗證則要在驗證資料模組前面加上 @Valid 修飾
	public String save(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {//有錯誤資訊的話
			model.addAttribute("action", "save");
			return "product";//將錯誤資訊帶回product.jsp的頁面
		}
		productService.save(product);
		return "redirect:/mvc/product/";
	}
	
	
	
	
}

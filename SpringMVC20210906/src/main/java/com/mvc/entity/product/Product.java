package com.mvc.entity.product;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	
	@NotNull(message = "�п�ܰӫ~����")
	@NotBlank(message = "�п�ܰӫ~����")
	private Group group;
	
	//@NotNull(message = "�п�J�ӫ~�W��")
	//@Size(min = 3, max = 50, message = "�ӫ~�W�٥�������3-50�r" )
	@NotBlank(message = "�ӫ~�W�٤��i�H�ť�")
	private String name;
	
	@NotNull(message = "�п�J�ӫ~����")
	//@NotBlank(message = "�ӫ~���椣�i�H�ť�")
	@Range(min = 1, max = 10000, message = "���楲������1-10000����")
	private Double price;
	
	@NotNull(message = "�п�J�ӫ~�ƶq")
	@NotBlank(message = "�ӫ~�ƶq���i�H�ť�")
	@Min(value = 1, message = "�ӫ~�ƶq�����j�󵥩�1")
	private Integer amount;
	
	@NotNull(message = "�п�ܤ��")
	@NotBlank(message = "������i�ť�")
	@PastOrPresent(message = "�W�[������i�H�j�󤵤�")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [group=" + group + ", name=" + name + ", price=" + price + ", amount=" + amount + ", date="
				+ date + "]";
	}

	
	
	
}

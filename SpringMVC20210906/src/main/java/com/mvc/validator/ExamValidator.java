package com.mvc.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.entity.Exam;

@Component
public class ExamValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Exam.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Exam exam = (Exam) target;
		//判定id不可以是空的
		if(exam.getId()==null || exam.getId().trim().length()==0) {
			//field, errorCode, defaultMessage
			//field : 要驗證的物件變數
			//errorCode : 錯誤名稱(通常是指errorMessages.properties 所設定的名稱)
			//defaultMessage : 預設的錯誤訊息
			errors.rejectValue("id","exam.id.required", "id不可為空白");
		}
		
		if(exam.getName()==null || exam.getName().trim().length()==0 ) {
			errors.rejectValue("name","exam.name.required", "考試代號必須選取");
		}
		
		if(exam.getPay()==null || exam.getPay().trim().length()==0 ) {
			errors.rejectValue("pay","exam.pay.required", "繳費狀況必須選取");
		}
		
		if(exam.getSlot()==null || exam.getSlot().length == 0 ) {
			errors.rejectValue("slot","exam.slot.required", "考試時段至少選取一個");
		}
		
	}
	
}

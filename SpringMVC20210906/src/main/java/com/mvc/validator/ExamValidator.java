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
		//�P�wid���i�H�O�Ū�
		if(exam.getId()==null || exam.getId().trim().length()==0) {
			//field, errorCode, defaultMessage
			//field : �n���Ҫ������ܼ�
			//errorCode : ���~�W��(�q�`�O��errorMessages.properties �ҳ]�w���W��)
			//defaultMessage : �w�]�����~�T��
			errors.rejectValue("id","exam.id.required", "id���i���ť�");
		}
		
		if(exam.getName()==null || exam.getName().trim().length()==0 ) {
			errors.rejectValue("name","exam.name.required", "�ҸեN���������");
		}
		
		if(exam.getPay()==null || exam.getPay().trim().length()==0 ) {
			errors.rejectValue("pay","exam.pay.required", "ú�O���p�������");
		}
		
		if(exam.getSlot()==null || exam.getSlot().length == 0 ) {
			errors.rejectValue("slot","exam.slot.required", "�Ҹծɬq�ܤֿ���@��");
		}
		
	}
	
}

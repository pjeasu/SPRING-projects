package edu.bit.ex.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//15-1

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		return Student.class.isAssignableFrom(arg0);
		//������ ��ü�� Ŭ���� Ÿ�� ����
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
//		//������ �Ӽ� ��������
//		String studentName = student.getName();
//	
//		if(studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("studentName is null or empty");
//			errors.rejectValue("name", "trouble");
//			//������ü�� Ű ��� �������� ���� ���� (�ʵ����,�����ڵ�)
//		}
//		
//		int studentId = student.getId();
//		
//		if(studentId == 0) {
//			System.out.println("studentId is 0");
//			errors.rejectValue("id", "trouble");
//		}
		
		//���� �ּ��κ� �ڵ带 ���ٷ� ���̴� �޼ҵ� 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
	
		
		
		
		
		
		
	}
	
	
}


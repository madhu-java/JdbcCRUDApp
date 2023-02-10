package com.madhu.servicefactory;

import com.madhu.service.IStudentService;
import com.madhu.service.StudentServiceImpl;

public class StudentServiceFactory {
	//make construction private to avoid object creation
	private StudentServiceFactory() {}
	
	
	public static IStudentService studentService = null;
	public static  IStudentService getStudentService() {
		//singleton pattern
		if(studentService==null) {
		studentService = new StudentServiceImpl();
		}
		return studentService;
	}
	

}

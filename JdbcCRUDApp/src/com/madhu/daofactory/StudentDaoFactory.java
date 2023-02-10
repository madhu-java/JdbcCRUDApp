package com.madhu.daofactory;

import com.madhu.persistence.IStudentDao;
import com.madhu.persistence.StudentDaoImpl;

public class StudentDaoFactory {
 private StudentDaoFactory() {}
 
 public static IStudentDao studentDao=null;
 
 public static IStudentDao getStudentDao() {
	 if(studentDao==null) {
		 studentDao = new StudentDaoImpl();
		
	 }
	 return studentDao;
 }
 
}

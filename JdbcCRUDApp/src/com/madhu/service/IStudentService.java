package com.madhu.service;

import com.madhu.dto.Student;

public interface IStudentService {
	//operations to be implemented
		public String addStudent(Integer sid,String sname,Integer sage,String sadress);
		public Student searchStudent(Integer id);
		public String updateStudent(Student student);
		public String delete(Integer sid);
}

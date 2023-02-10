package com.madhu.persistence;

import com.madhu.dto.Student;
import com.mysql.cj.result.StringValueFactory;

public interface IStudentDao {
	
	//operations to be implemented
	public String addStudent(Integer sid,String sname,Integer sage,String sadress);
	public Student searchStudent(Integer id);
	public String updateStudent(Student student);
	public String delete(Integer sid);
	

}

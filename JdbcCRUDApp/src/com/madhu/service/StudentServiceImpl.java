package com.madhu.service;

import com.madhu.daofactory.StudentDaoFactory;
import com.madhu.dto.Student;
import com.madhu.persistence.IStudentDao;
import com.madhu.servicefactory.StudentServiceFactory;
import com.mysql.cj.result.StringValueFactory;
//service layer
public class StudentServiceImpl implements IStudentService {
  private IStudentDao stdDao;
	@Override
	public String addStudent( Integer sid,String sname, Integer sage, String sadress) {
		stdDao = StudentDaoFactory.getStudentDao();
		
			return stdDao.addStudent( sid,sname, sage, sadress);	
	}

	@Override
	public Student searchStudent(Integer id) {
		stdDao=StudentDaoFactory.getStudentDao();
		
		return stdDao.searchStudent(id);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String delete(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return  stdDao.delete(sid);
		
	}

}

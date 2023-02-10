package com.madhu.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.portable.ValueInputStream;

import com.madhu.JavaUtil.JavaUtil;
import com.madhu.dto.Student;


//persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {
Connection con=null;
PreparedStatement prst=null;
ResultSet resultSet=null;

	@Override
	public String addStudent(Integer sid, String sname, Integer sage, String sadress) {
		String sqlInsertQuery = "insert into student(`id`,`name`,`age`,`address`)values(?,?,?,?)";
		
		try {
			con=JavaUtil.getJdbcConnection();
			if(con!=null)
				prst= con.prepareStatement(sqlInsertQuery);
			if(prst!=null) {
				prst.setInt(1,sid);
				prst.setString(2, sname);
				prst.setInt(3,sage);
				prst.setString(4, sadress);
				
				int rows=prst.executeUpdate();
				System.out.println("rows:"+rows);
				if(rows==1) {
					return "success";
				}
				
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String sqlSelectQueryString = "select id,name,age,address from student where id=?";
		Student student = null;
		try {
			con=JavaUtil.getJdbcConnection();
			if(con!=null)
				prst = con.prepareStatement(sqlSelectQueryString);
		    if(prst!=null) {
		    	prst.setInt(1, sid);
		    	
		    	
		    }
		    if(prst!=null) {
		    	resultSet = prst.executeQuery();
		    	
		    }
		    
		    if(resultSet!=null) {
		    	
		    	if(resultSet.next()) {
		    		student= new Student();
		    		
		    		//copy resultset to student object
		    		
		    		student.setId(resultSet.getInt(1));
		    		student.setName(resultSet.getString(2));
		    		student.setAge(resultSet.getInt(3));
		    		student.setAddress(resultSet.getString(4));
		    		
		    		
		    		return student;
		    	}
		    }
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Student student) {
String sqlUpdateQuery = "update student set name=?,age=?,address=? where id =?";
		
		try {
			con=JavaUtil.getJdbcConnection();
			if(con!=null)
				prst= con.prepareStatement(sqlUpdateQuery);
			if(prst!=null) {
				prst.setString(1, student.getName());
				
				
				prst.setInt(2,student.getAge());
				prst.setString(3, student.getAddress());
				//System.out.println("student.getId():"+student.getId());
				prst.setInt(4,student.getId());
				
				int rows=prst.executeUpdate();
				System.out.println("rows:"+rows);
				if(rows==1) {
					return "success";
				}
				
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String delete(Integer sid) {
		String sqlDeleteQuery = "delete from student where id=?";
		try {
			con=JavaUtil.getJdbcConnection();
			if(con!=null)
				prst= con.prepareStatement(sqlDeleteQuery);
			if(prst!=null) {
				prst.setInt(1, sid);
				int rowsAffected=prst.executeUpdate();
				if(rowsAffected==1) {
					return "success";
				}else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String toString() {
		return "StudentDaoImpl []";
	}
	

}

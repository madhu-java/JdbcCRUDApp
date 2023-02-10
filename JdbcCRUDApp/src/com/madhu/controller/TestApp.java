package com.madhu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.madhu.dto.Student;
import com.madhu.service.IStudentService;
import com.madhu.servicefactory.StudentServiceFactory;
//controller logic
public class TestApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1.Create\n2.Read\n3.Update\n4.Delete\n5.Exit");
			System.out.println("enter your choice...press[1,2,3,4,5]");
			String choice= br.readLine();
			switch (choice) {
			case "1":
				insertionOperation();
				break;
case "2":
				slectOperation();
				break;
case "3":
	updateOperation();
	break;
case "4":
	deleteOperation();
	break;
case "5":
	System.out.println("************Thank you  for using the application***********");
	System.exit(0);
	break;

			default:System.out.println("Invalid option....pls try again with valid options");
				break;
			}
		}
		
	
	}

	private static void updateOperation() throws IOException {
		//Scanner scanner= new Scanner(System.in);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter student id:");
		//int id= scanner.nextInt();
		String id=br.readLine();
		IStudentService studentService	=StudentServiceFactory.getStudentService();
		Student student=studentService.searchStudent(Integer.parseInt(id));
		if(student!=null) {
			Student newStudent= new Student();
			System.out.println("student id is:"+student.getId());
			newStudent.setId(student.getId());
			System.out.println("Student old name is:"+student.getName());
			System.out.println("enter new name..");
			String newNameString =br.readLine();// scanner.next();
			if(newNameString.equals("")||newNameString=="") {
				newStudent.setName(student.getName());
			}else {
				newStudent.setName(newNameString);
			}
			
			System.out.println("Student old age is:"+student.getAge());
			System.out.println("enter new age..");
			String newage = br.readLine();//scanner.next();
			if(newage.equals("")||newage=="") {
				newStudent.setAge(student.getAge());
			}else {
				newStudent.setAge(Integer.parseInt(newage));
			}
			System.out.println("Student old address is:"+student.getAddress());
			System.out.println("enter new adress..");
			String newAddress = br.readLine();//scanner.next();
			if(newAddress.equals("")||newAddress=="") {
				newStudent.setAddress(student.getAddress());
			}else {
				newStudent.setAddress(newAddress);
			}
			System.out.println("new object data is:"+newStudent);
			String statuString= studentService.updateStudent(newStudent);
			if(statuString.equalsIgnoreCase("success")) {
		    	System.out.println("Record updated succefully.....");
		    }else {
		    	System.out.println("Record updation failed.....");
		    }
		
			
		}else {
			System.out.println("Student record not available for the given id:"+id+"for update");
		}
		
		//scanner.close();
	}

	private static void deleteOperation() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter student id:");
		int id= scanner.nextInt();
		
		IStudentService studentService	=StudentServiceFactory.getStudentService();
	String statusString= studentService.delete(id);
    if(statusString.equalsIgnoreCase("success")) {
    	System.out.println("Record deleted succefully.....");
    }else if(statusString.equalsIgnoreCase("not found")) {
    	System.out.println("Record not available.....");
    }else {
    	System.out.println("Record deletion failed....");
    }
	}

	private static void slectOperation() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter student id:");
		int id= scanner.nextInt();
		
		IStudentService studentService	=StudentServiceFactory.getStudentService();
		Student std= studentService.searchStudent(id);
		if(std!=null) {
			System.out.println("id\tname\tage\taddress");
			System.out.println(std.getId()+"\t"+std.getName()+"\t"+std.getAge()+"\t"+std.getAddress());
			
		}else {
			System.out.println("record not found for the specified id..");
			
		}
	}

	private static void insertionOperation() {
		IStudentService studentService	=StudentServiceFactory.getStudentService();
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter student id:");
		int id= scanner.nextInt();
		System.out.println("enter name:");
		String nameString= scanner.next();
		System.out.println("enter student age:");
		int age= scanner.nextInt();
		System.out.println("enter address:");
		String address= scanner.next();
		
String msg = studentService.addStudent(id,nameString,age,address);
if(msg.equals("success")) {
		System.out.println("recird inserted successfully");
}else {
		System.out.println("record insertion failed");
}
	}

}

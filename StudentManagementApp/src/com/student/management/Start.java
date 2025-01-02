package com.student.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Start {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome To Student Management Application");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 to Add student");
			System.out.println("Press 2 to Delete student");
			System.out.println("Press 3 to Display student");
			System.out.println("Press 4 to Exit Application");
			int c = Integer.parseInt(br.readLine());
			if(c==1) {
				// Add Student
				System.out.println("Enter student name : ");
				String name = br.readLine();
				
				System.out.println("Enter student phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter student city : ");
				String city = br.readLine();
				
				// create student object to store student
				Student student = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(student);
				if(answer) {
					System.out.println("Student is added successfully !!");
				}else {
					System.out.println("Something went wrong try again ....");
				}
				System.out.println(student);
				
				
			}else if(c==2) {
				// Delete Student
				System.out.println("Enter student ID to delete: ");
			    int studentId = Integer.parseInt(br.readLine());
			    
			    // Call the DAO method to delete the student
			    boolean result = StudentDao.deleteStudentFromDB(studentId);
			    
			    if (result) {
			        System.out.println("Student deleted successfully!");
			    } else {
			        System.out.println("Something went wrong. Try again.");
			    }
				
			}else if(c==3) {
				// Display Student
				List<Student> students = StudentDao.getAllStudents();
			    if (students.isEmpty()) {
			        System.out.println("No students found.");
			    } else {
			        for (Student student : students) {
			            System.out.println(student);
			        }
			    }
				
			}else if(c==4) {
				// Exit
				break;
			}else {
				System.out.println("Enter Valid choice : ");
			}
		}
		System.out.println("Thankyou for using my application....");
		System.out.println("see you soon...bye bye");
	}

}

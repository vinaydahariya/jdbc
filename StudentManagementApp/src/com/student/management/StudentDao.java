package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		boolean flag = false;
		try {
			// jdbc code ...
			Connection con = ConnectionProviders.createConnection();
			String query = "insert into students(sname, sphone, scity) values(?, ?, ?)";
			//PreparedStatement
			PreparedStatement statement = con.prepareStatement(query);
			//Set the value of parameter
			statement.setString(1, st.getStudent_name());
			statement.setString(2, st.getStudent_phone());
			statement.setString(3, st.getStudent_city());
			//execute..
			statement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<Student> getAllStudents() {
	    List<Student> students = new ArrayList<>();
	    try {
	        Connection con = ConnectionProviders.createConnection();
	        String query = "SELECT * FROM students";
	        PreparedStatement statement = con.prepareStatement(query);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            Student student = new Student();
	            student.setStudent_id(rs.getInt("sid"));
	            student.setStudent_name(rs.getString("sname"));
	            student.setStudent_phone(rs.getString("sphone"));
	            student.setStudent_city(rs.getString("scity"));
	            students.add(student);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return students;
	}
	
	public static boolean deleteStudentFromDB(int studentId) {
	    boolean flag = false;
	    
	    try {
	        // JDBC code for deleting the student by ID
	        Connection con = ConnectionProviders.createConnection();
	        String query = "DELETE FROM students WHERE sid = ?";
	        
	        // PreparedStatement
	        PreparedStatement statement = con.prepareStatement(query);
	        
	        // Set the student ID parameter
	        statement.setInt(1, studentId);
	        
	        // Execute the delete statement
	        int rowsAffected = statement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            flag = true; // Student deleted successfully
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return flag;
	}


}

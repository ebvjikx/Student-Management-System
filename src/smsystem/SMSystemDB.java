package smsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SMSystemDB {
	
	/**
	1/ import the package (java.sql.*)
	2/ a. Load the driver
		b. Register the driver (Class.forName("com.mysql.jdbc.Driver"))
	3/ Establish connection 
	4/ Create the query statement
	5/ Execute the query
	6/ Process result
	7/ Close 
	*/
		
	static String url = "jdbc:mysql://localhost:3306/SMSystem";
	static String uname = "root";
	static String pword = "pipe7eb";
	static Connection con = null;
		
	public static void connect() {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection(url, uname, pword);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static Student getStudent(String student_id) {
		List<String> string_info = new ArrayList<String> ();
		List<Double> double_info = new ArrayList<Double> ();
		try {
			String query = "select * from Student where student_id=" + student_id;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				for (int i = 1; i <= 7;i++) {
					if (i <= 5)
						string_info.add(rs.getString(i));
					else
						double_info.add(rs.getDouble(i));	
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		/*
		string_info.forEach(System.out::println);
		double_info.forEach(System.out::println);*/
		
		return new Student((String) string_info.get(0), 
				(String) string_info.get(1),
				(String) string_info.get(2), 
				(String) string_info.get(3), 
				(String) string_info.get(4), 
				(double) double_info.get(0), 
				(double) double_info.get(1));
	}
	
	public static void addStudent(Student s) {
		
		try {
			String query =  "insert into Student values (?, ?, ?, ?, ?, ? , ?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, s.getStudentID());
			pst.setString(2, s.getfName());
			pst.setString(3, s.getlName());
			pst.setString(4, s.getDOB());
			pst.setString(5, s.getRegistrationDate());
			pst.setDouble(6, s.getTotalCredits());
			pst.setDouble(7, s.getBalance());
			
			pst.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
	}
	
		
		//Statement st = con.Statement();
		
		//Get result from database
		//Result rs = st.executeQuery("select * from TABLE")
		
		//Insert data
		//PreparedStatement st = con.prepareStatement();
		//st.executeUpdate("insert into TABLE values (?, ?, ?)") prepared statement
		
		//while (rs.next());
		
		//rs.getInt(1);
		
		//rs.getInt(1) + " " + rs.getString(2);
		
		//st.close();
		//con.close();
		
		
		
		
	}

		
		
		
}

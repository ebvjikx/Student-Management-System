package smsytem;

import java.time.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Student {
	
	private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyy");
	private String firstName;
	private String lastName;
	private int student_id;
	private int age;
	private double balance;
	private boolean fulltime_status;
	private int no_courses_enrolled;
	private Course[] courses_enrolled;
	private final String registration_date;
	private final String dob;
	
	public Student(String fname, String lname, int age, String dob) {
		this.registration_date = LocalDate.now().format(dateFormat);
		this.dob = dob;
		this.firstName = fname;
		this.lastName = lname;
		//this.age = LocalDate.parse(dob);
	}
	
	private static int getAge(String dob) {
		LocalDate d_o_b = LocalDate.parse(dob);
		
		Duration age_d = Duration.between(d_o_b.atStartOfDay(), LocalDate.now().atStartOfDay());
		int age = (int) age_d.toDays()/365;
		return age;
	}
	
	public static void main(String[] args) {
		int age = getAge("2001-06-03");
		System.out.println(age);
	}
}

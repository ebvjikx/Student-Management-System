package smsystem;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Student {
	
	private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyy");
	private String firstName;
	private String lastName;
	private static int id = 1000;
	private String student_id;
	private int age;
	private double balance;
	//private boolean fulltime_status;
	private int no_courses_enrolled;
	private double total_credits;
	private List<Course> courses_enrolled;
	private final String registration_date;
	private final String dob;
	
	public Student(String fname, String lname, String dob, int age) {
		Student.id++;
		this.registration_date = LocalDate.now().format(dateFormat);
		this.dob = dob;
		this.firstName = fname;
		this.lastName = lname;
		this.age = this.getAge(dob);
		this.student_id = this.generateID(registration_date, dob);
		this.no_courses_enrolled = 0; 
		this.total_credits = 0;
		this.courses_enrolled = new ArrayList<Course> ();
	}
	
	public Student(String student_id, String fname, String lname, String dob, String reg_date, double total_credits, double balance) {
		this.student_id = student_id;
		this.firstName = fname; 
		this.lastName = lname;
		this.dob = dob;
		this.registration_date = reg_date;
		this.total_credits = total_credits;
		this.balance = balance;
		this.age = this.getAge(dob);
	}
	
	private int getAge(String dob) {
		LocalDate d_o_b = LocalDate.parse(dob, dateFormat);
		
		Duration age_d = Duration.between(d_o_b.atStartOfDay(), LocalDate.now().atStartOfDay());
		int age = (int) age_d.toDays()/365;
		return age;
	}
	
	private String generateID(String reg_date, String dob) {
		String[] r_dates = reg_date.split("-");
		String[] b_dates = dob.split("-");
		
		String r_dates_year = r_dates[2];
		
		String id_month = b_dates[1];
		String id_year = r_dates_year.charAt(2) + "" + r_dates_year.charAt(3); 
		
		String student_id = id_year + id_month + Student.id;
		
		return student_id;
	}
	
	public boolean enrollInCourse(Course course) {
		
		if (courses_enrolled.contains(course) || course.getAvailableSeats() == 0)
				return false;
		else {
			this.courses_enrolled.add(course);
			this.no_courses_enrolled++;
			this.balance += course.getPrice();
			this.total_credits += course.getCredits();
			course.studentEnrolled(this);
			
			return true;
		}
	}
	
	public boolean dropCourse(Course course) {
		
		if (!courses_enrolled.contains(course))
				return false;
		else {
			this.courses_enrolled.remove(course);
			this.no_courses_enrolled--;
			this.balance -= course.getPrice();
			this.total_credits -= course.getCredits();
			course.studentDropped(this);
			
			return true;
		}
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getfName() {
		return this.firstName;
	}
	
	public String getlName() {
		return this.lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getStudentID() {
		return this.student_id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getDOB() {
		return this.dob;
	}
	
	public int getNoCourseEnrolled() {
		return this.no_courses_enrolled;
	}
	
	public double getTotalCredits() {
		return this.total_credits;
	}
	
	public String getRegistrationDate() {
		return this.registration_date;
	}
	
	public String toString() {
		return String.format("Name: %s\n"
				+ "Student ID: %s\n"
				+ "DoB: %s\n"
				+ "Regstration Date: %s\n"
				+ "Total Credits: %.1f\n"
				+ "Balance: $%.2f\n"
				, this.getFullName(), this.student_id, this.dob, this.registration_date, this.total_credits, this.balance);
	}
	
	/** check if student being added has already been created and in database */
	
	public boolean equals(Student s) {
		return (this.firstName.equals(s.firstName)) 
				&& this.lastName.equals(s.lastName) 
				&& this.dob.equals(s.dob);
	}
	
	/*
	public static void main(String[] args) {
		String age = generateID("30-11-2099", "03-06-2001");
		System.out.println(age);
	}*/ 
}

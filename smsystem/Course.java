package smsystem;

import java.util.*;

public class Course {
	
	private static final double COST_PER_CREDIT = 87.43;
	private static final int total_seats = 25;
	private String course_name;
	private String course_num;
	private double no_of_credits;
	private double price;
	private int no_students_enrolled;
	private List<String[]> students_enrolled;
	private int seats_available;
	
	public Course(String name, String num, double credits) {
		this.course_name = name;
		this.course_num = num;
		this.no_of_credits = credits;
		this.price = COST_PER_CREDIT * no_of_credits;
		this.no_students_enrolled = 0;
		this.seats_available = total_seats;
		this.students_enrolled = new ArrayList<String[]> ();
	}
	
	public void studentEnrolled(Student student) {
		String [] student_info = {student.getFullName(), student.getStudentID()};
		this.no_students_enrolled++;
		this.seats_available--;
		this.students_enrolled.add(student_info);
	}
	
	public void studentDropped(Student student) {
		String [] student_info = {student.getFullName(), student.getStudentID()};
		this.no_students_enrolled--;
		this.seats_available++;
		this.students_enrolled.remove(student_info);
	}
	
	public String getCourseName() {
		return this.course_name;
	}
	
	public String getCourseNum() {
		return this.course_num;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getAvailableSeats() {
		return this.seats_available;
	}
	
	public int getStudentsEnrolled() {
		return this.no_students_enrolled;
	}
	
	public double getCredits() {
		return this.no_of_credits;
	}
	
	public String toString() {
		return String.format("Course Name: %s\n"
				+ "Course Number: %s\n"
				+ "Credits: %.1f\n"
				+ "Course Price: $%.2f\n"
				+ "Seats: %d\n"
				, this.course_name, this.course_num, this.no_of_credits, this.price, this.seats_available);
	}
}

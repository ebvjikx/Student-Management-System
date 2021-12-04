package smsystem;

import java.util.ArrayList;

public class Course {
	
	private static final double COST_PER_CREDIT = 87.43;
	private static final int total_seats = 25;
	private String course_name;
	private String course_num;
	private double no_of_credits;
	private double price;
	private int no_students_enrolled;
	private ArrayList<Student> students_enrolled;
	private int seats_available;
	
	public Course(String name, String num, double credits) {
		this.course_name = name;
		this.course_num = num;
		this.no_of_credits = credits;
		this.price = COST_PER_CREDIT * no_of_credits;
		this.no_students_enrolled = 0;
		this.seats_available = total_seats;
	}
	
	public void studentEnrolled(Student student) {
		this.no_students_enrolled++;
		this.seats_available--;
		this.students_enrolled.add(student);
	}
	
	public void studentDropped(Student student) {
		this.no_students_enrolled--;
		this.seats_available++;
		this.students_enrolled.remove(student);
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
}

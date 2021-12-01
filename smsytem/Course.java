package smsytem;

public class Course {
	
	private String course_name;
	private String course_num;
	private double no_of_credits;
	private int no_students_enrolled;
	
	public Course(String name, String num, double credits) {
		this.course_name = name;
		this.course_num = num;
		this.no_of_credits = credits;
	}
	
	
}

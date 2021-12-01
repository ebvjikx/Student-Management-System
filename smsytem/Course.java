package smsytem;

public class Course {
	
	private String course_name;
	private String course_num;
	private static final double COST_PER_CREDIT = 87.43;
	private double no_of_credits;
	private double price;
	private int no_students_enrolled;
	private static final int total_seats = 25;
	private int seats_available;
	
	public Course(String name, String num, double credits) {
		this.course_name = name;
		this.course_num = num;
		this.no_of_credits = credits;
		this.price = COST_PER_CREDIT * no_of_credits;
		this.no_students_enrolled = 0;
		this.seats_available = total_seats;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void studentEnrolled() {
		this.no_students_enrolled++;
		this.seats_available--;
	}
	
	
}

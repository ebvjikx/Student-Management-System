package smsystem;

public class SMsystem {

	public static void main(String[] args) {
		
		SMSystemDB.connect();
		
		/*
		System.out.println(SMSystemDB.getStudent("00000005"));
		
		*/
		Student s = new Student("00000005", "Zahra", "Jikz", "23-06-2008", "22-12-2021", 10, 124);
		
		
		SMSystemDB.updateTotalCredits(s);
		SMSystemDB.updateBalance(s);
		
		Student s1 = SMSystemDB.getStudent(s.getStudentID());
		System.out.println(s1);
	}

}

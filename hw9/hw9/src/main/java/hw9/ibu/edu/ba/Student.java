package hw9.ibu.edu.ba;

public class Student {
	
	//Declaring class variables
	private int studentID;
	private String name;
	private String dateOfBirth;
	private String universityName;
	private String departmentCode;
	private String departmentName;
	private int yearOfEnrolment;
	
	//Class constructor
	public Student(int studentID, String name, String dateOfBirth, String universityName, String departmentCode,
			String departmentName, int yearOfEnrolment) {
		this.studentID = studentID;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.universityName = universityName;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.yearOfEnrolment = yearOfEnrolment;
	}
	
	//toString() function used while printing a student from the tree
	@Override
	public String toString() {
		return "Student ID: " + this.studentID + "\n"  + 
				"Name and surname: " + this.name + "\n" + 
				"Date of birth: " + this.dateOfBirth + "\n" + 
				"University:" + this.universityName + "\n" + 
				"Department code: " + this.departmentCode + "\n" + 
				"Department: " + this.departmentName + "\n" +
				"Year of enrolment: " + this.yearOfEnrolment;
	}
	
	//Getter function for studentID to be used while obtaining keys for populating the trees
		public int getStudentID() {
			return studentID;
		}

}
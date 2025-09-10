//Zuha Amjad 
//SP25-BCS-145

public class Student{

	private String name;
	private String email;
	private double cGPA;

	public void displayInfo(){
		System.out.println("  Student Details  ");
		System.out.println("-------------------");
		System.out.println("Name:   " + this.name);
		System.out.println("Email:  " + this.email);
		System.out.println("CGPA:   " + this.cGPA);

	}

	public Student(){
	}

	public Student(String name, String email, double cGPA){
		this.name  = name;
		this.email = email;
		this.cGPA = cGPA;
	}

	public void setInfo(String name, String email, double cGPA){
		this.name  = name;
		this.email = email;
		this.cGPA = cGPA;	
	}

	public String getName(){
		return this.name;
	}


}
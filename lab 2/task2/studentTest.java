//Zuha Amjad
//SP25-BCS-145

public class studentTest{

	public static void main(String args[]){
		Student s1 = new Student();
		
		s1.setInfo("Ali", "ali@gmail.com", 3.2);

		s1.displayInfo();
		Student s2 = new Student("Zuha", "zuha@gmail.com", 4.0);

		s2.displayInfo();

		Student s3 = new Student("Fizza", "fizza@gmail.com", 2.6);
		
		System.out.println(s3.getName());

	}

}
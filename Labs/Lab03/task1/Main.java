public class Main{

	public static void main(String args[]){

		Student s1 = new Student();
		Student s2 = new Student("Mouhid Amjad", 'M', "03-08-02", "Bahria Town Lahore");
		Student s3 = new Student("Laiba Khalil", 'F', "22-09-01", "DHA Karachi");
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());

		if(s2.equals(s3))
			System.out.println("IDs are equal");
		else
			System.out.println("IDs are not equal");
	}


}
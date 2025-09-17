public class Main{

	public static void main(String args[]){

		Student s1 = new Student();
		Student s2 = new Student("Mouhid Amjad", 'M', "03-08-02", "Bahria Town Lahore");
		Student s3 = new Student(s2);

		//System.out.println(s1.getId());

		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}


}
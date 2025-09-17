public class Main{

	public static void main(String args[]){

		Date d1 = new Date(1,8,2015);
		Date d2 = new Date(25,12,2008);

		Address a1 = new Address("Walled Street","Lahore","Pakistan");
		Address a2 = new Address("Kingston","London","England");

		Student s1 = new Student();
		Student s2 = new Student("Mouhid Amjad", 'M', d1, a1);
		Student s3 = new Student("Laiba Khalil", 'F', d2, a2);
		
		System.out.println(s2.toString());
		System.out.println(s3.toString());

		if(s2.equals(s3))
			System.out.println("IDs are equal");
		else
			System.out.println("IDs are not equal");
	}


}
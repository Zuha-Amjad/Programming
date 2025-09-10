public class Demo{

	public static void main(String args[]){
		Employee e1 = new Employee("Zuha Amjad", 22, 50000.00, "St.34 Bahria Town, Lahore");
		
		e1.displayInfo();
		
		Employee e2 = new Employee();
	
		e2.setName("Mouhid Amjad");
		e2.setSocialSecurityNo(123);
		e2.setBaseSalary(125000);
		e2.setAddress("Johar Town, Lahore, Pakistan");
		
		e2.displayInfo();

		Employee e3 = new Employee("Ali Zafar", 302, 25000.00, "St. 23, Phase 5, DHA Karachi");
		e3.displayInfo();
	}

}
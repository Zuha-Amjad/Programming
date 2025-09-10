public class Employee{

	private String name;
	private int socialSecurityNo ;
	private double baseSalary;
	private String address;

	public Employee(){

	}

	public Employee(String name, int socialSecurityNo, double baseSalary, String address){
		
		this.setName(name);
		this.setSocialSecurityNo(socialSecurityNo);
		this.setBaseSalary(baseSalary);
		this.setAddress(address);
	}


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;	
	}


	public void setSocialSecurityNo(int socialSecurityNo){
		if(socialSecurityNo > 0)
			this.socialSecurityNo = socialSecurityNo;
	}

	public int getSocialSecurityNo(){
		return this.socialSecurityNo;
	}


	public void setBaseSalary(double baseSalary){
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary(){
		return this.baseSalary;
	}


	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}

	public void displayInfo(){
		System.out.println("\n     Employee Details     ");
		System.out.println("-------------------------------------");
		System.out.println("Name:                 " + this.getName());
		System.out.println("Social Security No.:  " + this.getSocialSecurityNo());
		System.out.println("Base Salary:          " + this.getBaseSalary());
		System.out.println("Address:              " + this.getAddress());
	}



}
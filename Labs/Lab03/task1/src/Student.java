public class Student{
	private String id;
	private String name;
	private char gender;
	private String dateOfBirth;
	private String address;
	static int counter = 1;

	//Setters and Getters
	public void setId()
	{
		this.id = String.format("SP25-BCS-%03d", counter);
		counter++;
	}
	public String getId(){
		return this.id;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public char getGender(){
		return this.gender;
	}
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfBirth(){
		return this.dateOfBirth;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}



	


	//Default Constructor
	public Student(){
		this.setId();
	}

	//Parameterized Constructor

	public Student(String name, char gender, String dateOfBirth, String address ){
		this.setId();
		this.setName(name);
		this.setGender(gender);
		this.setDateOfBirth(dateOfBirth);
		this.setAddress(address);

	}

	public Student(Student s){
		this.id = s.id;
		this.name = s.name;
		this.gender = s.gender;
		this.address = s.address;
		this.dateOfBirth = s.dateOfBirth;

	}


	public String toString(){
		return String.format("%-10s %-15s %-3c %-15s %-30s", this.id, this.name, this.gender, this.dateOfBirth, this.address);

	}




}
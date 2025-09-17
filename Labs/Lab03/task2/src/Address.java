public class Address{
	private String street;
	private String city;
	private String country;

	//Constructor
	public Address(String street, String city, String country){
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public String toString(){
		return String.format("%s, %s, %s",street, city, country);
	}
}

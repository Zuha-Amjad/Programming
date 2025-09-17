public class Date{
	private int day;
	private int month;
	private int year;

	public void setDay(int day){
		if(day >= 1 && day <= 30)
			this.day = day;
	}

	public void setMonth(int month){
		if(month >= 1&& month <= 12)
			this.month = month;
	}
	public void setYear(int year){
		this.year = year;
	}

	public Date(int day, int month, int year){
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	public String toString(){

		return String.format("%02d-%02d-%04d" ,day, month, year );
	}
}
package assignmnet.example;

public class MyDate {
	private int day;
	  private int month;
	  private int year;
	  
	  
	  public boolean setDay(int d) {
		  if(d>30) {
			  return false;   
		  }
		  else {
			  day=d;
			  return true;}
	  }
	  
	  
	  public boolean setMonth(int m) {
		  if(m>12) {
			 return false;  
		  }
		  else {
			  month= m;
			  return true;
		  }
	  }
	  
	  
	  public boolean setYear(int y) {
		  if(y<1998 && y>2019) {
			  return false;   
		  }
		  else {
			  year=y;
			  return true;
		  }
	  }
	 
	 
		 
	  public int getDay() {
		  return day;
	  }
	  public int getMonth() {
		  return month;
	  }
	  public int getYear() {
		  return year;
	  }
	  
	
}

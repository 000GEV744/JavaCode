package comm.example;
//the first statement should be the package declaration then it comes to the class

public class MyDate {
  private int day;
  private int month;
  private int year;
  
  public void createDate(int d,int m, int y) {
	  if(d>30) {
		  System.out.println("day can't be greater than 30");
		  System.exit(0);   //satus:0 means we are stopping the thread as one thread will always ve associated with our main method and if we'r writing status:1 then thread will keep on running  in the background 
	  }
	  if(m>12) {
		  System.out.println("month can't be greater than 12");
		  System.exit(0);    
	  }
	  if(y<1998 && y>2019) {
		  System.out.println("wrong year");
		  System.exit(0);   
	  }
	 
	  day=d;
	  month=m;
	  year=y;
  }
 
  public String getDetails() {
	  return day+"-"+month+"-"+year;
  }
  

}


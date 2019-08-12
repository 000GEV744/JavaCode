package assignmnet.example;

public class Products {
     private int curRate;
     private static int item;
     
     static {
    	 item=0;
     }
     
   
   public Products(int curRate) {
	    this.item++;
		this.curRate = curRate;
	}


   public static int incItem() {
	   return item;
   }



}

package comm.example;

public class Addargs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		for(String a:args) {
			try {
				System.out.println(args[10]);
			sum+=Integer.parseInt(a);
			}
			catch(NumberFormatException nfe){
//				System.err.println("number format Exception occured");
//				nfe.printStackTrace();
//				System.err.println(nfe.getCause().toString());
				System.err.println(nfe.getMessage());
//				System.exit(0);
			}
			catch(ArrayIndexOutOfBoundsException aeobe) {
				System.err.println("array index out of bounds");
			}
//			catch(Exception e) {
//				System.err.println("exception occured ");
//			}
			finally{
				System.out.println("finally block called");
			}
		}
		System.out.println("sum: "+ sum);
	}

}

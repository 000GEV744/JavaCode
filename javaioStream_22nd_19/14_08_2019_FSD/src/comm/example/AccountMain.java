package comm.example;

public class AccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account ac=new Account();
		
		try{
			ac.createAccount("SB101", 15090);
		}
		catch(AccountNotValid e) {
			System.err.println(e.getMessage());
		}
		
	}

}

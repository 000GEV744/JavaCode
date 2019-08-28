package comm.example_2;

public class UserMainCode {

	
	public static boolean checkPassword(String password){
		  String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      return (password.matches(pattern));
	}
}

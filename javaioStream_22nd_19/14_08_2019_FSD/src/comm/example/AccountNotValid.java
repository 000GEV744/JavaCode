package comm.example;

public class AccountNotValid extends Throwable{//to handle both runtime and checked and unchecked exceptions 

	/**
	 * 
	 */
	private static final long serialVersionUID = 3321568416707542584L;
	private String message;

	public AccountNotValid() {
		super();
	}

	public AccountNotValid(String message) {
		super();
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}

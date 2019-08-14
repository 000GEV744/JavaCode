package comm.example.name;

public class NameNotValidException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8093217076663058187L;
	private String message;
	
	public NameNotValidException() {
		super();
	}

	public NameNotValidException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
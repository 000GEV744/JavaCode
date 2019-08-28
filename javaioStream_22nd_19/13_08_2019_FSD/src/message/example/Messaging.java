package message.example;

public class Messaging {

	private String message;
	private static Messaging messaging;
	
	private Messaging() {
		
	}
	
	private Messaging(String message) {
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Messaging {"+"message='" + message + '\''+'}';
	}
	
	public static Messaging createMessageingObject() {
		if(messaging==null) {
			messaging= new Messaging();
		}
		return messaging;
	}
	
	public static Messaging createMessageingObject(String name) {
		if(messaging==null) {
			messaging= new Messaging(name);
		}
		return messaging;
	}

	
	
}

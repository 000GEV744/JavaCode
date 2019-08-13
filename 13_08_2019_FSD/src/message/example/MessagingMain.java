package message.example;

public class MessagingMain {
	public static void main(String args[]) {
	Messaging msg=Messaging.createMessageingObject("abs");
    System.out.println(msg);
    Messaging msg1=Messaging.createMessageingObject();
    System.out.println(msg==msg1);
	}
}

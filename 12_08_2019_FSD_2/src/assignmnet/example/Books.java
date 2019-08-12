package assignmnet.example;

public class Books extends Products{
	private String bookName;
	private String author;
	public Books(int curRate, String bookName, String author) {
		super(curRate);
		this.bookName = bookName;
		this.author = author;
	}
   
}

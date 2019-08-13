package comm.example;

public class HumanMain {

	public static void main(String args[]) {
		Monkey m=new Monkey();
		m.setName("tom");
		m.walk();
		Dog d=new Dog("bunny","Husky");
		d.createLivingThings();
		
	}
}

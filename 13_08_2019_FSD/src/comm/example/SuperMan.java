package comm.example;

public class SuperMan extends Flyer{

	
	
	@Override
	public void takeoff() {
		// TODO Auto-generated method stub
		System.out.println("Superman takeoffs");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Superman flies");
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("Superman lands");
	}

	public void eat() {
		System.out.println("SuperMan eats");
	}

}

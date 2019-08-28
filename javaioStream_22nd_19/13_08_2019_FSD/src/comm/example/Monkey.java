package comm.example;

public class Monkey implements LivingThings {

	private String name;
	
	
	

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("Monkey: "+getName()+" can also wlak");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}

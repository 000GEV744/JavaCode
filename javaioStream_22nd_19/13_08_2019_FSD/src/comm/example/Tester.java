package comm.example;

public class Tester {

	public static void main(String args[]) {
//		Flyer flyer=new Bird();
//		flyer.takeoff();
//		flyer=new SuperMan();
//		flyer.takeoff();
		
		Model model=new Line(0,20);
		Model model1=new Line(0,10);
		System.out.println(model.isGreater(model, model1));
        System.out.println(model.isLesser(model1));
        System.out.println(model.isEqual(model1));
	}
}

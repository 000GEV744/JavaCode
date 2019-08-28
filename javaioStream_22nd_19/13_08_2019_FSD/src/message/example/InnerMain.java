package message.example;

public class InnerMain {

	public static void main(String args[]){
		OuterClass  oc = new OuterClass();
		oc.outerMethod();
		OuterClass.InnerClass ic =oc.new InnerClass();
		ic.innerMethod();
		OuterClass.InnerClass.Inner2 innc = new OuterClass().new InnerClass().new Inner2();
		innc.innerMethod2();
		
	}
}

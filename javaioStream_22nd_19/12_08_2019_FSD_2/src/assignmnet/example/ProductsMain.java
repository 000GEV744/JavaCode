package assignmnet.example;

public class ProductsMain {
	public static void main(String args[]) {
		Products p=null;
		p=new Electronics(45,2002);
		System.out.println(p.getClass().getName());
		System.out.println(Products.incItem());
		p=new Books(45,"harry potter","xyz");
		System.out.println(p.getClass().getName());
		System.out.println(Products.incItem());
	}
}

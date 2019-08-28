package comm.example;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestCalculator extends TestCase{

	@Test
	public void testAddMethod() {
		int x=10;
		int y=20;
		Calculator c = new Calculator(10,20);
		int result=c.addMethod();
		assertEquals(30, result);
	}
	
	@Test
	public void testSubMethod() {
		int x=10;
		int y=20;
		Calculator c = new Calculator(10,20);
		int result=c.subMethod();
		assertEquals(-10, result);
	}
	
	@Test
	public void testIsGreater() {
		int x=10;
		int y=20;
		Calculator c = new Calculator(10,20);
		int result=c.isGreaterMethod();
		assertEquals(-1, result);
	}
	
	
	

}

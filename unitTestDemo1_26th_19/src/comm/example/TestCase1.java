package comm.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestCase1 extends TestCase {

	@Before
	protected
	void setUp() throws Exception {
	}

	@After
	protected
	void tearDown() throws Exception {
	}

	@Test
	public void testCheckNull() {
		System.out.println("hello  its testing");
		assertEquals(1,1);
	}
}

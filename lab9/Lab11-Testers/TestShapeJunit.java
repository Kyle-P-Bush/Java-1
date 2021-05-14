import java.util.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;//Comment this out and uncomment
//import junit.framework.* and extends TestCase and things will also work

//import junit.framework.*;//Makes TestCase and Asserts work
import java.io.*; //IO Library for testing System.out messages

public class TestShapeJunit //extends TestCase
{
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final PrintStream systemOut = System.out;
	
	@Before
	public void setUp()
	{
		//Output Streams for testing
		System.setOut(new PrintStream(output));
	}

	@Test
	public void testShape(){
		output.reset();
		TestShape.main(null);
		String submission = output.toString().replace("\r", "");
		assertEquals( getExpectedOutput() , submission);
	}

	public String getExpectedOutput(){
		String out = "";
		out += "Circle: area: 28.3, perimeter: 18.8\n";
		out += "Rectangle: area: 8.0, perimeter: 12.0\n";
		out += "Triangle: area: 0.0, perimeter: 6.0\n";
		return out;
	}


	@After
	public void restoreStreams() {
    	System.setOut(systemOut);
	}
	
}
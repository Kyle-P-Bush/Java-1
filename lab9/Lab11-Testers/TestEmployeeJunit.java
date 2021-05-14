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

public class TestEmployeeJunit //extends TestCase
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
	public void testEmployee(){
		output.reset();
		TestEmployee.main(null);
		String submission = output.toString().replace("\r", "");
		assertEquals( getExpectedOutput() , submission);
	}

	public String getExpectedOutput(){
		String out = "";
		out += "Meg Manager, salary:$50000.00\n";
		out += "Paycheck: $2083.33\n";
		out += "Sal Salesman, commission:0.15% @ $3400.00 sales\n";
		out += "Paycheck: $510.00\n";
		out += "Timmy Temp, hourly:$10.50 @ 25.00 hours\n";
		out += "Paycheck: $262.50\n";
		return out;
	}


	@After
	public void restoreStreams() {
    	System.setOut(systemOut);
	}
	
}
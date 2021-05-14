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

public class TestAnimalJunit //extends TestCase
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
	public void testAnimal(){
		output.reset();
		TestAnimal.main(null);
		String submission = output.toString().replace("\r", "");
		assertEquals( getExpectedOutput() , submission);
	}

	public String getExpectedOutput(){
		String out = "";
		out += "Dog runs\n";
		out += "roof roof\n";
		out += "Fish swims\n";
		out += "glub glub\n";
		out += "Bird flies\n";
		out += "chirp chirp\n";
		return out;
	}

	@After
	public void restoreStreams() {
    	System.setOut(systemOut);
	}
	
}
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*Tester for RGBColor class */
public class TestRGBColor
{
	/* main method: executes tests & counts number of successes*/
	public static void main(String[] args){
		int passed = 0;
		int tests = 3;
		System.out.println("\nTest: RGBColor");
		System.out.println("------------------------------");
		passed += testToString();
		passed += testToHex();
		passed += testEquals();
		System.out.println("------------------------------");
		System.out.printf("Passed %d of %d tests\n\n",passed, tests);
	}


	@Test
	/*tester: return 1 if a success or 0 if a failure & log errors*/
	private static int testToString(){
		String result, hint, errorLog = "";

		RGBColor rgb1 = new RGBColor(0, 0, 0);
		result = rgb1.toString(); 
		hint = "rgb = new RGBColor(0,0,0);\trgb.toString() -> \"rgb(0,0,0)\"";
		errorLog += checkResult("rgb(0,0,0)", result, hint);

		RGBColor rgb2 = new RGBColor(255, 255, 255);
		result = rgb2.toString(); 
		hint = "rgb = new RGBColor(255,255,255);\trgb.toString() -> \"rgb(255,255,255)\"";
		errorLog += checkResult("rgb(255,255,255)", result, hint);

		printTestResults(errorLog, "testToString");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1 if a success or 0 if a failure & log errors*/
	private static int testToHex(){
		String result, hint, errorLog = "";

		RGBColor rgb1 = new RGBColor(0, 0, 0);
		result = rgb1.toHex(); 
		hint = "rgb = new RGBColor(0,0,0);\trgb.toHex() -> \"#000000\"";
		errorLog += checkResult("#000000", result, hint);

		RGBColor rgb2 = new RGBColor(255, 255, 255);
		result = rgb2.toHex(); 
		hint = "rgb = new RGBColor(255,255,255);\trgb.toHex() -> \"#ffffff\"";
		errorLog += checkResult("#ffffff", result, hint);

		printTestResults(errorLog, "testToHex");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1  if a success or 0 if a failure & log errors*/
	private static int testEquals(){
		String result, hint, errorLog = "";

		RGBColor rgb1 = new RGBColor(0, 0, 0);
		RGBColor rgb2 = new RGBColor(255,255,255);
		RGBColor rgb3 = new RGBColor(255,255,255);

		result = "" + rgb1.equals(rgb2);
		hint = "rgb1 = new RGBColor(0,0,0); rgb2= new RGBColor(255,255,255)\trgb1.equals(rgb2) -> false";
		errorLog += checkResult("false", result, hint);

		result = "" + rgb2.equals(rgb3);
		hint = "rgb1 = new RGBColor(255,255,255); rgb2= new RGBColor(255,255,255)\trgb1.equals(rgb2) -> true";
		errorLog += checkResult("true", result, hint);


		printTestResults(errorLog, "testEquals");
		return successCounter(errorLog);
	}

	/*helper: prints results for a tester*/
	private static void printTestResults(String error, String test){
		if ( error.equals("") ){
			System.out.println("[PASS]: " + test);
		}
		else{
			error = "[FAIL]: " + test + "\n" + error;
			System.out.println(error);
		}
	}

	/*helper: returns 1 if errorLog is empty otherwise return 0 */
	private static int successCounter(String error){
		return error.equals("") ? 1 : 0;
	}

	/*helper: checks that result matches expected value and return error log*/
	private static String checkResult(String expected, String result, String hint){
		return expected.equals(result) ? "" : String.format("\t[Expected] %s",hint);
	}

}

@Retention(RetentionPolicy.RUNTIME)
@interface Test{}
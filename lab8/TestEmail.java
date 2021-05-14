import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*Tester for Email class */
public class TestEmail
{
	/* main method: executes tests & counts number of successes*/
	public static void main(String[] args){
		int passed = 0;
		int tests = 5;
		System.out.println("\nTest: Email");
		System.out.println("------------------------------");
		passed += testConstructorWith3Params();
		passed += testConstructorWith4Params();
		passed += testSetBody();
		passed += testAddToBody();
		passed += testEquals();
		System.out.println("------------------------------");
		System.out.printf("Passed %d of %d tests\n\n",passed, tests);
	}

	@Test
	/*tester: return 1  if a success or 0 if a failure & log errors*/
	private static int testConstructorWith3Params(){
		String result, hint, errorLog = "";

		Email email1 = new Email("Hw", "Joe", "Me");
		result = email1.toString();
		hint = "email1 = new Email(\"Hw\", \"Joe\", \"Me\");\temail1.toString() -> \"From: Me; To: Joe; Subject: Hw; Body: \"";
		errorLog += checkResult("From: Me; To: Joe; Subject: Hw; Body: ", result, hint);

		Email email2 = new Email("Substitute", "Adam", "Yu");
		result = email2.toString();
		hint = "email1 = new Email(\"Substitute\", \"Adam\", \"Yu\");\temail1.toString() -> \"From: Yu; To: Adam; Subject: Substitute; Body: \"";
		errorLog += checkResult("From: Yu; To: Adam; Subject: Substitute; Body: ", result, hint);

		printTestResults(errorLog, "testConstructorWith3Params");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1 if a success or 0 if a failure & log errors*/
	private static int testConstructorWith4Params(){
		String result, hint, errorLog = "";

		Email email1 = new Email("Hw", "Joe", "Me", "bodytext");
		result = email1.toString();
		hint = "email1 = new Email(\"Hw\", \"Joe\", \"Me\", \"bodytext\");\temail1.toString() -> \"From: Me; To: Joe; Subject: Hw; Body: bodytext\"";
		errorLog += checkResult("From: Me; To: Joe; Subject: Hw; Body: bodytext", result, hint);

		Email email2 = new Email("Substitute", "Adam", "Yu", "text");
		result = email2.toString();
		hint = "email1 = new Email(\"Substitute\", \"Adam\", \"Yu\", \"text\");\temail1.toString() -> \"From: Yu; To: Adam; Subject: Substitute; Body: text\"";
		errorLog += checkResult("From: Yu; To: Adam; Subject: Substitute; Body: text", result, hint);

		printTestResults(errorLog, "testConstructorWith4Params");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1 if a success or 0 if a failure & log errors*/
	private static int testSetBody(){
        String result, hint, errorLog = "";
        
        Email email1 = new Email("Hw", "Joe", "Me");
        email1.setBody("body text");

        result = email1.getBody();
        hint = "email1.setBody(\"body text\");\temail.getBody() -> \"body text\"";
        errorLog += checkResult("body text", result, hint);
        
        printTestResults(errorLog, "testSetBody");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1  if a success or 0 if a failure & log errors*/
	private static int testAddToBody(){
        String result, hint, errorLog = "";
        
        Email email1 = new Email("Hw", "Joe", "Me", "body text");
        email1.addToBody(" more body text");
        result = email1.getBody();
        hint = "email1 = new Email(\"Hw\", \"Joe\", \"Me\", \"body text\");\temail1.addToBody(\" more body text\");\temail.getBody() -> \"body text more body text\"";
        errorLog += checkResult("body text more body text", result, hint);
        
        printTestResults(errorLog, "testAddToBody");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1  if a success or 0 if a failure & log errors*/
	private static int testEquals(){
		String result, hint, errorLog = "";

		Email email1 = new Email("a", "b", "c");
        Email email2 = new Email("a", "b", "c");
        Email email3 = new Email("d", "e", "f");

		result = ""+email1.equals(email2);
		hint = "email1 = new Email(\"a\", \"b\", \"c\"); email2 = new Email(\"a\", \"b\", \"c\");\t email1.equals(email2); -> true";
        errorLog += checkResult("true", result, hint);

		result = ""+email2.equals(email3);
		hint = "email2 = new Email(\"a\", \"b\", \"c\"); email3 = new Email(\"d\", \"e\", \"f\");\t email2.equals(email3); -> false";
        errorLog += checkResult("false", result, hint);

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

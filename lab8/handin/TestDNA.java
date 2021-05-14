import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/*Tester for DNA class */
public class TestDNA
{
	/* main method: executes tests & counts number of successes*/
	public static void main(String[] args){
		int passed = 0;
		int tests = 4;
		System.out.println("\nTest: DNA");
		System.out.println("------------------------------");
		passed += testGetSequence();
		passed += testToString();
		passed += testEquals();
		passed += testSwap();
		System.out.println("------------------------------");
		System.out.printf("Passed %d of %d tests\n\n",passed, tests);
	}

	@Test
	/*tester: return 1  if a success or 0 if a failure & log errors*/
	private static int testGetSequence(){
		String result, hint, errorLog = "";

		char[] sequence = {'T','A','C','T'};
		DNA dna = new DNA( sequence );
		result = Arrays.toString( dna.getSequence() ); 
		hint = "seq = ['T','A','C','T']; dna = new DNA(seq);\tdna.getSequence() -> \"['T', 'A', 'C', 'T']\"";
		errorLog += checkResult("[T, A, C, T]", result, hint);

		printTestResults(errorLog, "testGetSequence");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1 if a success or 0 if a failure & log errors*/
	private static int testToString(){
		String result, hint, errorLog = "";

		char[] sequence = {'T','A','C','T'};
		DNA dna = new DNA( sequence );
		result = dna.toString(); 
		hint = "seq = ['T','A','C','T']; dna = new DNA(seq);\tdna.toString() -> \"TACT\"";
		errorLog += checkResult("TACT", result, hint);

		printTestResults(errorLog, "testToString");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1 if a success or 0 if a failure & log errors*/
	private static int testEquals(){
		String result, hint, errorLog = "";

		char[] seq1 = {'T','A','C'}; 
		char[] seq2 = {'T','A','C'};
		char[] seq3 = {'A','C','T'};  
		DNA dna1 = new DNA(seq1);
		DNA dna2 = new DNA(seq2);
		DNA dna3 = new DNA(seq3);

		result = "" + dna1.equals(dna3);
		hint = "seq1=['T','A','C']; seq2=['A','C','T']; dna1 = new DNA(seq1); dna2= new DNA(seq2)\tdna1.equals(dna2) -> false";
		errorLog += checkResult("false", result, hint);

		result = "" + dna1.equals(dna2);
		hint = "seq1=['T','A','C']; seq2=['T','A','C']; dna1 = new DNA(seq1); dna2= new DNA(seq2)\tdna1.equals(dna2) -> true";
		errorLog += checkResult("true", result, hint);


		printTestResults(errorLog, "testEquals");
		return successCounter(errorLog);
	}

	@Test
	/*tester: return 1  if a success or 0 if a failure & log errors*/
	private static int testSwap(){
		String result, hint, errorLog = "";

		char[] seq1 = {'T','T','T','T'}; 
		char[] seq2 = {'A','A','A','A'};
		DNA dna1 = new DNA(seq1);
		DNA dna2 = new DNA(seq2);
		DNA dna3 = dna1.swap(dna2,2);
		result = Arrays.toString(  dna3.getSequence() );
		hint = "seq1=['T','T','T','T']; seq2=['A','A','A','A']; dna1 = new DNA(seq1); dna2= new DNA(seq2)\tdna1.swap(dna2,2) -> new DNA with sequence: ['T','T','A','A']";
		errorLog += checkResult("[T, T, A, A]", result, hint);

		printTestResults(errorLog, "testSwap");
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
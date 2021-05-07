import java.math.BigInteger;
//submitted by Kyle Bush
public class RSA{
	private BigInteger n;
	private BigInteger e;
	private BigInteger d;

	public RSA(String p, String q){
		BigInteger pBI = new BigInteger(p);
		BigInteger qBI = new BigInteger(q);
		this.n = pBI.multiply(qBI);
		this.e = generateE(pBI, qBI);
		this.d = generateD(this.e, totient(pBI, qBI));
	}

	public RSA(String p, String q, String e){
		BigInteger pBI = new BigInteger(p);
		BigInteger qBI = new BigInteger(q);
		BigInteger eBI = new BigInteger(e);
		this.n = pBI.multiply(qBI);
		this.e = eBI;
		this.d = generateD(this.e, totient(pBI, qBI));
	}

	public BigInteger totient(BigInteger p, BigInteger q){
		//totient = (p-1) * (q-1)
		return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	}

	public BigInteger generateE(BigInteger p, BigInteger q){
		BigInteger totient = totient(q,p);
		BigInteger e;
		do{
			int max = (int)(Math.random() * totient.longValue());
			BigInteger number = new BigInteger(""+max);
			e = number.nextProbablePrime();
		}while( e.compareTo(totient) >= 0);
		return e;
	}

	public BigInteger generateD(BigInteger e, BigInteger totient){
		BigInteger d = BigInteger.ONE;
		while( !((e.multiply(d)).mod(totient).equals(BigInteger.ONE) )){
			d = d.add(BigInteger.ONE);
		}
		return d;
	}

	public String encrypt(String message){
		char[] charMessage = message.toCharArray();
		String encryptedMessage = "";
		for(char c : charMessage){
			int x = c;
			BigInteger xBI = new BigInteger(String.valueOf(x));
			xBI = xBI.modPow(e,n);
			x = xBI.intValue();
			encryptedMessage += (char) x;
		}
		return encryptedMessage;
	}

	public String decrypt(String message){
		char[] charMessage = message.toCharArray();
		String decryptedMessage = "";
		for (char c : charMessage){
			int x = c;
			BigInteger xBI = new BigInteger(String.valueOf(x));
			xBI = xBI.modPow(d,n);
			x = xBI.intValue();
			decryptedMessage += (char) (x);
		}
		return decryptedMessage;
	}
}
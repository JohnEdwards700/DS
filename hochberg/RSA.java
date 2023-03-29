import java.math.BigInteger;

class RSA{

    public static void main(String[] args){
	BigInteger p = new BigInteger("1077700000").nextProbablePrime();
	System.out.println("p = " + p);
	
	BigInteger q = new BigInteger("2000000000").nextProbablePrime();
	System.out.println("q = " + q);
	
	BigInteger n = p.multiply(q);
	System.out.println("n = " + n);
	
	BigInteger e = BigInteger.valueOf(2);
	
	BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	while(! phi.gcd(e).equals(BigInteger.ONE))
	    e = e.add(BigInteger.ONE);
	System.out.println("phi = " + phi);
	System.out.println("e = " + e);

	String msg = "I LOVE YOU";
	System.out.println("The message is: \"" + msg + "\"");
	BigInteger M = encode(msg);
	System.out.println("Encoded message is: " + M);

	BigInteger MEncrypted = M.modPow(e, n);
	System.out.println("Encrypted message number = " + MEncrypted);

	String encryptedMsg = decode(MEncrypted);
	System.out.println("Encrypted message = " + encryptedMsg);
       
	BigInteger d = e.modInverse(phi);
	System.out.println("d = " + d);

	BigInteger MDecrypted = MEncrypted.modPow(d, n);
	System.out.println("Decrypted message number = " + MDecrypted);

        String  decryptedMessage = decode(MDecrypted);
	System.out.println("Decrypted message = \"" + decryptedMessage + "\"");
		
       
	/*
	  for(char c = 'A'; c <= 'Z'; c++){
	  System.out.println(c + " " + charVal(c));
	  }
	*/
       
    }

    /**
     * Encode string s as a base-30 integer.
     * A-Z are 1-26, space is 0, !=27, ?=28
     */
    static BigInteger encode(String s){
	BigInteger val = BigInteger.ZERO;
	BigInteger base = new BigInteger("30");

	for(int i = 0; i < s.length(); i++){
	    val = val.multiply(base).add(charVal(s.charAt(i)));
	}

	return val;
    }

    /**
     * Decode a BigInteger M back into the string it represents
     */
    static String decode(BigInteger M){
	String rv = "";
	BigInteger base = new BigInteger("30");

	while(M.compareTo(BigInteger.ZERO) > 0){
	    rv = valChar(M.mod(base)) + rv;
	    M = M.divide(base);
	}

	return rv;
    }

    static BigInteger charVal(char c){
	if(c == ' ') return BigInteger.ZERO;
	if(c == '!') return new BigInteger("27");
	if(c == '?') return new BigInteger("28");
	if(c >= 'A' && c <= 'Z') {
	    long l = (long)(c - 'A' + 1);
	    return BigInteger.valueOf(l);
	}
	return new BigInteger("29");
    }


    /**
     * x is a BigInteger in the range 0-29
     */
    static char valChar(BigInteger x){
	int v = x.intValue();
	if(v == 0) return ' ';
	if(v == 27) return '!';
	if(v == 28) return '?';
	if(v == 29) return '*';
	return (char)(v + 'A' - 1);
    }
}

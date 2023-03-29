// <--- is a comment
// In Java, everything has to be in a class.
// The class in a file must be the same as the file name.
// So the Primes class will be in a file called Primes.java


class Primes{

    // All Java programs start with this method (function)
    public static void main(String[] args){
	System.out.println("Primes up to 100");
	for(int i = 0; i <= 1000000; i++){
	    if(isPrime(i)){
		System.out.println(i);
	    }
	}
    }

    static boolean isPrime(int n){
	if(n <=1) return false;
	if(n == 2) return true;
	if(n % 2 == 0) return false; // even number

	for(int divisor = 3; divisor < Math.sqrt(n)+1; divisor += 2){
	    if(n % divisor == 0) return false;
	}

	// If we get here, the number n had no divisor
	return true;
    }

}


/**
 * Find a pair of primes that adds to N
 */


public class MyArrays{

    static int[] primes;

    public static void main(String[] args){

	int N = 100;
	primes = findPrimes(N);

	for(int i = 0; i < primes[0]; i++){
	    System.out.println(i + ":" + primes[i]);
	}
	//findPair(primes, N);

    }

    static int[] findPrimes(int N){
	// Before building our return value array, we need to know
	// about how big it should be.
	int numPrimesApprox = (int)(N/Math.log(N) * 2 + 20); // safe size
	int[] rv = new int[numPrimesApprox];

	// Fill rv with the primes
	int idx = 1;
	for(int i = 2; i < N; i++){
	    if(isPrime(i)){
		rv[idx] = i;
		idx++;
	    }
	}

	// Fill rv[0] with the number of primes found
	rv[0] = idx - 1;

	return rv;	
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

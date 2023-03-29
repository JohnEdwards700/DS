/**
 * Take a number from the command line, and produce
 * all primes up to and including that number
 */

import java.util.ArrayList;

class Eratosthenes {


    public static void main(String[] args){
	// args is the arguments given on the command line
	// when the user runs "java"
	int N = Integer.parseInt(args[0]);

	ArrayList<Integer> allPrimes = findPrimes(N);
	System.out.println("Here are your primes: " + allPrimes);
    }
    
    static ArrayList<Integer> findPrimes(int N){
	// Build all the primes up to N
	boolean[] a = new boolean[N+1];

	// Set all entries of the array to true
	for(int i = 0; i <= N; i++) a[i] = true;

	// 0 and 1 are not prime
	a[0] = false;
	a[1] = false;

	// 2 is our first prime
	int candidate = 2;

	// Sieve
	while(candidate <= Math.sqrt(N)){
	    int multiple = candidate + candidate;
	    while(multiple < N){
		a[multiple] = false;  // crossing out this multiple
		multiple += candidate;
	    }

	    candidate++;
	    while(!a[candidate]) candidate++;
	}

	// Add all the primes into an ArrayList
	// ArrayList is generic, so we must declare the type it will hold
	ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
	for(int i = 0; i < N; i++){
	    // if(a[i]) System.out.println(i);
	    if(a[i]) listOfPrimes.add(i);
	}

	// System.out.println(listOfPrimes);
	return listOfPrimes;
	
    }

    
}

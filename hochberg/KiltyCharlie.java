import java.util.Arrays;

public class KiltyCharlie {
    
    static int[] primes;
    
    public static void main(String[] args){
        //486924
        int N = 800000000;
        primes = findPrimes(N);
        for (int x = 1; x <= primes[0]; x++){
            int y = N - primes[x];
            //if (isPrime(y)){
	    if(Arrays.binarySearch(primes, y) >= 1){
                System.out.println(primes[x] + " and " + y);
                //x = primes[0] + 10; // kludge
		break; // exit the innermost loop that we are in right now
            }
        }
    }

    
    static int[] findPrimes(int N){
        // Before building our return value array, we need to know aobut how big it should be
        int numPrimesApprox = (int)(N/Math.log(N)*2+20); //safe size
        int[] rv = new int[numPrimesApprox];

        // fill rv with Primes
        int idx = 1;
        for(int i = 2; i < N; i++){
	    if(i % 1000 == 0) System.out.println(i);
            if(isPrime(i)){
                rv[idx] = i;
                idx++;
            }
        }
        // Fill rv[0] with the number of primes found
        rv[0] = idx;
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

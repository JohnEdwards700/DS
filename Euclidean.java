// Example of the Euclidean Algorithm for gcd

class Euclidean {

    public static void main(String[] args){
	long a = 39L;
	long b = 63L;

	System.out.println("The gcd is " + gcd(a, b));
    }

    static long gcd(long a, long b){
	while(b > 0){
	    long newa = b;
	    long newb = a%b;
	    a = newa;
	    b = newb;
	}

	return a;
    }

}


/**
 * Some simple while loop demos
 */

public class WhileLoops {

    public static void main(String[] args){

	// Print the numbers from 1 to 10
	int i = 1;
	while(i <= 10){
	    System.out.println(i);
	    i++;
	}

	// Print the powers of 3 from 1 up to a million
	i = 1;
	while(i <= 1000000){
	    System.out.println(i);
	    i *= 3;
	}
    }

}

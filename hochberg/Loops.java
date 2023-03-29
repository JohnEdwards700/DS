class Loops {

    // This is a dumb, Git-testing comment.
    public static void main(String[] args){

	for(int i = 1; i <= 10; i += 2){
	    System.out.println(i);
	    System.out.println("That was a nice number");
	}

	int counter = 1;
	while(counter < 1000000){
	    // This will keep happening as long as the test is true
	    System.out.println("Hi there!" + counter);
	    counter *= 2;
	}
    }


}

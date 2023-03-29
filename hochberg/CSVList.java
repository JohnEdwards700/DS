
// CSVList is an implementation of our List Abstract Data Type
class CSVList{
    // In the backing string, every item is preceded by a comma
    String backingString;

    public CSVList(){
        backingString = "";
    }

    /**
     * Adds an int to the list, by appending a comma and it
     * @param n The integer to add to the list
     */
    public void add(int n){
        backingString = backingString + "," + n;
    }

    /**
     * Find the length of the list
     * @return The number of items in the list
     */
    public int length(){
        int count = 0;
        for(int i = 0; i < this.backingString.length(); i++){
            if(backingString.charAt(i) == ',') count++;
        }
        return count;
    }

    /**
     * Get an item from the list, at a specific location
     * @param idx The index of the item to get
     * @return The item at the idx'th location
     */
    public int get(int idx){
        int start = findKthComma(idx);
        int end = findKthComma(idx+1);
        String number = this.backingString.substring(start+1, end);
        return Integer.parseInt(number);
    }

    /**
     * Utility function to find the Kth occurrence of "," in the backing string
     * @param K Which comma's location to find
     * @return The index of the Kth comma in the backing string
     */
    private int findKthComma(int K){
        int count = -1;
        int i = -1;
        while(count < K && i < this.backingString.length()-1){ // Loop stops when i is the index of the Kth comma
            i++;
            if(this.backingString.charAt(i) == ',') count++;
        }
	if(i == this.backingString.length() - 1)
	    return i+1;
	else
	    return i;
    }
}

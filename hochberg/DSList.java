/** 
 * Define the ADT List
 *
 * An interface describes behavior, "from the outside."
 */

public interface DSList{
    public void add(int n); // operate by side effects
    
    public void replace(int idx, int newValue);
    
    public int length();
    
    public void sort();
    
    public void remove(int idx);
    
    public int count(int item);
    
    public int get(int idx);
    
    public int find(int item);
	

}

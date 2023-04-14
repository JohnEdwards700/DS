/** 
* Define the ADT Queue
*
* An interface describes behavior, "from the outside."
*/

public interface DSQueue<E>{
   public void pushBack(E n); // operate by side effects
   
   public void popFront();
   
   public int length();
}
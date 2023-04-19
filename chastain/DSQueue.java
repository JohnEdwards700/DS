/*
 * Define ADT Queue
 * 
 * An interface describes behavior "from the outside"
 */
public interface DSQueue {

   public void enqueue(E n);
   
   public E dequeue(); 

   public int length();
}

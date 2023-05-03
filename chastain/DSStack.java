/*
 * Define ADT Stack
 * 
 * An interface describes behavior "from the outside"
 */
public interface DSStack<E> {

   public void push(E n);
   
   public E pop(); 

   public int length();
}

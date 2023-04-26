/**
 * Linked List Implementation
 */

public class DSLinkedList<E> implements DSQueue<E> {

  Box first;
  Box last;
  int numberOfItems;

  /**
   * Adds a new item to the end of the queue
   */
  public void enqueue(E newItem) {
    Box newbox = new Box(newItem);

    if(this.numberOfItems == 0){
        this.first = newbox;
    } else {
        this.last.next = newbox;
    }
    this.last = newbox;
    this.numberOfItems++;
  }

  public E dequeue() {
    return null;
  }

  /**
   * Return the number of items in the queue
   */
  public int length() {
    return numberOfItems;
  }

  /**
   * Return the number of times that item appears in the DSLinkedList
   * You may assume that the generic type E implements the equals() method.
   * 
   * @param item The item to search for
   * 
   * @return The number of times item occurs in this DSLinkedList
   */
  public int count(E item){
    return 0;
  }


  /**
   * Removes and returns the right-most item from the queue.
   * 
   * @return The last item enqueued, or null if the List is empty.
   */
  public E popRight(){
    return null;
  }

  

  public String toString(){
    String rv = "[";
    Box b = this.first;
    while(b != null){
        rv = rv + b.item + ", ";
        b = b.next;
    }
    rv += "]";
    return rv;
  }

  // Inner Class for the boxes in a linked list
  class Box {

    E item;
    Box next;

    // Constructor
    public Box(E newItem){
        this.item = newItem;
    }
  }
}

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

  public int length() {
    return numberOfItems;
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

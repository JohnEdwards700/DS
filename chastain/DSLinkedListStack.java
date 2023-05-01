public class DSLinkedListStack<E> implements DSStack<E>{
    
    Box top;
    int numberOfItems;

    /**
     * Adds a new item to the top of the stack 
     */
    public void push(E newItem){
        Box newbox = new Box(newItem);

        if(this.numberOfItems == 0){
            this.top = newbox;
        } else {
	    newbox.next = this.top;
            this.top = newbox;
        }
        this.numberOfItems++; 
    }

    public E pop() {
       E x = (E)(new Object()); 
       return x;
    }

    public int length(){
        return numberOfItems;
    }

    public String toString(){
        String rv = "[";
        Box b = this.top;
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

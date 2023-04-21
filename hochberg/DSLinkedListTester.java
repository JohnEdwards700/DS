public class DSLinkedListTester {
    
    public static void main(String[] args){
        DSLinkedList<Integer> l = new DSLinkedList<>();

        l.enqueue(17);
        l.enqueue(17);
        l.enqueue(1717);

        System.out.println("Queue length is " + l.length());
        System.out.println("Queue is " + l);
        l.dequeue();
        l.dequeue();
        l.dequeue();
        System.out.println("Queue length is " + l.length());
        System.out.println("Queue is " + l);
    }
}

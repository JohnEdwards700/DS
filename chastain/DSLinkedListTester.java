public class DSLinkedListTester {
    public static void main(String[] args){
    DSLinkedList<Integer> l = new DSLinkedList<>();

    l.enqueue(4);
    l.enqueue(3);
    l.enqueue(33);
    int x = l.dequeue();
    l.dequeue();

    System.out.println("First thing dequeued " + x);
    System.out.println("Queue length is " + l.length());
    System.out.println("Queue is " + l);
    }
}

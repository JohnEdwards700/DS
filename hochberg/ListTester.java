/**
 * To test our various implementataions of the List ADT
 * add, get, length, remove, replace, toString, sort, lookup, contains
 */

class ListTester {

  public static void main(String[] args) {

    //integerTest();
    stringTest();

  }

  /**
   * For testing a List of Strings
   */
  static void stringTest(){
    DSArrayList<String> l = new DSArrayList<String>();
    l.add("love");
    l.add("hate");

    System.out.println("The list has size " + l.length());

  }

  /**
   * For testing the DSArrayListOfInts class
   */
  static void integerTest(){
    DSArrayListOfInts l = new DSArrayListOfInts();

    l.add(7);
    l.add(1);
    l.add(7);

    System.out.printf("List has %d items, which should be 3.\n", l.length());

    int x = l.get(1); // This should be 1

    System.out.printf("This should be 1. It is %d\n", x);
    System.out.println("Before removing @idx 0" + l); // Print the list
    l.remove(0); // Remove the 3 from the list
    System.out.println("After removing @idx 0" + l); // Print the list
    System.out.printf("List has %d items, which should be 2.\n", l.length());

    l.add(7);
    l.add(7);
    l.add(9);

    System.out.println(l); // Print the list

    l.replace(2, 99);
    System.out.println(l); // Print the list

    System.out.println("This many 7s: " + l.count(7));
    System.out.println("Index of 7: " + l.find(7));
    System.out.println("This many 0s: " + l.count(0));
    System.out.println("Index of 0: " + l.find(0));

    for (int i = 0; i < 1000000; i++) {
      l.add(i);
    }
    //System.out.println(l); // Print the list
    System.out.println("The list has size " + l.length());
  }
}

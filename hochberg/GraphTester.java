import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GraphTester {
  static HashMap<String, DSArrayList<String>> graph;

  public static void main(String[] args) {
    //graph = new HashMap<>();
    //buildGraph();
    buildWordGraphFromFile("words4.txt");
    findShortestPath("tide", "bale");
  }

  /**
   * Find the shortest path in graph from start to end
   * @param start
   * @param end
   */
  static void findShortestPath(String start, String end){
    DSQueue<String> q = new DSLinkedList<String>();
    HashMap<String, Integer> distance = new HashMap<>();
    HashMap<String, String> parent = new HashMap<>();

    q.enqueue(start);
    distance.put(start, 0);
    parent.put(start, null); // only vertex with a null parent
    // Useful for terminating a while loop

    while(q.length() > 0){
      System.out.println(q);
      String v = q.dequeue();
      //for(String n : graph.get(v)){ // Won't work. DSArrayList is not Iterable.
      DSArrayList<String> neighbors = graph.get(v);
      System.out.println("(***" + v);
      for(int i = 0; i < neighbors.length(); i++){   
        String n = neighbors.get(i);
        if(!distance.containsKey(n)){
          q.enqueue(n);
          distance.put(n, distance.get(v)+1);
          parent.put(n, v);
        }
      }
    }
    System.out.println(distance);
    System.out.println(parent);
    printPath(end, parent);
  }

  /** 
   *  Reconstruct the path from v back to the root 
  */
  static void printPath(String v, HashMap<String, String> parent){
    String rv = v;
    while(parent.get(v) != null){
      v = parent.get(v);
      rv = v + "->" + rv;
    }
    System.out.println(rv);
  }

  static void buildGraph() {
    String[][] graphWords = new String[][] { { "live", "five", "hive", "dive" },
        { "five", "live", "dive", "hive", "fire" },
        { "have", "save", "hove", "gave", "rave", "hive", "hate", "cave", "pave" },
        { "hire", "fire", "hive", "hide", "wire", "tire", "mire", "hike", "hare" },
        { "sale", "male", "hale", "sole", "bale", "kale", "pale", "vale", "yale" },
        { "dive", "live", "jive", "hive", "give", "five", "dire", "diva", "dove", "dice", "dike", "dime", "dine" },
        { "fire", "hire", "five", "tire", "dire", "fare", "file" },
        { "find", "bind", "kind", "fins", "fink", "fond", "mind", "rind" },
        { "dine", "wine", "mine", "fine", "line", "dive", "pine", "nine" },
        { "cave", "rave", "dave", "sale", "sate", "same", "sane", "wave" },
        { "hint", "mint", "lint", "tint", "pint", "hilt", "hist", "hind" },
        { "sane", "lane", "bane", "mane", "cane", "dane", "vane", "pane", "wane" },
        { "hive", "five", "dive", "have", "hire", "hide", "hike", "hove" },
        { "this", "thin", "ghis", "thir" },
        { "time", "lime", "dime", "mime", "tome", "tide", "tire", "tile", "tine", "tike" },
        { "rain", "fain", "gain", "main", "pain", "vain", "wain", "rein", "raid", "rail" },
        { "rime", "dime", "ride", "rite", "rome" },
        { "live", "five", "dive", "hive", "love", "lime", "lice", "like", "line", "lite", "give", "life" },
        { "sing", "ring", "ping", "ting", "king", "wing", "bing", "ding", "fing", "ling", "ming" },
        { "hard", "lard", "bard", "yard", "card", "herd", "harp", "hark", "harm", "hart", "hand" },
    };

    // Build the graph
    for (String[] entry : graphWords) {
      String key = entry[0];
      for (int i = 1; i < entry.length; i++) {
        if(!graph.containsKey(key)){
          graph.put(key, new DSArrayList<>());
        }
        if(graph.get(key).find(entry[i]) == -1)
          graph.get(key).add(entry[i]);

        if(!graph.containsKey(entry[i])){
          graph.put(entry[i], new DSArrayList<>());
        }
        if(graph.get(entry[i]).find(key) == -1)
          graph.get(entry[i]).add(key);
      }
    }

    // Prints the graph
    for (String key : graph.keySet()) {
      System.out.println(key + ":" + graph.get(key));
    }

    // System.out.println("graphWords[4][2] is " + graphWords[4][2]);

    String friendliest = getFriendliest(graph);
    System.out.println("Friendliest word = " + friendliest);
  }

  /**
   * Use BFS to find the length of a shortest path in a graph
   * 
   * @param g     The graph
   * @param start The first vertex of the path
   * @param end   The destination vertex to search for
   */
  public static int lengthOfShortestPath(HashMap<String, DSArrayList<String>> g,
      String start,
      String end) {
    return -1;

  }

  public static String getFriendliest(HashMap<String, DSArrayList<String>> g) {
    // Discover that key with the most neighbors, and return it
    String friend = "";
    int curMax = 0;

    for (String key : g.keySet()) {
      if (g.get(key).length() > curMax) {
        friend = key;
        curMax = g.get(key).length();
      }
    }

    return friend;
  }

  /**
   * Read the words in filename.
   * Works by side effects, filling the wordList field.
   */
  static DSArrayList<String> readWords(String filename) {
    DSArrayList<String> rv = new DSArrayList<>();

    try {
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);

      // Read the words from the file into rv
      int count = 0;
      String s;
      while ((s = br.readLine()) != null) {
        rv.add(s);
        count++;
      }
      System.out.println("Found " + count + " words.");
      br.close();
      fr.close();
    } catch (IOException e) {
    }

    return rv;
  }

  /**
   * Returns the # of characters difference
   * We assume they have the same length
   * 
   * @param s1 First string
   * @param s2 Second string
   *
   * @return The number of characters on which they differ
   */
  static int distance(String s1, String s2) {
    int d = 0;
    if (s1.length() != s2.length())
      System.out.println(">" + s1 + "<>" + s2 + "<");
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i))
        d++;
    }
    return d;
  }

  /**
   * Return all words in wordList that differ by 1 letter from "word"
   * 
   * @param word     The word whose neighbors we are finding
   * @param wordList List of strings that we consider words
   *
   * @return DSArrayList of words that are one letter different
   */
  static DSArrayList<String> findAllAdjacentWords(String word, DSArrayList<String> wordList) {
    DSArrayList<String> rv = new DSArrayList<String>();
    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String newWord = word.substring(0, i) + c + word.substring(i + 1);
        if (newWord.equals(word))
          continue;
        if (wordList.count(newWord) > 0)
          rv.add(newWord);
      }
    }
    return rv;
  }

  /**
   * Fill, by side effects, the graph HashMap from a file
   * The vertices are the words in the file
   * Edges of the graph connect words that differ by one letter.
   * 
   * It is assumed that all words in the file have the same length.
   * 
   * @param filename The name of the file to read
   */
  static void buildWordGraphFromFile(String filename) {
    DSArrayList<String> wordList = readWords(filename);
    graph = buildGraph(wordList);

  }

  /**
   * Build a word ladder graph from a list of words
   * The resulting structure is a hash map.
   * Each word is a key in the hash map
   * The value associated with each key is an ArrayList of its neighbors
   *
   * @param dict the word list
   */
  static HashMap<String, DSArrayList<String>> buildGraph(DSArrayList<String> wordList) {

    HashMap<String, DSArrayList<String>> rv = new HashMap<>();
    int numWords = wordList.length();

    for (int i = 0; i < numWords - 1; i++) {
      String word = wordList.get(i);
      rv.put(word, new DSArrayList<String>()); // empty list of neighbors
      for (int j = i + 1; j < numWords; j++) {
        String otherWord = wordList.get(j);
        if (distance(word, otherWord) == 1) {
          rv.get(word).add(otherWord);
          if (!rv.containsKey(otherWord)) {
            rv.put(otherWord, new DSArrayList<String>());
          }
          rv.get(otherWord).add(word);
        }      
      }
    }
    return rv;
  }

}

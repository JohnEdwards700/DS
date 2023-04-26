import java.util.HashMap;

public class GraphTester {
    public static void main(String[] args){
        HashMap<String, DSArrayList<String>> graph = new HashMap<>();
        String[][] graphWords = new String[][] {{"live", "five","dive"},
    {"five","live","dive"},{"have","save","hove","gave"},{"dive","five","live"},{"save","have","gave"},{"hove","have"},{"gave","save","have"}};

    // Build the graph
    for (String[] entry : graphWords){
        DSArrayList<String> l = new DSArrayList<>();
        String key = entry[0];
        for (int i = 1; i < entry.length; i++){
            l.add(entry[i]);
        }
        graph.put(key, l);
    }

    for (String key : graph.keySet()){
        System.out.println(key + ":" + graph.get(key));
    }

    // Initialize the Visited List
    DSArrayList<String> visited = new DSArrayList<>();
    
    // Breadth First Search Implementation
    

    System.out.println("graphWords[2][2] is " + graphWords[2][2]);
    }    
}

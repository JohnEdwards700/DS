import java.util.HashMap;

public class GraphTester {
    public static void main(String[] args){
        HashMap<String, DSArrayList<String>> graph = new HashMap<>();

        // Connected Graph example
        String[][] graphWords = new String[][] {{"live", "five","dive"},
 {"five","live","dive","fave"},{"fave","have","save","gave","five"}, {"have","save","hove","gave","fave"},{"dive","five","live"},{"save","have","gave","fave"},{"hove","have"},{"gave","save","have","fave"}};

/*
    String[][] graphWords = new String[][] {{"live", "five","dive"},
 {"five","live","dive"},{"have","save","gave"}, {"have","save","hove","gave"},{"dive","five","live"},{"save","have","gave"},{"hove","have"},{"gave","save","have"}};
*/
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

    // Make Queue for BFS
    DSLinkedList<String> toSearch = new DSLinkedList<>();
    String rootVtx = "have";


    // Breadth First Search Implementation
    visited.add(rootVtx);
    toSearch.enqueue(rootVtx);
    HashMap<String, Integer> distFromRoot = new HashMap<>();
    distFromRoot.put(rootVtx,0);  

    while(toSearch.length() != 0){
        String v = toSearch.dequeue();
        DSArrayList<String> nbrs = graph.get(v);
        for (int i = 0; i < nbrs.length(); i++){
            String nbr = nbrs.get(i);
            if(visited.find(nbr) == -1){
                visited.add(nbr);
		// Make the shortest distance 1+dist for the parent
		distFromRoot.put(nbr,1+distFromRoot.get(v));
                toSearch.enqueue(nbr);
            }
        }
        System.out.println("Visited " + visited);
        System.out.println("Searching " + toSearch);
    }
        System.out.println("Searching " + toSearch);

    // Check if undirected graph is connected
	System.out.println("Graph connected " + (visited.length() == graph.size()) );

    for (String key : distFromRoot.keySet()){
        System.out.println("dist" + key + ":" + distFromRoot.get(key));
    }
}
}

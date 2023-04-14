import java.util.HashMap;

public class GraphTester {
    public static void main(String[] args){
        HashMap<String, DSArrayList<String>> graph = new HashMap<>();
        String[][] graphWords = new String[][] {{"live", "five"},
    {"five","live","dive"},{"have","save","hove","gave"}};

    // Build the graph
    for (String[] entry : graphWords){
        DSArrayList<String> l = new DSArrayList<>();
        String key = entry[0];

    }
    }    
}

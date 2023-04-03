import java.util.HashMap;

public class GraphTester {

  public static void main(String[] args) {
    HashMap<String, DSArrayList<String>> graph = new HashMap<>();

    String[][] graphWords = new String[][]
     {{"live", "five", "hive", "dive"},
      {"five", "live", "dive", "hive", "fire"},
      {"have", "save", "hove", "gave","rave", "hive", "hate", "cave","pave"} ,
       {"hire", "fire", "hive", "hide", "wire", "tire", "mire", "hike", "hare"},
       {"sale", "male", "hale", "sole", "bale", "kale", "pale", "vale", "yale"},
       {"dive", "live", "jive", "hive", "give", "five", "dire", "diva", "dove", "dice", "dike", "dime", "dine"},       
       {"fire", "hire", "five", "tire", "dire", "fare", "file"},       
       {"find", "bind", "kind", "fins", "fink", "fond", "mind", "rind"},      
       {"live", "five", "dive", "hive", "love", "lime", "lice", "like", "line", "lite", "give", "life"},      
       {"dine", "wine", "mine", "fine", "line", "dive", "pine", "nine"},      
       {"cave", "rave", "dave", "sale", "sate", "same", "sane", "wave"},       
       {"hint", "mint", "lint", "tint", "pint", "hilt", "hist", "hind"},      
       {"sane", "lane", "bane", "mane", "cane", "dane", "vane", "pane", "wane"},       
       {"hive", "five", "dive", "have", "hire", "hide", "hike", "hove"},       
       {"this", "thin", "ghis", "thir" },    
       {"time", "lime", "dime", "mime", "tome", "tide", "tire", "tile", "tine", "tike"},
       {"rain", "fain", "gain", "main", "pain", "vain", "wain", "rein", "raid", "rail"},  
       {"rime", "dime", "ride", "rite", "rome"},  
       {"sing", "ring", "ping", "ting", "king", "wing", "bing", "ding", "fing", "ling", "ming"},
       {"hard", "lard", "bard", "yard", "card", "herd", "harp", "hark", "harm", "hart", "hand"},
      };

    for (String[] entry : graphWords) {
      DSArrayList<String> l = new DSArrayList<>();
      String key = entry[0];
      for (int i = 1; i < entry.length; i++) {
        l.add(entry[i]);
      }
      graph.put(key, l);
    }

    for (String key : graph.keySet()) {
      System.out.println(key + ":" + graph.get(key));
    }
  }
}

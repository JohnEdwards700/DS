import java.util.HashMap;

class ListTester {

	public static void main(String[] args){
		DSArrayList<String> l = new DSArrayList<String>(); 

		l.add("Hello");
		l.add("Hey");

		System.out.println("Here is the list: " + l);
		System.out.println("The list has size " + l.length());
		System.out.println("The last element of the list is " + l.get(l.length()-1));

		HashMap<String, String> h = new HashMap<>();
		h.put("Jake","Hello Class");
		h.put("Xavier","Grover Cleveland is my favorite president");

		System.out.println("Jake says: " + h.get("Jake"));
		System.out.println("Xavier says: " + h.get("Xavier"));
	}
}

import java.util.*;

public class Iterator_With_HashMap {
	public static void main(String[] args) {
		// create an Map
		Map < String, String > map = new HashMap<>();
		System.out.println("Initial size of Map: " + map.size());

		// Putting elements into the Map
		map.put("Hello", "World");
		map.put("James", "Bond");
		map.put("Abdur", "Razzak");
		map.put("Hash", "Map");
		map.put("Array", "List");
		map.put("Good", "Bye");
		System.out.println("Size of the Map after adding some elements: " + map.size());

		// Get a set of the entries
		Set set = map.entrySet();

		// Get an Iterator 
		Iterator itr = set.iterator();  

		// Display elements using iterator
		while ( itr.hasNext() ) {
			Map.Entry me = (Map.Entry)itr.next();
			System.out.print(me.getKey() + " : ");
			System.out.println(me.getValue());
		}	

	}
}
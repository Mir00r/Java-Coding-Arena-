import java.util.*;

public class HashMapExample {
	public static void main(String[] args) {
		// create an map
		Map < String, String > map = new HashMap<>();
		System.out.println("Initial size of Map: " + map.size());

		// put elements to the Map
		map.put("Hello", "World");
		map.put("James", "Bond");
		map.put("Abdur", "Razzak");
		map.put("Hash", "Map");
		map.put("Array", "List");
		map.put("Good", "Bye");
		System.out.println("Size of the map after adding some elements: " + map.size());

		// Get one element
		System.out.println ("What is after 'Abdur': " + map.get("Abdur"));
	
		// Get all the values
		System.out.println ("All the values: " + map.values());
		
	}
}
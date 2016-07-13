import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		// create an array List
		List < String > list = new ArrayList<>();
		System.out.println("Initial size of List: " + list.size());

		// add elements to the array list
		list.add("R");
		list.add("A");
		list.add("Z");
		list.add("Z");
		list.add("A");
		list.add("K");
		System.out.println("Size of the list after adding some elements: " + list.size());

		// Display all the elements
		System.out.println ("Elements of List: " + list);

		// Display first element
		System.out.println ("Elements of List: " + list.get(0));
	
		// Remove elements
		list.remove(1);
		System.out.println ("Size of List after deletion: " + list.size());
		System.out.println ("Elements of List: " + list);

		// Search elements
		list.remove(1);
		System.out.println ("Does list contains 'A': " + list.contains("A"));
		System.out.println ("Does list contains 'Z': " + list.contains("B"));
	}
}
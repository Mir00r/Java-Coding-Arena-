import java.util.*;

public class Iterator_With_ArrayList {
	public static void main(String[] args) {
		// create an ArrayList
		List < String > list = new ArrayList<>();
		System.out.println("Initial size of List: " + list.size());

		// Adding elements into the ArrayList
		list.add("R");
		list.add("A");
		list.add("Z");
		list.add("Z");
		list.add("A");
		list.add("K");
		System.out.println("Size of the List after adding some elements: " + list.size());

		// Display All the elements using Iterator 
		System.out.print ("Contains of the List: ");
		Iterator itr = list.iterator(); // create iterator 

		// search iterator
		while ( itr.hasNext() ) {
			System.out.print(" " + itr.next());
		}	

		// display all elements using for-each
		System.out.print("\nContains of the list in for-each:");
		for ( String str : list ) {
			System.out.print(" " + str);
		}
	}
}
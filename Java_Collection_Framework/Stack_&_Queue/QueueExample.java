import java.util.*;

public class QueueExample {
	public static void main(String[] args) {
		// create an Queue
		Queue Q = new LinkedList();
		System.out.println("Initial size of Queue: " + Q.size());

		// Adding elements into the Queue
		Q.add(1);
		Q.add(2);
		Q.add(3);
		Q.add(4);
		Q.add(5);
		Q.add(6);
		System.out.println("Size of the Queue after adding some elements: " + Q.size());

		// Display All the elements of Queue
		System.out.println ("Contains of the Queue: " + Q);
	
		// Popping an element
		try{
			Q.remove();
		}
		catch (NoSuchElementException e ){
			System.out.println("Queue is empty");
		}

		// Display rest of the elements in Queue
		System.out.println("Rest of the elements in Queue: " + Q);		

	}
}
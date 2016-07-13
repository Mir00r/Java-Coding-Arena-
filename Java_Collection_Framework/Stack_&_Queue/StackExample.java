import java.util.*;

public class StackExample {
	public static void main(String[] args) {
		// create an Stack
		Stack st = new Stack();
		System.out.println("Initial size of Stack: " + st.size());

		// pushing elements into the Stack
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		System.out.println("Size of the Stack after adding some elements: " + st.size());

		// Display All the elements of Stack
		System.out.println ("Contains of the Stack: " + st);
	
		// Popping an element
		try{
			st.pop();
		}
		catch (EmptyStackException e ){
			System.out.println("Stack is empty");
		}

		// Display rest of the elements in stack
		System.out.println("Rest of the elements in Stack: " + st);

		// Search element from Stack
		System.out.println("Does stack Contains 6: " + st.search(6));
		System.out.println("Does stack Contains 1: " + st.search(1));		

	}
}
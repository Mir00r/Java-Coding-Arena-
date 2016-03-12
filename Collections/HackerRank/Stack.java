// Way 1

import java.util.*;
class Solution{
   
  
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      //Stack st = new Stack();
      int i, len;
      boolean flag = true;
       
      while ( sc.hasNextLine() ) { 
         Stack st = new Stack();
         String bracket = sc.nextLine();
          String tmp = "R";
          
          for ( i = 0; i < bracket.length(); i++ ) {
              flag = true;
              tmp = bracket.substring( i, i + 1 );
              
              if ( tmp.equals("(") || tmp.equals("{") || tmp.equals("[") )
                  st.push(tmp);
              else {
                  if ( tmp.equals(")") ) {
                      if ( !st.empty() ) {

                          if ( st.peek().equals("(") ) {
                              st.pop();
                              continue;
                          }
                          else {
                              flag = false;
                              break;
                          }
                      }
                      else {
                          flag = false;
                          break;
                      }
                  }

                  else if ( tmp.equals("}") ) {
                      if ( !st.empty() ) {

                          if ( st.peek().equals("{") ) {
                              st.pop();
                              continue;
                          }
                          else {
                              flag = false;
                              break;
                          }
                      }
                      else {
                          flag = false;
                          break;
                      }
                  }

                  else if ( tmp.equals("]") ) {
                      if ( !st.empty() ) {

                          if ( st.peek().equals("[") ) {
                              st.pop();
                              continue;
                          }
                          else {
                              flag = false;
                              break;
                          }
                      }
                      else {
                          flag = false;
                          break;
                      }
                  }
              }

          }

           if ( st.empty() == false ) flag = false;

           if (flag) 
               System.out.println("true");
           else
               System.out.println("false");

           while ( !st.empty()) st.pop();
      }
   }
}

// Way 2 

import java.util.*;
class Solution{
   
   public static void main(String []argh){
      		Scanner sc = new Scanner(System.in);
	      boolean check = false;

	    while (sc.hasNextLine()) {
	        Stack myStack = new Stack();
	        String input = sc.nextLine();
	       
	        int len = input.length(), i;
	        String tmp = "R";
	        
	        for ( i = 0; i < len; i++){
	            check = false;
	            tmp = input.substring( i, i + 1 );
	           // System.out.println(c);
	            if ( !myStack.empty() ) {
	                if ( ( tmp.equals( ")" ) ) && ( myStack.peek().equals( "(" ) ) ) {
	                    myStack.pop();
	                    check = true;
	                }

	                if ( ( tmp.equals( "]" ) ) && ( myStack.peek().equals( "[" ) ) ) {
	                    myStack.pop();
	                    check = true;
	                }

	                if ( ( tmp.equals( "}" ) ) && ( myStack.peek().equals( "{" ) ) ) {
	                    myStack.pop();
	                    check = true;
	                }

	                if ( !check ){
	                    myStack.push(tmp);}
	            } 
	            else{
	                myStack.push(tmp);
	            }       
	        }

	        if ( myStack.empty() ) {
	        	System.out.println("true");
	        }
	        else{
	        	System.out.println("false");
	        }
	    }
      
   }
}

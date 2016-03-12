import java.util.*;
import java.io.*;

class Solution{
   public static void main(String []argh){
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      in.nextLine();
      int i;
      
      Map < String, Integer > phonebook = new HashMap < String, Integer >();{
          for( i = 0; i < n; i++){
             String name = in.nextLine();
             int phone = in.nextInt();
             in.nextLine();
             phonebook.put (name, phone);
             //in.nextLine();
          }
      }
      
      while(in.hasNext()){
         String str = in.nextLine();
         if ( phonebook.containsKey(str) )
             System.out.println (str + "=" + phonebook.get(str));
         else
            System.out.println("Not found");     
      }
   }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
   public static void main(String[] args){
      
       Scanner in = new Scanner(System.in);
       int testCases = Integer.parseInt(in.nextLine());
       while(testCases > 0){
           String line = in.nextLine();
         
             //Write your code here
           int current = 0; boolean notValid = true;
           for(int x = 0; x < line.length(); x++){
               
               int start = line.indexOf("<", current);
               if(start < 0) break;

               int end = line.indexOf(">", start);
               if(end < 0) break;

               String tag = line.substring(start+1, end);

               if(tag.length() == 0 || tag.charAt(0) == '/'){
                   current = end + 1;
                   continue;
                }

                int opposite = line.indexOf("</" + tag + ">");

                if(opposite >= 1){
                    String candidate = line.substring(end+1, opposite);

                    if(candidate.length() > 0 && candidate.indexOf("<") < 0){
                        System.out.println(candidate);
                        notValid = false;

                    }
                }
                current = end + 1;
            }
           if(notValid) System.out.println("None");
           testCases--;
        }
        testCases--;
   }
}

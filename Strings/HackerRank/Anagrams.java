import java.io.*;
import java.util.*;

public class Solution {

   static boolean isAnagram(String A, String B) {
      //Complete the function
      int[] cnt = new int[26];  
       A = A.toLowerCase(); 
       B = B.toLowerCase();
       
       int lenA = A.length();
       int lenB = B.length();

       if (lenA != lenB) return false;

       // initial count to 0.
       for (int i = 0; i < 26; i++)
       {
           cnt[i] = 0;
       }

       // count letter frequency in A
       for (int i = 0; i < lenA; i++)
       {
           int k = A.charAt(i) - 'a';
           cnt[k]++;
       }

       // minus letter frequency in B
       for (int i = 0; i < lenB; i++)
       {
           int k = B.charAt(i) - 'a';
           cnt[k]--;
           if (cnt[k] < 0) return false;
       }
       return true;
       
       
       /*
       A = A.toLowerCase();
      B = B.toLowerCase();
      
      int len_A = A.length();
      int len_B = B.length();
      //int a = 0, b = 0;
       int sum = 0, i;
       
       for ( i = 0; i < len_A; i++ )
           sum += (int)A.charAt(i);
       
       for ( i = 0; i < len_B; i++ )
           sum -= (int)B.charAt(i);
       
       if ( sum == 0 )
           return true;
       else
           return false;
       */
       /*
       if ( len_A != len_B)
           return false;
       else{
           int tmp = Math.max (len_A, len_B);
           for ( int i = 0; i < tmp; i++ ){
               a += (int)A.charAt(i) - 'a';
               b += (int)B.charAt(i) - 'a';
           }
       }
       
       if ( a == b )
           return true;
       else
           return false;
       */
       
       /*
       String tot = ( A + B ).toLowerCase();
       int sum = 0;
       for ( int i = 0; i < A.length(); i++ ){
           sum ^= (int)tot.charAt(i);
       }
       
       if ( sum == 0)
           return true;
       else
           return false;
       */
   }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        boolean ret = isAnagram(A, B);
        if( ret )
            System.out.println("Anagrams");
        else 
            System.out.println("Not Anagrams");
        
    }
}

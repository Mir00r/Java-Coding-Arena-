import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        char[] str = A.toCharArray();
        boolean check = true;
        int len = A.length();
        
        for ( int i = 0; i < len / 2; i++ ){
            if ( str[i] != str[len - i - 1] ){
                System.out.println("No");
                check = false;
                break;
            }
        }
        
        if ( check == true)
            System.out.println("Yes");
    
        /*
            System.out.println( A.equals( new StringBuilder(A).reverse().toString()) 
                ? "Yes" : "No" );
        */
    
    }
}

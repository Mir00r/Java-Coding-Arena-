import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt();
        
        List<String> ls = new ArrayList<>();
        String tmp ;
        
        for ( int i = 0; i < str.length() - ( num - 1); i++ ){
            tmp = str.substring( i, i + num );
            ls.add(tmp);
        }
       Collections.sort(ls);
        
        System.out.println(ls.get(0));
        System.out.println(ls.get(ls.size() - 1));
    }
}

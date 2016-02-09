import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int cs = 1;
       
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.printf("%d %s", cs++, str);
            System.out.println();
        }
    }
}

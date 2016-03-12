import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int tc, i;
        HashSet < String > hs = new HashSet < String >();
        tc = in.nextInt();
        
        for ( i = 0; i < tc; i++ ) {
            String name = in.nextLine();
            hs.add(name);
            System.out.println(hs.size());
        }
        */
        int i, tc;
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        sc.nextLine();

        HashSet < String > hs = new HashSet < String >();
        
        for( i = 0; i < tc; i++){
            String name = sc.nextLine();
            hs.add(name);
            System.out.println(hs.size());
        }
    }
}

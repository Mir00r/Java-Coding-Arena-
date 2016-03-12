import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, q, x, y, d, i, j, num;
        ArrayList arr = new ArrayList();
        //ArrayList brr = new ArrayList();
        ArrayList brr;
        
        n = in.nextInt();
        for ( i = 0; i < n; i++  ) {
            brr = new ArrayList();
            d = in.nextInt();
            for ( j = 0; j < d; j++ ) {
               // num = in.nextInt();
                //arr.add(num);
                brr.add(in.next());
            }
            arr.add(brr);
        }
        
        q = in.nextInt();
        for ( i = 0; i < q; i++ ){
            x = in.nextInt();
            y = in.nextInt();
            
            try{
                brr = (ArrayList) arr.get( x - 1 );
                System.out.println(brr.get( y - 1 ) );
            }
            catch( Exception e ){
                System.out.println("ERROR!");
            }
        }
    }
}

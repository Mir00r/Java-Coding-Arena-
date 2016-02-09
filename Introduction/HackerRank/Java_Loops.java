import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int tc, n, a, b, i, j, sum;
        
        tc = sc.nextInt();
        for ( j = 0; j < tc; j++ ){
            a = sc.nextInt();
            b = sc.nextInt();
            n = sc.nextInt();
            sum = a;
            for ( i = 0; i < n; i++ ){
                sum = sum + (int)Math.pow(2, i) * b;
                System.out.printf("%d ", sum);
            }
            System.out.println();
        }
    }
}

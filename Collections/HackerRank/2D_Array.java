import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        int i, j;
        
        for( i = 0; i < 6; i++){
            for( j = 0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int maxn = - 999999999;
        int sum = 0;
        
        for ( i = 0; i < 4; i++ ) {
            for ( j = 0; j < 4; j++ ) {
                sum = ( arr[ i ][ j ] + arr[ i ][ j + 1 ] + 
                      arr[ i ][ j + 2 ] + arr[ i + 1 ][ j + 1 ] + 
                      arr[ i + 2 ][ j ] + arr[ i + 2 ][ j + 1 ] + 
                      arr[ i + 2 ][ j + 2 ] );
            
                if ( sum > maxn ) maxn = sum;
            }
        }
        
        System.out.println(maxn);
    }
}

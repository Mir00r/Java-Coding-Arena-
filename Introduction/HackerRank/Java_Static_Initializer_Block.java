import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

// Start Static Initialization Part
static boolean flag;
static int H, B, area;

static{
    Scanner sc = new Scanner(System.in);
    H = sc.nextInt();
    B = sc.nextInt();
    
    if (H > 0 && B > 0){
        flag = true;
    }
    else{
        flag = false;
        System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
}
// End Static Initialization Part

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class


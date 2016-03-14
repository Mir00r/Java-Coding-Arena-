import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x, y, ans;
        try{
            x = in.nextInt();
            y = in.nextInt();
            
            ans = x / y;
            System.out.println(ans);
        }
        catch(InputMismatchException ime){
            System.out.println(ime.getClass().getName());
        }
        catch(ArithmeticException ae){
            System.out.println(ae.getClass().getName()+": "+ae.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

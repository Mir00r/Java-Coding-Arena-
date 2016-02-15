import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        
        BigInteger add, mul;
        
        add = a.add(b);
        mul = a.multiply(b);
        
        System.out.println(add);
        System.out.println(mul);
    }
}

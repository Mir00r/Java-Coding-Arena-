import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Date;
import java.text.*;
import javax.swing.*;
import java.util.*;


class Arithmetic { 
    static int getname(){ 
        System.out.println("Arithmetic"); 
        return 0; 
    } 
}

class Adder extends Arithmetic {
    int add (int a, int b){
        return ( a + b );
    }
    
}

class Solution{

    public static void main(String []argh){
        Adder X=new Adder();
        System.out.println("My superclass is: "+X.getClass().getSuperclass().getName());    
        System.out.print(X.add(10,32)+" "+X.add(10,3)+" "+X.add(10,10)+"\n");
    }
}

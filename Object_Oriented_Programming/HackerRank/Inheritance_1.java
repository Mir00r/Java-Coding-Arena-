import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Date;
import java.text.*;
import javax.swing.*;
import java.util.*;


class Animal{
   void walk()
   {
      System.out.println("I am walking");
   }
}

class Bird extends Animal
{
   void fly()
   {
      System.out.println("I am flying");
   }
    void sing(){
        System.out.println("I am singing");
    }
}
public class Solution
{

   public static void main(String args[])
   {

     Bird bird = new Bird();
     bird.walk();
     bird.fly();
     bird.sing();
   }
}

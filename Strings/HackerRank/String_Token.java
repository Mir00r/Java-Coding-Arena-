import java.io.*;
    import java.util.*;



    public class Solution {
        public static void main(String[] args) 
        {
          Scanner scan = new Scanner(System.in);
          String s = scan.nextLine();
          //Complete the code
          StringTokenizer st = new StringTokenizer(s,"!,?._'@ "); 
            System.out.println(st.countTokens()); 
            
            while (st.hasMoreTokens()) { 
                System.out.println(st.nextToken()); 
            }  
            
            /*
            StringTokenizer s = new StringTokenizer (str);
            int cnt = 0;
            
            while (s.hasMoreTokens()) cnt++;
            System.out.println(cnt);
            while (s.hasMoreTokens())
                System.out.println(s.nextToken());
            */
        }
    }

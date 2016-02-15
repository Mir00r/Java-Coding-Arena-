import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []argh)
    {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         int i, j;
        
        String []s = new String[n+2];
        for( i = 0; i < n; i++)
        {
            s[i] = sc.next();
        }

        //Write your code here
        //Collections.sort(s);
       
        for( i = 1; i < n ; i++ ){
            String temp = s[i];
        
            for (j = i - 1; j >= 0 && new BigDecimal(s[j]).compareTo(new BigDecimal(temp))== -1 ; j--) {
                s[j+1] = s[j];
            }
            s[j+1] = temp;
        }
        
        
        /*
        Arrays.sort( s, new Comparator<String>(){
            public int compare ( String fs, String sec ){
                BigDecimal first = new BigDecimal(fs);
                BigDecimal second = new BigDecimal(sec);
                
                int res = fs.compareTo( sec );
                if ( res == 0 )
                    return res;
                else
                    //return first.compareTo( second );
                    return second.compareTo( first );
                
            }
        });
        */
        
        //Output
        for( i = 0; i < n; i++)
        {
            System.out.println(s[i]);
        }

    }


}

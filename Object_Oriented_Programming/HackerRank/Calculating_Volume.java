import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import java.security.Permission;

class Volume{
    public static double main(int... arg) throws IOException{
        if(arg.length == 1){ //calculate cube volume
            return Math.pow(arg[0], 3);
        }
        else if(arg.length == 3){ //calculate cuboid volume          
            return (double)(arg[0] * arg[1] * arg[2]);
        }
        throw new IOException("Incorect number of arguments");
    }

    public static double main(double... arg) throws IOException{
        if(arg.length == 1){ //calculate hemisphere volume            
            return ((2.0/3.0) * Math.PI * Math.pow(arg[0], 3));
        }
        else if(arg.length == 2){ //calculate cyllinder volume            
            return (Math.PI * Math.pow(arg[0], 2) * arg[1] );
        }
        throw new IOException("Incorect number of arguments");
    }

    public static void display(double volume){
        double roundUp  = new BigDecimal(String.valueOf(volume)).setScale(3,RoundingMode.HALF_UP).doubleValue();
        DecimalFormat f = new DecimalFormat("##.000");
        System.out.println(f.format(roundUp));
    }  
}

class Calculate{ 
    static Volume output = new Volume(); 
    static Scanner sc = new Scanner(System.in);
    
    public static Volume get_Vol(){
        return output;
    }

    public static double getDoubleVal() throws NumberFormatException{
        double val = sc.nextDouble();
        if( val <= 0.0f ) throw new NumberFormatException("All the values must be positive");
        return val;
    }
    public static int getINTVal() throws NumberFormatException{
        int val = sc.nextInt();
        if( val <= 0 ) throw new NumberFormatException("All the values must be positive");
        return val;
    }   
}

public class Solution
{
	
	public static void main(String[] args) {
		Do_Not_Terminate.forbidExit();		
		try{
			Calculate cal=new Calculate();
			int T=cal.getINTVal();
			while(T-->0){
			double volume = 0.0d;		
			int ch=cal.getINTVal();			
			if(ch==1){
			
				int a=cal.getINTVal();
				volume=Calculate.get_Vol().main(a);
				
				
			}
			else if(ch==2){
			
				int l=cal.getINTVal();
				int b=cal.getINTVal();
				int h=cal.getINTVal();
				volume=Calculate.get_Vol().main(l,b,h);
				
			}
			else if(ch==3){
			
				double r=cal.getDoubleVal();
				volume=Calculate.get_Vol().main(r);
				
			}
			else if(ch==4){
			
				double r=cal.getDoubleVal();
				double h=cal.getDoubleVal();
				volume=Calculate.get_Vol().main(r,h);
				
			}
			cal.output.display(volume);
			}
					
		}
		catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
		
		
	}
}
/**
 *This class prevents the user from using System.exit(0)
 * from terminating the program abnormally.
 */
class Do_Not_Terminate {
	 
    public static class ExitTrappedException extends SecurityException {
    }
 
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}//end of Do_Not_Terminate	
	

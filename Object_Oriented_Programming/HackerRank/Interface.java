mport java.util.*;
interface AdvancedArithmetic{
  public abstract int divisorSum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    public int divisorSum ( int n ) {
        int i, sum = 0;
        for ( i = 1; i <= n; i++ ) {
            if ( n % i == 0)
                sum += i;
        }
        return sum;
    }
}

class Solution{

    public static void main(String []argh)
    {
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(my_calculator.divisorSum(n)+"\n");

    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o)
    {

        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++)
        {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

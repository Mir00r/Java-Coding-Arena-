/* package whatever; // don't place package name! */

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mir00r at ISTL
 */
class CountDaysInMonth {

    public static void main(String[] args) {
        int iYear = 2017;
        int iMonth = Calendar.MAY; 
        int iDay = 31;
        
        int i, ans = 0;
        int firstOccuranceDayInMonth = 0;
        
        Calendar myCal = Calendar.getInstance();
        myCal.set(iYear, iMonth, iDay);
        
        if ( iDay > 7 ) {
            if ( iDay % 7 == 0 ) {
                firstOccuranceDayInMonth = 7;
            }
            else {
                firstOccuranceDayInMonth = iDay % 7;
            }
        }
        else {
            firstOccuranceDayInMonth = iDay;
        }
        
        int maxDayInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        do {    
            firstOccuranceDayInMonth += 7;
            ans++;
        }while ( firstOccuranceDayInMonth <= maxDayInMonth );
        
        System.out.println("Number of days in Month --------------> " +ans);
    }
}
package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

import org.apache.poi.ss.formula.functions.Now;

public class Date {

	public static String selectFutureDate(int futureDate) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, futureDate);

		String newDate = dateFormat.format(cal.getTime());
		//System.out.println(newDate);
		return newDate;

	}

	public static String selectPreviousDate(int previousDate) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, previousDate);

		
		String newDate = dateFormat.format(cal.getTime());
		//System.out.println(newDate);
		return newDate;

	}
	
	
	public static void main(String args[])
	{
		
		    
	
		//System.out.println(d1.selectFutureDate(75));
		//System.out.println(d1.selectPreviousDate(-30));	
		
        Now n = new Now();

        Date d=new Date();
        
        System.out.println(d);
        System.out.println(n);

        String TimeStamp =  LocalTime.now().toString().replace(":", "_").replace(".", "_");

        SimpleDateFormat sd=new SimpleDateFormat("YYYY_MM_dd");

        TimeStamp =sd.format(d)+"__"+TimeStamp;
 System.out.println(TimeStamp);
       // return TimeStamp;
		
	}
	

}

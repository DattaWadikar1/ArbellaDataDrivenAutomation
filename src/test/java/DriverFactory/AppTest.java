package DriverFactory;

import org.testng.annotations.Test;

public class AppTest
{
	@Test
	public void kickStart() throws Throwable
	{

		DriverScript s=new DriverScript();
		
		try
		{
			s.startTest();
		}
		catch(Exception e)
		{
		e.printStackTrace();
	    }	
	}
}



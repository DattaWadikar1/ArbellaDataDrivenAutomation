package DriverFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class homeowners {


	public void hi() throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);

		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");		
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();

		Thread.sleep(5000);
		List<WebElement> sGetTagNames =  driver.findElements(By.tagName("p"));
		System.out.println(sGetTagNames.size());

		TrueFalse = false;
		for (int i=0;i<=sGetTagNames.size()-1;i++)
		{
			String value = sGetTagNames.get(i).getAttribute("id");
			if (value.equalsIgnoreCase("_zipCityStateMessage"))
				TrueFalse = true;            
			if (TrueFalse)
			{
				sGetTagNames.get(i).findElement(By.tagName("span")).click();    
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='Please click here to select a city and State']/descendant::a")).click();   
				break;
			}
		}

		String aa=driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).getAttribute("Value");
		System.out.println(aa);

		Select select = new Select(driver.findElement(By.xpath("//select[contains(@name,'MailingAddress') and contains(@id,'StateProvCd')]")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem);

	}



	public void NewCode() throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02769");		
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);


		try {
			WebElement link_pleaseClickHereToSelectCityAndState = driver.findElement(By.id("_zipCityStateSelectionHelper"));
			if(link_pleaseClickHereToSelectCityAndState.isDisplayed())
			{
				link_pleaseClickHereToSelectCityAndState.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void Testing() throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Personal Auto");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02769");		
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);
		driver.findElement(By.id("continueButton")).click();

		WebElement alert_getAlertId = driver.findElement(By.id("alert"));
		List<WebElement> alert_getAllTheAlerts = alert_getAlertId.findElements(By.tagName("p"));
		System.out.println(alert_getAllTheAlerts.size());

		String sActualAlertMessage="Applicant First Name is a required field.".replace(" ", "");
		System.out.println(sActualAlertMessage);
		String sExpectedAlertMessage;

		for(int i=0;i<=alert_getAllTheAlerts.size()-1;i++)
		{
			sExpectedAlertMessage = alert_getAllTheAlerts.get(i).getText().replace(" ", "");
			System.out.println(sExpectedAlertMessage);

			if (sExpectedAlertMessage.contains(sActualAlertMessage))
			{
				System.out.println("Displayed");
				break;
			}

		}



	}


	public void Testing_GuiValidationsLinks(String sInputData ) throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);

		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");	
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);

		/*	List<WebElement> sGetSubLinks= driver.findElements(By.xpath(sInputData));	 
		 for (int i=0; i<=sGetSubLinks.size()-1;i++)
		 {
			 String sLinks = sGetSubLinks.get(i).getAttribute("innerText");
			 System.out.println(sLinks);
		 }*/

		WebElement sGetSubLink= driver.findElement(By.xpath(sInputData));
		sGetSubLink.click();
	}


	public static String selectFuturePreviousYearOnly(String testdata) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		int fpDate = Integer.parseInt(testdata);
		cal.add(Calendar.YEAR, fpDate);
		String newDate = dateFormat.format(cal.getTime());
      System.out.println(newDate);
		return newDate;
	}
	public void click_Zip() throws InterruptedException
	{

		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);



		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");	
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);
		
		boolean TrueFalse = driver.findElement(By.id("_zipCityStateSelectionHelper")).isDisplayed();	
		System.out.println(TrueFalse);
		Thread.sleep(3000);
/*
		List<WebElement> abc=     driver.findElements(By.xpath("//td[text()='Please click here to select a city and State']/descendant::a"));

		for (int i=0;i<=abc.size();i++)
		{
			String a =  abc.get(i).getAttribute("href");
			if(a.contains("CAMBRIDGE"))

			{
				abc.get(i).click();
				break;
			}


		}*/
	}

	
	public void click_Zip1() throws InterruptedException
	{

		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);



		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
        driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
	    driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");	
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);
		
		//boolean TrueFalse = driver.findElement(By.id("_zipCityStateSelectionHelper")).isDisplayed();	
		///System.out.println(TrueFalse);
		Thread.sleep(9000);
		
		WebElement option1= driver.findElement(By.xpath("//input[@name='SP.RiskLocationAndMailingSameInd']"));
	
	        if(option1.isSelected())
	        {
	        	option1.click();
	        }
	        option1.click();
	}
	
	

	public static void deSelectAllTheCheckBoxes() throws Throwable

	{
		
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);



		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
        driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
	    driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");	
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		

		Thread.sleep(9000);

			List<WebElement> checkBox= driver.findElements(By.className("checkbox"));

			for(int i=0;i<=checkBox.size()-1;i++)
			{
				if(checkBox.get(i).isSelected())
				{
				   checkBox.get(i).click();
				   Thread.sleep(3000);
				}				
			}
			
	}	
		       public static void Extract_Links_Staging() throws InterruptedException
		       {

		              System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		              WebDriver driver1=new InternetExplorerDriver();

		              driver1.manage().window().maximize();
		              driver1.get("http://arbella.com.verndale-staging.com/");
		              
		              Thread.sleep(3000);
		              driver1.switchTo().alert().accept();
		              
		              List<WebElement> AllLinks = driver1.findElements(By.xpath("//a"));
		              TreeMap<String,String> AllLinksMap = new TreeMap<String, String>();
//		            
		              int LinksCount = AllLinks.size();
		              
		              for (int i = 0; i<LinksCount ; i++ ) {

//		                  System.out.println(AllLinks.get(i).getAttribute("href") + "->" + AllLinks.get(i).getText());
//		                  WebElement element = AllLinks.get(i);
//		                  JavascriptExecutor executor = (JavascriptExecutor) driver;
//		                  Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
//		                  System.out.println(AllLinks.get(i).getAttribute("href") + "->" + aa.toString() + "->" + AllLinks.get(i).getText().trim());
//		                  System.out.println(AllLinks.get(i).getAttribute("href") + "->" + AllLinks.get(i).getText().trim());
		                     
		                     try {
		                            AllLinksMap.put(AllLinks.get(i).getText(),AllLinks.get(i).getAttribute("href"));
		                     } catch (NullPointerException e) {
		                           
		                     }
		              }
		              
//		            System.out.println(AllLinksMap);

		              /*for (Entry<String, String> entry : AllLinksMap.entrySet())
		              {
		                     System.out.println("\"" + entry.getValue() + "\"" + ", " + entry.getKey());
		              }*/
		              
		              driver1.quit();
		       }

		       public void Extract_Links_Prod() throws InterruptedException
		       {

		              System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		              WebDriver driver1=new InternetExplorerDriver();

		              driver1.manage().window().maximize();
		              driver1.get("http://arbella.com");
		              Thread.sleep(3000);
		              
		              //List<WebElement> AllLinks = driver.findElements(By.xpath("//a[not(contains(@href,'javascript') or contains(@href,'#'))]"));
		              //List<WebElement> AllLinks = driver1.findElements(By.xpath("//a[not(contains(@href,'javascript'))]"));
		              List<WebElement> AllLinks = driver1.findElements(By.xpath("//a"));
		              LinkedHashMap<String,String> AllLinksMap = new LinkedHashMap<String, String>();
		              int LinksCount = AllLinks.size();
		              
		              for (int i = 0; i<LinksCount ; i++ ) {
		                     if (isAttribtuePresent(AllLinks.get(i), "href") && !AllLinks.get(i).getText().isEmpty()) {
		                           System.out.println(AllLinks.get(i).getAttribute("href") + "->" + AllLinks.get(i).getText().replace("\n", " "));
		                          AllLinksMap.put(AllLinks.get(i).getAttribute("href"),AllLinks.get(i).getText().replace("\n", " "));
		                     }
		                     
				       
		              }   
		              List<WebElement> AllLinks1 = driver1.findElements(By.xpath("//a[@class='carousel-callout-item__text']"));
		              LinkedHashMap<String,String> AllLinksMap1 = new LinkedHashMap<String, String>();
		              int LinksCount1 = AllLinks1.size();
				              for (int ii = 0; ii<LinksCount1 ; ii++ ) {
				                     if (isAttribtuePresent(AllLinks1.get(ii),"href")) {
				                           System.out.println(AllLinks1.get(ii).getAttribute("href") + "->" + AllLinks1.get(ii).getText().replace("\n", " "));
				                          AllLinksMap1.put(AllLinks1.get(ii).getAttribute("href"),AllLinks1.get(ii).getText().replace("\n", " "));
				                     }
				              }
		                     
		/*******************************************************************************************************************************************
//		                  WebElement element = AllLinks.get(i);
//		                  JavascriptExecutor executor = (JavascriptExecutor) driver;
//		                  Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
//		                  System.out.println(AllLinks.get(i).getAttribute("href") + "->" + aa.toString() + "->" + AllLinks.get(i).getText().trim());
//		                  System.out.println(AllLinks.get(i).getAttribute("href") + "->" + AllLinks.get(i).getText().trim());
//		                  try {
//		                         
//		                         AllLinksMap.put(AllLinks.get(i).getText(),AllLinks.get(i).getAttribute("href"));
//		                         
//		                  } catch (NullPointerException e){
//		                         
//		                  }
		********************************************************************************************************************************************/
		              
		             
//		            
//		            
//		            
//		            System.out.println(AllLinksMap);

//		            for (Entry<String, String> entry : AllLinksMap.entrySet())
//		            {
//		                System.out.println("\"" + entry.getKey() + "\"" + ", " + entry.getValue());
//		            }
		              
		              driver1.quit();
		       }
		       
		       private boolean isAttribtuePresent(WebElement element, String attribute) {
		           Boolean result = false;
		           try {
		               String value = element.getAttribute(attribute);
		               if(!value.isEmpty()) {
		                    result = true;
		               }
		               else if (value != null){
		                   result = true;
		               } 
		           } catch (Exception e) {}

		           return result;
		       }
		       
		       
		public static void selectbyname() throws InterruptedException
		{
			System.out.println("this is selectbyname");
			System.out.println();
			Extract_Links_Staging();
		}

	


	

		public static void main(String[] args) throws Throwable 
		{

			Rough SampleCode = new Rough();
			//SampleCode.NewCode();
			//SampleCode.Testing_GuiValidationsLinks("//li[@class='imatm topMenuItem_standard']/a[text()='Work In Progress']/../div[@class='imsc']/div[@class='imsubc']/ul/li/a");
			//SampleCode.Testing_GuiValidationsLinks("//a[text()=concat('Worker',\"'\")]");
			//		SampleCode.Testing_GuiValidationsLinks("//a[text()=concat('Worker',\"'\",'s Comp Search')]/ancestor::li/a[text()='Commercial Lines']");
			//		SampleCode.Testing_GuiValidationsLinks("//a[text()=concat('Worker',\"'\",'s Comp Inbox')]/ancestor::li/a[text()='Commercial Lines']");
			//		SampleCode.Testing_GuiValidationsLinks("//a[text()='CL Inbox']/ancestor::li/a[text()='Commercial Lines']");
			//SampleCode.click_Zip();
			//SampleCode.deSelectAllTheCheckBoxes();
            SampleCode.Extract_Links_Prod();
		}


	}



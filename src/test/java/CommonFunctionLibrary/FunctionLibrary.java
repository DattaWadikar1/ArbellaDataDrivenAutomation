package CommonFunctionLibrary;



import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Now;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyFileUtil;

import org.openqa.selenium.interactions.Actions;

public class FunctionLibrary {
	Actions action;
	public static DesiredCapabilities capab = null;
	public static String CovADwellingLimit=null;
	public static String CovCPersonalProperty=null;
	
	public static WebDriver startBrowser(WebDriver driver,String sEnvironment) throws Throwable
	{
		
		System.out.println("Closing All Browsers");
		FunctionLibrary.closeAll_Browsers();
		System.out.println("All Browsers are Closed");
		if(sEnvironment.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(sEnvironment.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./CommonJarFile/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(sEnvironment.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
			/*capab = DesiredCapabilities.internetExplorer();

			// To disable popup blocker.
			capab.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
			// to enable protected mode settings
			capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			// to get window focus
			capab.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			// to set zoom level is set to 100% so that the native mouse events
			// can be set to the correct coordinates.
			capab.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capab.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			capab.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);*/
			
			
			
			
			driver=new InternetExplorerDriver();
		}
		return driver;

	}
	public static void openApplication(WebDriver driver) throws Throwable, Throwable
	{
		driver.manage().window().maximize();
		driver.get(PropertyFileUtil.getValueForKey("Url"));
	}
	public static void radioBtnSelect(WebDriver driver,String locaterType,String locatervalue)
	{
		if(locaterType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("cssSelector"))
		{
			driver.findElement(By.cssSelector(locatervalue)).click();
		}
	}
	
	public static void clickAction(WebDriver driver,String locaterType,String locatervalue)
	{
		if(locaterType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("partialLinkText"))
		{
			driver.findElement(By.partialLinkText(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("cssSelector"))
		{
			driver.findElement(By.cssSelector(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("linkText"))
		{
			driver.findElement(By.linkText(locatervalue)).click();
		}				
		else if(locaterType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatervalue)).click();
		}
		else if(locaterType.equalsIgnoreCase("className"))
		{
			driver.findElement(By.className(locatervalue)).click();
		}
	}
	public static void typeAction(WebDriver driver,String locaterType,String locatervalue,String Data)
	{
		if(locaterType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatervalue)).clear();
			driver.findElement(By.id(locatervalue)).sendKeys(Data);
		}
		else if(locaterType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatervalue)).clear();
			driver.findElement(By.name(locatervalue)).sendKeys(Data);
		}
		else if(locaterType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatervalue)).clear();
			driver.findElement(By.xpath(locatervalue)).sendKeys(Data);
		}
	}
	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
	}
	public static void waitForElement(WebDriver driver,String locaterType,String locatervalue)
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		if(locaterType.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatervalue)));
		}
		else if(locaterType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatervalue)));
		}
		else if(locaterType.equalsIgnoreCase("cssSelector"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatervalue)));
		}

		else if(locaterType.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatervalue)));
		}
		else if(locaterType.equalsIgnoreCase("linkText"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatervalue)));
		}

		else if(locaterType.equalsIgnoreCase("partialLinkText"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatervalue)));
		}

		else if(locaterType.equalsIgnoreCase("className"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatervalue)));
		}
	}
	public static void selectAction(WebDriver driver,String locatortype,String locatervalue,String dropdown)
	{

		if(locatortype.equalsIgnoreCase("id"))
		{
			Select s=new Select(driver.findElement(By.id(locatervalue)));
			s.selectByValue(dropdown);
		}
		else if(locatortype.equalsIgnoreCase("name"))
		{
			Select s=new Select(driver.findElement(By.name(locatervalue)));
			s.selectByValue(dropdown);
		}
		else if(locatortype.equalsIgnoreCase("xpath"))
		{
			Select s=new Select(driver.findElement(By.xpath(locatervalue)));
			s.selectByValue(dropdown);
		}

	}



	public static void selectActionByVisibleText(WebDriver driver,String locatortype,String locatervalue,String dropdown)
	{

		if(locatortype.equalsIgnoreCase("id"))
		{
			Select s=new Select(driver.findElement(By.id(locatervalue)));
			s.selectByVisibleText(dropdown);
		}
		else if(locatortype.equalsIgnoreCase("name"))
		{
			Select s=new Select(driver.findElement(By.name(locatervalue)));
			s.selectByVisibleText(dropdown);
		}
		else if(locatortype.equalsIgnoreCase("xpath"))
		{
			Select s=new Select(driver.findElement(By.xpath(locatervalue)));
			s.selectByVisibleText(dropdown);
		}

	}
	public static void selectByIndex(WebDriver driver,String locatortype,String locatervalue,String text)
	{

		int index = Integer.parseInt(text);
		if(locatortype.equalsIgnoreCase("id"))
		{
			Select s=new Select(driver.findElement(By.id(locatervalue)));
			s.selectByIndex(index);
		}
		else if(locatortype.equalsIgnoreCase("name"))
		{
			Select s=new Select(driver.findElement(By.name(locatervalue)));
			s.selectByIndex(index);
		}
		else if(locatortype.equalsIgnoreCase("xpath"))
		{
			Select s=new Select(driver.findElement(By.xpath(locatervalue)));
			s.selectByIndex(index);
		}

	}
	public static void  titleValidation(WebDriver driver, String exp_title)
	{
		String act_title=driver.getTitle();
		Assert.assertEquals(exp_title, act_title);
	}

	public static String generateDate()
	{
		Now n = new Now();
		Date d=new Date();
		String TimeStamp =  LocalTime.now().toString().replace(":", "_").replace(".", "_");
		SimpleDateFormat sd=new SimpleDateFormat("YYYY_MM_dd");
		TimeStamp =sd.format(d)+"__"+TimeStamp;	
		return TimeStamp;		
	}

	public static String generateDateTimeForHtmlFile()
	{
		Now n = new Now();
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("YYMMdd");
		String TimeStamp =sd.format(d)+"__"+LocalTime.now().getHour()+LocalTime.now().getMinute();	
		return TimeStamp;	

	}

	public  static void tableValidation(WebDriver driver,String colNum) throws Throwable
	{
		FileReader fr=new FileReader("./captureData/data.txt");
		BufferedReader br=new BufferedReader(fr);
		String expt_data=br.readLine();
		//conversion from String to integer
		int colnum=Integer.parseInt(colNum);

	}
	public static void captureData(WebDriver driver,String locatertype,String locatervalue) throws Throwable
	{
		String data="";
		if(locatertype.equalsIgnoreCase("id"))
		{
			data=driver.findElement(By.id(locatervalue)).getAttribute("value");
		}
		else if(locatertype.equalsIgnoreCase("name"))
		{
			data=driver.findElement(By.name(locatervalue)).getAttribute("value");
		}
		else if(locatertype.equalsIgnoreCase("xpath"))
		{
			data=driver.findElement(By.xpath(locatervalue)).getAttribute("value");
		}
		FileWriter fos=new FileWriter("./captureData/Data.txt");
		BufferedWriter bo=new BufferedWriter(fos);
		bo.write(data);
		bo.flush();
		bo.close();


	}
	public static void tableValidation(WebDriver driver,String act_value,String locatertype,String locatervalue)
	{

		if(locatertype.equalsIgnoreCase("id"))
		{
			String expt_value=driver.findElement(By.id(locatervalue)).getText();
			Assert.assertEquals(act_value, expt_value);
		}
		else if(locatertype.equalsIgnoreCase("name"))
		{
			String expt_value=driver.findElement(By.name(locatervalue)).getText();
			Assert.assertEquals(act_value, expt_value);
		}
		else if(locatertype.equalsIgnoreCase("xpath"))
		{
			String expt_value=driver.findElement(By.xpath(locatervalue)).getText();
			Assert.assertEquals(act_value, expt_value);
		}
	}
	public static void popUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public static void handleAlerts(WebDriver driver)
	{ 
		driver.switchTo().alert().accept();
	} 
	public static void MouseOverOnElement(WebDriver driver,String locatertype,String locatervalue)
	{
		Actions actions = new Actions(driver);

		if(locatertype.equalsIgnoreCase("id"))
		{
			WebElement element = driver.findElement(By.id(locatervalue));
			actions.moveToElement(element).build().perform();
		}
		else if(locatertype.equalsIgnoreCase("name"))
		{
			WebElement element = driver.findElement(By.name(locatervalue));
			actions.moveToElement(element).build().perform();
		}
		else if(locatertype.equalsIgnoreCase("xpath"))
		{
			WebElement element = driver.findElement(By.xpath(locatervalue));
			actions.moveToElement(element).build().perform();
		}

	}


	public static void PageElementValidation(WebDriver driver,String locatertype,String locatervalue,String exp_Value)
	{
		if(locatertype.equalsIgnoreCase("id"))
		{
			String act_value=driver.findElement(By.id(locatervalue)).getAttribute("innerText");
			Assert.assertEquals(act_value, exp_Value);
		}
		else if(locatertype.equalsIgnoreCase("name"))
		{
			String act_value=driver.findElement(By.name(locatervalue)).getAttribute("innerText");
			Assert.assertEquals(act_value, exp_Value);
		}
		else if(locatertype.equalsIgnoreCase("xpath"))
		{
			String act_value=driver.findElement(By.xpath(locatervalue)).getAttribute("innerText");
			Assert.assertEquals(act_value.trim(), exp_Value.trim());
		}


	}
	public static void  PauseScript() throws InterruptedException
	{
		Thread.sleep(10000);
	}
	public static void implicitWait(String test_Data) throws InterruptedException {

		int timeSecond=Integer.parseInt(test_Data);
		Thread.sleep(1000*timeSecond); 
	}

	public static void typeActionEmptyField(WebDriver driver,String locaterType,String locatervalue)
	{
		if(locaterType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatervalue)).clear();

		}
		else if(locaterType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatervalue)).clear();

		}
		else if(locaterType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatervalue)).clear();

		}
	}

	public static boolean verifyFormLabel(WebDriver driver, String blockName, String ExpectedAlertMessage)

	{

		boolean TrueFalse = false;

		List<WebElement> getAllTheFormLabels = driver.findElements(By.xpath("//table[@summary='"+blockName+"']//tr/td[@class='formLabel']"));

		System.out.println(getAllTheFormLabels.size());

		String ActualAlertMessage;

		for (int i = 0; i <= getAllTheFormLabels.size() - 1; i++)

		{

			ActualAlertMessage = getAllTheFormLabels.get(i).getText().replace(" ", "");
 
			ExpectedAlertMessage = ExpectedAlertMessage.replace(" ", "");

			if (ActualAlertMessage.contains(ExpectedAlertMessage))

			{
				TrueFalse = true;

				break;

			}

		}

		return TrueFalse;

	}
	

	public static boolean verifyFormLabelIsNotDisplayed(WebDriver driver,String locatertype,String expectedFieldName)

	{
		
		boolean TrueFalse = true;
		
		if(locatertype.equalsIgnoreCase("span"))
		{
		

		List<WebElement> getAllTheFormLabels = driver.findElements(By.xpath("//span[contains(text(),*)]"));

		System.out.println(getAllTheFormLabels.size());

		String ActualFieldName;

		for (int i = 0; i <= getAllTheFormLabels.size() - 1; i++)

		{

			ActualFieldName = getAllTheFormLabels.get(i).getText().replace(" ", "");
			expectedFieldName= expectedFieldName.replace(" ", "");

			if (ActualFieldName.contains(expectedFieldName))

			{
				TrueFalse = false;

				break;

			}

		}
		
		}
		

		return TrueFalse;

	}
	public static boolean getHo3CovCPersonalProperty(WebDriver driver,String locatertype,String locatervalue,String testData) throws Throwable
	{
	boolean TrueFalse =true;
		String CovADwellingLimit=driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'DWELL')]")).getAttribute("value");
		System.out.println(CovADwellingLimit);
		CovADwellingLimit=CovADwellingLimit.replace(",", "");
		System.out.println(CovADwellingLimit);
		int ExpectedCovCPersonalProperty = Integer.parseInt(CovADwellingLimit);
		ExpectedCovCPersonalProperty=(ExpectedCovCPersonalProperty*50)/100;
		
		String CovCPersonalProperty= driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'PP')]")).getAttribute("value");
		CovCPersonalProperty=CovCPersonalProperty.replace(",", "");
		int ActualCovCPersonalProperty= Integer.parseInt(CovCPersonalProperty);
		if (ExpectedCovCPersonalProperty == ActualCovCPersonalProperty)
		{
			
		}
		else
		{
			TrueFalse =false;
		}
		
		return TrueFalse;
	}
	
	public static boolean getHo3CovDPersonalPropertyFromCovA(WebDriver driver,String locatertype,String locatervalue,String testData) throws Throwable
	{
	boolean TrueFalse =true;
		String CovADwellingLimit=driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'DWELL')]")).getAttribute("value");
		System.out.println(CovADwellingLimit);
		CovADwellingLimit=CovADwellingLimit.replace(",", "");
		System.out.println(CovADwellingLimit);
		int ExpectedCovADwellingLimit = Integer.parseInt(CovADwellingLimit);
		ExpectedCovADwellingLimit=(ExpectedCovADwellingLimit*20)/100;
		
		
		String CovDLossofUse= driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'LOU')]")).getAttribute("value");
		CovDLossofUse=CovDLossofUse.replace(",", "");
		int ActualCovDLossofUse= Integer.parseInt(CovDLossofUse);
		if (ExpectedCovADwellingLimit == ActualCovDLossofUse)
		{
			
		}
		else
		{
			TrueFalse =false;
		}
		
		return TrueFalse;
	}
	
	
	public static boolean getHo4CovDLossofUseValue(WebDriver driver,String locatertype,String locatervalue,String testData) throws Throwable
	{
	boolean TrueFalse =true;
		String CovCPersonalProperty=driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'PP')]")).getAttribute("value");
		CovCPersonalProperty=CovCPersonalProperty.replace(",", "");
		System.out.println(CovCPersonalProperty);
		int ExpectedCovDLossofUse = Integer.parseInt(CovCPersonalProperty);
		ExpectedCovDLossofUse=(ExpectedCovDLossofUse*20)/100;
		
		String CovDLossofUse= driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'LOU')]")).getAttribute("value");
		CovDLossofUse=CovDLossofUse.replace(",", "");
		int ActualCovDLossofUse = Integer.parseInt(CovDLossofUse);
		if (ExpectedCovDLossofUse == ActualCovDLossofUse)
		{
			
		}
		else
		{
			TrueFalse =false;
		}
		
		return TrueFalse;
	}
	
	public static boolean getHo6CovDLossofUseValue(WebDriver driver,String locatertype,String locatervalue,String testData) throws Throwable
	{
	boolean TrueFalse =true;
		String CovCPersonalProperty=driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'PP')]")).getAttribute("value");
		CovCPersonalProperty=CovCPersonalProperty.replace(",", "");
		System.out.println(CovCPersonalProperty);
		int ExpectedCovDLossofUse = Integer.parseInt(CovCPersonalProperty);
		ExpectedCovDLossofUse=(ExpectedCovDLossofUse*40)/100;
		
		String CovDLossofUse= driver.findElement(By.xpath("//input[contains(@id,'HomeLineBusiness.Dwell.Coverage[CoverageCd') and contains(@id,'LOU')]")).getAttribute("value");
		CovDLossofUse=CovDLossofUse.replace(",", "");
		int ActualCovDLossofUse = Integer.parseInt(CovDLossofUse);
		if (ExpectedCovDLossofUse == ActualCovDLossofUse)
		{
			
		}
		else
		{
			TrueFalse =false;
		}
		
		return TrueFalse;
	}
	public static boolean verifyGenericLabel(WebDriver driver, String locatervalue,String expTestData)

	{

		boolean TrueFalse = false;

		List<WebElement> getAllTheFormLabels = driver.findElements(By.xpath(locatervalue));

		System.out.println(getAllTheFormLabels.size());

		String actLabelTest;

		for (int i = 0; i <= getAllTheFormLabels.size() - 1; i++)

		{

			actLabelTest = getAllTheFormLabels.get(i).getText().replace(" ", "").toUpperCase();
 
			expTestData = expTestData.replace(" ", "").toUpperCase();

			if (actLabelTest.contains(expTestData))

			{
				TrueFalse = true;

				break;

			}

		}

		return TrueFalse;

	}
	
	public static boolean verifyGenericLabelNotDisplayed(WebDriver driver, String locatervalue,String expTestData)

	{

		boolean TrueFalse = true;

		try {
			List<WebElement> getAllTheFormLabels = driver.findElements(By.xpath(locatervalue));
			System.out.println(getAllTheFormLabels.size());
			String actLabelTest;
			for (int i = 0; i <= getAllTheFormLabels.size() - 1; i++)

			{

				actLabelTest = getAllTheFormLabels.get(i).getText().replace(" ", "");

				expTestData = expTestData.replace(" ", "");

				if (actLabelTest.contains(expTestData))

				{
					TrueFalse = false;

					break;

				}

			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return TrueFalse;

	}
	
	public static void closeAll_Browsers()
	{
		
		/*System.setProperty("webdriver.chrome.driver", "./CommonJarFile/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		
		WebDriver chromeDriver = new ChromeDriver();
		WebDriver InternetExplorerDriver=new InternetExplorerDriver();
		
		System.out.println(chromeDriver.getWindowHandles().size());
		for(String eachWindowHandle:chromeDriver.getWindowHandles()){
		            chromeDriver.switchTo().window(eachWindowHandle).close();
		        }
		System.out.println("_________________________________________");
		System.out.println(InternetExplorerDriver.getWindowHandles().size());
		for(String eachWindowHandle:InternetExplorerDriver.getWindowHandles()){
			       InternetExplorerDriver.switchTo().window(eachWindowHandle).close();
        }*/
	/*	Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("taskkill /im chrome.exe /f /t");*/


		//taskkill /F /IM iexplore.exe /T
		
	}

	
}

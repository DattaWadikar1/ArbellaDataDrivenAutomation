package com.Arbella.Keywords;

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Now;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Predicate;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunctionLibrary.FunctionLibrary;
import Utilities.PropertyFileUtil;

public class Keywords {

	public static void LoginToApplication(WebDriver driver, String sUserName, String sPassword)
			throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(sUserName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(sPassword);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public static void LoginToApplicationTester1(WebDriver driver)
			throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("tester1");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("arbella1");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	public static void LoginToApplicationTester2(WebDriver driver)
			throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Internalsc");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("Arb3lla1");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}


	public static void LoginToMIAPApplication(WebDriver driver)
			throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("qaadc1");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("arbella12");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}
	public static void verify_Login(WebDriver driver) {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Arbella Agent Home Page");

	}

	public static void mouseOverOnPersonalLine(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement qa = driver
				.findElement(By.xpath("//li[@class='imatm topMenuItem_standard']//a[text()='New Business']"));
		WebElement qa1 = driver.findElement(By.xpath(
				"//li[@class='imatm topMenuItem_standard']//a[text()='New Business']//..//a[text()='Personal Lines']"));
		WebElement qa2 = driver.findElement(By.xpath(
				"//li[@class='imatm topMenuItem_standard']//a[text()='New Business']//..//a[text()='Massachusetts']"));

		action.moveToElement(qa).moveToElement(qa1).moveToElement(qa2).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'AgencyPortal') and text()='Personal Auto']")).click();
	}

	public static void ClickOn_NB_PersonalLines_Massachusetts_Homeowners(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement qa = driver
				.findElement(By.xpath("//li[@class='imatm topMenuItem_standard']//a[text()='New Business']"));
		WebElement qa1 = driver.findElement(By.xpath(
				"//li[@class='imatm topMenuItem_standard']//a[text()='New Business']//..//a[text()='Personal Lines']"));
		WebElement qa2 = driver.findElement(By.xpath(
				"//li[@class='imatm topMenuItem_standard']//a[text()='New Business']//..//a[text()='Massachusetts']"));

		action.moveToElement(qa).moveToElement(qa1).moveToElement(qa2).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'AgencyPortal') and text()='Homeowners']")).click();
	}

	public static void ClickText(WebDriver driver, String sTagName, String sValue) {

		if (sTagName.equalsIgnoreCase("div")) {
			driver.findElement(By.xpath("//div[text()='" + sValue + "']")).click();
		} else if (sTagName.equalsIgnoreCase("input")) {
			driver.findElement(By.xpath("//input[text()='" + sValue + "']")).click();
		}
	}

	public static void enterValueByJavaScript(WebDriver driver, String locaterType, String locaterValue,
			String sValue) {

		if (locaterType.equalsIgnoreCase("Id")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('" + locaterValue + "').value = '" + sValue + "';");
		} else if (locaterType.equalsIgnoreCase("ClassName")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('" + locaterValue + "').value = '" + sValue + "';");
		}
	}

	public static void sEnterCityState(WebDriver driver) throws InterruptedException {
		boolean TrueFalse = false;

		Thread.sleep(3000);
		List<WebElement> sGetTagNames = driver.findElements(By.tagName("p"));
		System.out.println(sGetTagNames.size());

		TrueFalse = false;
		for (int i = 0; i <= sGetTagNames.size() - 1; i++) {
			String value = sGetTagNames.get(i).getAttribute("id");
			System.out.println(value);
			if (value.equalsIgnoreCase("_zipCityStateMessage"))
				TrueFalse = true;
			if (TrueFalse) {
				sGetTagNames.get(i).findElement(By.tagName("span")).click();
				Thread.sleep(2000);
				driver.findElement(
						By.xpath("//td[text()='Please click here to select a city and State']/descendant::a")).click();
				break;
			}
		}



	}

	public static boolean verifyUnderWriterRule(WebDriver driver, String ExpectedAlertMessage)

	{

		boolean TrueFalse = false;

		try {
			WebElement alert_getAlertId = driver.findElement(By.id("alert"));
			//WebElement alert_getAlertId = driver.findElement(By.xpath("//*[(@id='alert') or (@id='WORKITEMID')]"));
			List<WebElement> alert_getAllTheAlerts = alert_getAlertId.findElements(By.tagName("p"));
			System.out.println(alert_getAllTheAlerts.size());
			ExpectedAlertMessage = ExpectedAlertMessage.replace(" ", "");
			System.out.println(ExpectedAlertMessage);
			String ActualAlertMessage;
			for (int i = 0; i <= alert_getAllTheAlerts.size() - 1; i++)

			{

				ActualAlertMessage = alert_getAllTheAlerts.get(i).getText().replace(" ", "");

				// System.out.println(sActualAlertMessage);

				if (ActualAlertMessage.contains(ExpectedAlertMessage))

				{

					// System.out.println("Displayed");

					TrueFalse = true;

					break;

				}

			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return TrueFalse;

	}

	// **************************************Common
	// Method*******************************************************//

	public static void selectRadioBtnByName(WebDriver driver, String radiobuttonname, String yesNo) {
		WebElement radiobtn;

		if (radiobuttonname.contains("'")) {
			String split_radiobuttonname[] = radiobuttonname.split("'");

			radiobtn = driver.findElement(By.xpath("//*[contains(text(),'" + split_radiobuttonname[0]
					+ "')]/ancestor::div[@class='radioSet']//label[contains(text(),'" + yesNo
					+ "')]//input[@type='radio']"));
		}

		else {
			radiobtn = driver.findElement(By.xpath("//*[contains(text(),'" + radiobuttonname
					+ "')]/ancestor::div[@class='radioSet']//label[contains(text(),'" + yesNo
					+ "')]//input[@type='radio']"));
		}

		radiobtn.click();

	}

	public static void selectRadioBtnByNameInWebTable(WebDriver driver, String radiobuttonname, String yesNo) {
		WebElement radiobtn;

		radiobtn = driver.findElement(By.xpath("//*[contains(text(),'" + radiobuttonname
				+ "')]/ancestor::tr[@class='formRow']//input[@value='" + yesNo + "']"));
		radiobtn.click();

	}

	public static boolean alertVerificationMsg(WebDriver driver, String expectedText) {
		boolean trueFalse = false;
		String actualText;
		actualText = driver.switchTo().alert().getText();
		System.out.println(actualText);
		actualText = actualText.replace(" ", "");
		expectedText = expectedText.replace(" ", "");

		if (expectedText.equalsIgnoreCase(actualText)) {
			driver.switchTo().alert().accept();
			trueFalse = true;
		}

		return trueFalse;

	}

	public static void selectEffectiveDate(WebDriver driver) {

		Now n = new Now();

		Date d = new Date();

		String Today = LocalTime.now().toString().replace(":", "_").replace(".", "_");

		SimpleDateFormat sd = new SimpleDateFormat("d");

		Today = sd.format(d);

		driver.findElement(By.xpath("//a[@id='PersPolicy.ContractTerm.EffectiveDt_fieldHelperCalendar']")).click();

		// find the calendar
		List<WebElement> columns = driver.findElements(By.xpath("//td[@class='calendar']/table//td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
			if (cell.getText().equals(Today)) {
				cell.click();
				break;
			}
		}

	}

	public static boolean isPresent(WebDriver driver) {
		boolean trueflase = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Click Here to add')]")));
			System.out.println("Verify that ALT+a link is displayed ");
			trueflase = true;
		} catch (Exception e) {
			System.out.println("Verify that ALT+a link is not displayed ");
		}

		return trueflase;
	}

	public static boolean ElementisNotPresent(WebDriver driver, String Locator_Type, String Locator_Value,
			String testdata) {
		boolean trueflase = false;
		try {

			List<WebElement> list = driver.findElements(
					By.xpath("//fieldset[@id='endorsements']//span[contains(text(),'" + testdata + "')]"));
			// assertTrue(list.size()>0,"Text not found!:"+testdata+"");
			if (list.size() >= 0) {

				System.out.println("Text is present:" + testdata + " ");
				trueflase = true;
			} else
				System.out.println("Text is not present:" + testdata + " ");

		} catch (Exception e) {
			System.out.println("Test is present" + e.getMessage());
		}

		return trueflase;
	}

	public static boolean ElementisPresent(WebDriver driver, String testdata) {
		boolean trueflase = false;
		try {

			List<WebElement> list = driver
					.findElements(By.xpath("//form[@id='vehicleMA']//h1[contains(text(),'" + testdata + "')]"));
			if (list.size() > 0) {

				System.out.println("Text is present:" + testdata + " ");
				trueflase = true;
			}

		} catch (Exception e) {
			System.out.println("Test is present" + e.getMessage());
		}

		return trueflase;
	}

	public static boolean webElementisDisplayedOrNot(WebDriver driver, String Locator_Type, String Locator_Value) {
		boolean trueflase = false;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {

				List<WebElement> list = driver.findElements(By.xpath(Locator_Value));
				if (list.size() > 0) {

					// System.out.println("Text is present:" + testdata + " ");
					trueflase = true;
				}

			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}
		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {

				List<WebElement> list = driver.findElements(By.id(Locator_Value));
				if (list.size() > 0) {

					// System.out.println("Text is present:" + testdata + " ");
					trueflase = true;
				}

			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}


		return trueflase;
	}


	/*public static boolean webElementisNotDisplayedorNot(WebDriver driver, String Locator_Type, String Locator_Value) {
		boolean trueflase = true;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {

				List<WebElement> list = driver.findElements(By.xpath(Locator_Value));
				if (list.size() > 0) {
					trueflase = false;
				}

			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}
		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {

				List<WebElement> list = driver.findElements(By.id(Locator_Value));
				if (list.size() > 0) {
					trueflase = false;
				}

			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}


		return trueflase;
	}*/



	public static boolean webElementisNotDisplayedorNot(WebDriver driver, String Locator_Type, String Locator_Value) {
		boolean trueflase = true;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {

				WebElement list = driver.findElement(By.xpath(Locator_Value));

				trueflase = false;

			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}
		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {

				WebElement list = driver.findElement(By.id(Locator_Value));				
				trueflase = false;
			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}


		return trueflase;
	}

	public static boolean webElementisNotDisplayed(WebDriver driver, String Locator_Type, String Locator_Value) {
		boolean trueflase = false;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {

				WebElement list = driver.findElement(By.xpath(Locator_Value));
				if (list.getAttribute("disabled").equalsIgnoreCase("disabled"))
				{
					trueflase = true;
				}


			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}
		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {

				WebElement list = driver.findElement(By.id(Locator_Value));	
				if (list.getAttribute("disabled").equalsIgnoreCase("disabled"))
				{
					trueflase = true;
				}				
			} catch (Exception e) {
				System.out.println("Test is present" + e.getMessage());
			}
		}


		return trueflase;
	}


	/*
	 * public static void selectFuturePreviousDate(WebDriver driver, String
	 * testdata) { DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	 * Calendar cal = Calendar.getInstance(); int fpDate =
	 * Integer.parseInt(testdata); cal.add(Calendar.DATE, fpDate + 1); String
	 * newDate = dateFormat.format(cal.getTime());
	 * driver.findElement(By.id("PersPolicy.ContractTerm.EffectiveDt")).sendKeys(
	 * testdata);
	 * 
	 * }
	 */

	public static String selectFuturePreviousDate(WebDriver driver, String testdata) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		int fpDate = Integer.parseInt(testdata);
		cal.add(Calendar.DATE, fpDate);
		String newDate = dateFormat.format(cal.getTime());
		driver.findElement(By.id("PersPolicy.ContractTerm.EffectiveDt")).clear();
		driver.findElement(By.id("PersPolicy.ContractTerm.EffectiveDt")).sendKeys(newDate);
		return newDate;
	}

	public static String selectGenericFuturePreviousDate(WebDriver driver, String Locator_Type, String Locator_Value, String testdata) {
		String newDate="";
		if (Locator_Type.equalsIgnoreCase("id"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.DATE, fpDate);
			newDate = dateFormat.format(cal.getTime());
			driver.findElement(By.id(Locator_Value)).clear();
			driver.findElement(By.id(Locator_Value)).sendKeys(newDate);
		}
		else if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.DATE, fpDate);
			newDate = dateFormat.format(cal.getTime());
			driver.findElement(By.xpath(Locator_Value)).clear();
			driver.findElement(By.xpath(Locator_Value)).sendKeys(newDate);
		}
		return newDate;
	}


	public static String selectGenericFuturePreviousMonth(WebDriver driver, String Locator_Type, String Locator_Value,String testdata) {
		String newMonth="";
		if (Locator_Type.equalsIgnoreCase("id"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.MONTH, fpDate);
			newMonth = dateFormat.format(cal.getTime());
			driver.findElement(By.id(Locator_Value)).clear();
			String newMonths[] = newMonth.split("-");
			newMonth="01-"+newMonths[1]+newMonths[2];
			driver.findElement(By.id(Locator_Value)).sendKeys(newMonth);
		}
		else if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.MONTH, fpDate);
			newMonth = dateFormat.format(cal.getTime());
			driver.findElement(By.xpath(Locator_Value)).clear();
			String newMonths[] = newMonth.split("-");
			newMonth="01-"+newMonths[1]+newMonths[2];
			driver.findElement(By.xpath(Locator_Value)).sendKeys(newMonth);
		}
		return newMonth;
	}

	public static String selectGenericFuturePreviousYear(WebDriver driver, String Locator_Type, String Locator_Value,String testdata) {
		String newYear="";
		if (Locator_Type.equalsIgnoreCase("id"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.YEAR, fpDate);
			newYear = dateFormat.format(cal.getTime());
			driver.findElement(By.id(Locator_Value)).clear();
			String newDates[] = newYear.split("-");
			newYear="01-01-"+newDates[2];
			driver.findElement(By.id(Locator_Value)).sendKeys(newYear);
		}
		else if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.YEAR, fpDate);
			newYear = dateFormat.format(cal.getTime());
			driver.findElement(By.xpath(Locator_Value)).clear();
			String newDates[] = newYear.split("-");
			newYear="01-01-"+newDates[2];
			driver.findElement(By.xpath(Locator_Value)).sendKeys(newYear);
		}
		return newYear;
	}

	public static String selectGenericFuturePreviousMonthOnly(WebDriver driver, String Locator_Type, String Locator_Value,String testdata) {
		String newMonth="";
		if (Locator_Type.equalsIgnoreCase("id"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.MONTH, fpDate);
			newMonth = dateFormat.format(cal.getTime());
			driver.findElement(By.id(Locator_Value)).clear();
			driver.findElement(By.id(Locator_Value)).sendKeys(newMonth);
		}
		else if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			DateFormat dateFormat = new SimpleDateFormat("MM");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.MONTH, fpDate);
			newMonth = dateFormat.format(cal.getTime());
			driver.findElement(By.xpath(Locator_Value)).clear();
			driver.findElement(By.xpath(Locator_Value)).sendKeys(newMonth);
		}
		return newMonth;
	}

	public static String selectGenericFuturePreviousYearOnly(WebDriver driver, String Locator_Type, String Locator_Value,String testdata) {
		String newYear="";
		if (Locator_Type.equalsIgnoreCase("id"))
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.YEAR, fpDate);
			newYear = dateFormat.format(cal.getTime());
			driver.findElement(By.id(Locator_Value)).clear();
			driver.findElement(By.id(Locator_Value)).sendKeys(newYear);
		}
		else if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Calendar cal = Calendar.getInstance();
			int fpDate = Integer.parseInt(testdata);
			cal.add(Calendar.YEAR, fpDate);
			newYear = dateFormat.format(cal.getTime());
			driver.findElement(By.xpath(Locator_Value)).clear();
			driver.findElement(By.xpath(Locator_Value)).sendKeys(newYear);
		}
		return newYear;
	}


	public static void deleteAction(WebDriver driver) throws Throwable {

		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
		ele.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='font']//a[text()='Yes']")).click();

	}

	public static void navigateBack(WebDriver driver)

	{
		driver.navigate().back();

	}

	public static void AutoIT_FileUpload(WebDriver driver) throws IOException

	{
		Runtime.getRuntime().exec("C:\\Users\\mukesh_otwani\\Desktop\\AutoItScripts\\blogUpload.exe");

	}

	public static boolean verifyUnderWriterRuleMessage(WebDriver driver, String ExpectedAlertMessage)

	{

		boolean TrueFalse = false;

		WebElement alert_getAlertId = driver.findElement(By.id("alert"));

		List<WebElement> alert_getAllTheAlerts = alert_getAlertId.findElements(By.tagName("p[class='tip']"));

		System.out.println(alert_getAllTheAlerts.size());

		ExpectedAlertMessage = ExpectedAlertMessage.replace(" ", "");

		System.out.println(ExpectedAlertMessage);

		String ActualAlertMessage;

		for (int i = 0; i <= alert_getAllTheAlerts.size() - 1; i++)

		{

			ActualAlertMessage = alert_getAllTheAlerts.get(i).getText().replace(" ", "");

			// System.out.println(sActualAlertMessage);

			if (ActualAlertMessage.contains(ExpectedAlertMessage))

			{

				// System.out.println("Displayed");

				TrueFalse = true;

				break;

			}

		}

		return TrueFalse;

	}

	public static boolean verifyRadioButtonIsSelected(WebDriver driver, String radiobuttonname, String yesNo) throws InterruptedException {
		boolean TrueFalse = false;
		WebElement radiobtn;

		if (radiobuttonname.contains("'")) {
			String split_radiobuttonname[] = radiobuttonname.split("'");

			radiobtn = driver.findElement(By.xpath("//*[contains(text(),'" + split_radiobuttonname[0]
					+ "')]/ancestor::div[@class='radioSet']//label[contains(text(),'" + yesNo
					+ "')]//input[@type='radio']"));
		}

		else {
			radiobtn = driver.findElement(By.xpath("//*[contains(text(),'" + radiobuttonname
					+ "')]/ancestor::div[@class='radioSet']//label[contains(text(),'" + yesNo
					+ "')]//input[@type='radio']"));
		}

		TrueFalse = radiobtn.isSelected();
		Thread.sleep(2000);
		return TrueFalse;

	}

	public static boolean verifyDefaultValueForSelectDropDown(WebDriver driver, String locatortype, String locatervalue,
			String text) throws Throwable {
		boolean TrueFalse = false;
		String defaultItem = "";
		if (locatortype.equalsIgnoreCase("id")) {
			Select s = new Select(driver.findElement(By.id(locatervalue)));
			WebElement option = s.getFirstSelectedOption();
			defaultItem = option.getText();

		} else if (locatortype.equalsIgnoreCase("name")) {
			Select s = new Select(driver.findElement(By.name(locatervalue)));
			WebElement option = s.getFirstSelectedOption();
			defaultItem = option.getText();
		} else if (locatortype.equalsIgnoreCase("xpath")) {
			Select s = new Select(driver.findElement(By.xpath(locatervalue)));
			WebElement option = s.getFirstSelectedOption();
			Thread.sleep(2000);
			defaultItem = option.getText();
			Thread.sleep(2000);
		}
		defaultItem = defaultItem.replace("$", "");
		defaultItem = defaultItem.replace(" ", "");
		text = text.replace("$", "");
		text = text.replace(" ", "");
		if (text.equalsIgnoreCase("Blank")) {
			text = "";
		}
		if (defaultItem.equalsIgnoreCase(text))
			TrueFalse = true;

		return TrueFalse;
	}

	public static boolean webElementisReadOnly(WebDriver driver, String Locator_Type, String Locator_Value) {
		boolean trueflase = false;

		if (Locator_Type.equalsIgnoreCase("xpath")) {


			WebElement list = driver.findElement(By.xpath(Locator_Value));
			String readOlny = list.getAttribute("class");

			if (readOlny.equalsIgnoreCase("readOnly"))
			{
				trueflase = true;
			}

		}


		return trueflase;
	}

	public static void selectDateOfBirth(WebDriver driver, String testdata) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		int fpDate = Integer.parseInt(testdata);
		cal.add(Calendar.DATE, fpDate);
		String newDate = dateFormat.format(cal.getTime());
		driver.findElement(By.id("PersAutoLineBusiness.PersDriver.DriverInfo.PersonInfo.BirthDt")).clear();
		driver.findElement(By.id("PersAutoLineBusiness.PersDriver.DriverInfo.PersonInfo.BirthDt")).sendKeys(newDate);
	}

	public static boolean verifyValueIsDisplayedInDropDown(WebDriver driver, String Locator_Type, String Locator_Value,String TestData) {
		boolean trueflase = false;

		if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			Select oSelect = new Select(driver.findElement(By.xpath(Locator_Value)));
			List <WebElement> elementCount = oSelect.getOptions();
			int iSize = elementCount.size();

			for(int i =0; i<iSize ; i++)
			{
				String sValue = elementCount.get(i).getText();
				sValue=sValue.replace(" ", "");
				TestData=TestData.replace(" ", "");

				if (sValue.equalsIgnoreCase(TestData))
				{
					trueflase = true;
					break;
				}
			}
		}

		return trueflase;
	}
	
	
	public static boolean verifyAllValuesInDropDown(WebDriver driver, String Locator_Type, String Locator_Value,String TestData) {
		boolean truefalse = false;
		
		if (Locator_Type.equalsIgnoreCase("xpath"))
		{
			Select oSelect = new Select(driver.findElement(By.xpath(Locator_Value)));
			 List <WebElement> elementCount = oSelect.getOptions();
			 int iSize = elementCount.size();
			 String split_TestData[] = TestData.split("#");
			 for(int i =0; i<iSize-1 ; i++)
			 {
				 String sValue = elementCount.get(i+1).getText();				 
								 
				 if (sValue.contains(split_TestData[i]))
				 {
					 truefalse = true;
					 System.out.println("Dropdown element is:" + sValue + " ");
				 }
				 else
				 {
					 truefalse = false;
				 }
			 }			 
		}
		else if(Locator_Type.equalsIgnoreCase("id"))
		{
			Select oSelect = new Select(driver.findElement(By.id(Locator_Value)));
			 List <WebElement> elementCount = oSelect.getOptions();
			 int iSize = elementCount.size();
			 String split_TestData[] = TestData.split("#");
			 for(int i =0; i<iSize-1 ; i++)
			 {
				 String sValue = elementCount.get(i+1).getText();				 
								 
				 if (sValue.contains(split_TestData[i]))
				 {
					 truefalse = true;
					 System.out.println("Dropdown element is:" + sValue + " ");
				 }
				 else
				 {
					 truefalse = false;
				 }
			 }
		}

		return truefalse;
	}
	
	public static boolean isElementDisplayed(WebDriver driver,String Locator_Type,String Locator_Value )
	{
		boolean trueflase = false;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {

				WebElement element = driver.findElement(By.xpath(Locator_Value));

				if (element.isDisplayed()) {

					//System.out.println("Element is Displayed:" + testdata + " ");

					trueflase = true;

				}

			} catch (Exception e) {

				System.out.println("Element is Not Displayed" + e.getMessage());

			}

		}

		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {

				WebElement element = driver.findElement(By.xpath(Locator_Value));

				if (element.isDisplayed()) {


					//System.out.println("Text is present:" + testdata + " ");

					trueflase = true;

				}

			} catch (Exception e) {

				System.out.println("Element is Not Displayed" + e.getMessage());

			}

		}

		return trueflase;

	}


	
	
	public static boolean isElementDisabled(WebDriver driver,String Locator_Type,String Locator_Value )
	{
		boolean trueflase = false;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {
				
                
                String TrueFalse = driver.findElement(By.xpath(Locator_Value+"/parent::label")).getAttribute("disabled");                
                if (TrueFalse.equalsIgnoreCase("true"))
                	trueflase = true;
				

			} catch (Exception e) {
                
				
				try {
					String TrueFalse = driver.findElement(By.xpath(Locator_Value)).getAttribute("disabled");                
					if (TrueFalse.equalsIgnoreCase("true"))
						trueflase = true;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Element is Not Enabled" + e1.getMessage());
				}
				
				

			}

		}

		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {
				
	              String TrueFalse = driver.findElement(By.id(Locator_Value)).getAttribute("disabled");                
	                if (TrueFalse.equalsIgnoreCase("true"))
	                	trueflase = true;
				
			} catch (Exception e) {

				System.out.println("Element is Not Enabled" + e.getMessage());				

			}

		}

		return trueflase;

	}
	
	
	

	
	public static boolean isElementEnabled(WebDriver driver,String Locator_Type,String Locator_Value )
	{
		boolean trueflase = true;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {
				
				
				String TrueFalse = driver.findElement(By.xpath(Locator_Value+"/parent::label")).getAttribute("disabled");              
                if (TrueFalse.equalsIgnoreCase("true"))
                	trueflase = false;		
				

			} catch (Exception e) {

				try {
					String TrueFalse = driver.findElement(By.xpath(Locator_Value)).getAttribute("disabled");              
					if (TrueFalse.equalsIgnoreCase("true"))
						trueflase = false;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Element is Not Enabled" + e1.getMessage());
				}
			}

		}

		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {
				
				
			     String TrueFalse = driver.findElement(By.id(Locator_Value)).getAttribute("disabled");                
	                if (TrueFalse.equalsIgnoreCase("true"))
	                	trueflase = false;			
				
				
			} catch (Exception e) {

				System.out.println("Element is Not Enabled" + e.getMessage());				

			}

		}

		return trueflase;
	}
	
	public static boolean verifyUnderWriterRuleGeneric(WebDriver driver, String locaterValue, String ExpectedAlertMessage)

	{

		boolean TrueFalse = false;

		WebElement alert_getAlertId = driver.findElement(By.id(locaterValue));

		List<WebElement> alert_getAllTheAlerts = alert_getAlertId.findElements(By.tagName("p"));

		System.out.println(alert_getAllTheAlerts.size());

		ExpectedAlertMessage = ExpectedAlertMessage.replace(" ", "");

		System.out.println(ExpectedAlertMessage);

		String ActualAlertMessage;

		for (int i = 0; i <= alert_getAllTheAlerts.size() - 1; i++)

		{

			ActualAlertMessage = alert_getAllTheAlerts.get(i).getText().replace(" ", "");

			// System.out.println(sActualAlertMessage);

			if (ActualAlertMessage.contains(ExpectedAlertMessage))

			{

				// System.out.println("Displayed");

				TrueFalse = true;

				break;

			}

		}

		return TrueFalse;

	}

	public static boolean getValueOutFromTextFieldAndVerify(WebDriver driver,String locatertype,String locatervalue,String testData) throws Throwable
	{
		boolean TrueFalse =false;
		String actualData="";
		if(locatertype.equalsIgnoreCase("id"))
		{
			actualData=driver.findElement(By.id(locatervalue)).getAttribute("value");
		}
		else if(locatertype.equalsIgnoreCase("name"))
		{
			actualData=driver.findElement(By.name(locatervalue)).getAttribute("value");
		}
		else if(locatertype.equalsIgnoreCase("xpath"))
		{
			actualData=driver.findElement(By.xpath(locatervalue)).getAttribute("value");
		}

		if (actualData.equalsIgnoreCase(testData))
		{
			TrueFalse =true;
		}
		return TrueFalse;
	}





	public static void checkOrUnCheck_CheckBox(WebDriver driver,String locaterType, String locaterValue, String sTestData)

	{

		if(locaterType.equalsIgnoreCase("xpath"))
		{
			WebElement checkBox= driver.findElement(By.xpath(locaterValue));

			if (sTestData.equalsIgnoreCase("UnCheck"))
			{
				if(checkBox.isSelected())
				{
					//checkBox.click();
					driver.findElement(By.xpath(locaterValue)).click();
				}				
			}
			else if (sTestData.equalsIgnoreCase("Check"))
			{
				if(!checkBox.isSelected())
				{
					//checkBox.click();
					int i = 0;
					do {
					driver.findElement(By.xpath(locaterValue)).click();
					i++;
					if (checkBox.isSelected())
						break;
					}
					while (i < 3);
					
				}		   
			}
		}

	}
	
	

	public static void deSelectAllTheCheckBoxes(WebDriver driver) throws Throwable

	{

			List<WebElement> checkBox= driver.findElements(By.className("checkbox"));

			for(int i=checkBox.size()-1;i>=0;i--)
			{
				if(checkBox.get(i).isSelected())
				{  
					Thread.sleep(2000);
					checkBox.get(i).click();
					Thread.sleep(2000);
				}				
			}
	

	}
	
	public static String failScreenShot(WebDriver driver, String Description) throws IOException
	{
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Description = Description.replace("\"", "");
		Description = Description.replace("/", "");
		String screenPath = "./SreenShot/" + Description + "_"
				+ FunctionLibrary.generateDate() + ".jpg";
		FileUtils.copyFile(srcfile, new File(screenPath));
		File file = new File(screenPath);
		String absoultePath = file.getCanonicalPath();
		//logger.log(LogStatus.FAIL, Description + logger.addScreenCapture(absoultePath));
		return absoultePath;
	}
	
	public static boolean isElementNotEnabled(WebDriver driver,String Locator_Type,String Locator_Value )
	{
		boolean trueflase = true;

		if (Locator_Type.equalsIgnoreCase("xpath")) {

			try {

				WebElement element = driver.findElement(By.xpath(Locator_Value));

				if (element.isEnabled()) {

					//System.out.println("Element is Displayed:" + testdata + " ");

					trueflase = false;

				}

			} catch (Exception e) {

				System.out.println("Element is Not Enabled" + e.getMessage());

			}

		}

		else if (Locator_Type.equalsIgnoreCase("id")) {

			try {

				WebElement element = driver.findElement(By.xpath(Locator_Value));

				if (element.isEnabled()) {


					//System.out.println("Text is present:" + testdata + " ");

					trueflase = false;

				}

			} catch (Exception e) {

				System.out.println("Element is Not Enabled" + e.getMessage());

			}

		}

		return trueflase;

	}
	


}

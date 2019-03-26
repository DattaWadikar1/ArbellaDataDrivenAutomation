package DriverFactory;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.reporters.Files;

import com.Arbella.Keywords.Keywords;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunctionLibrary.FunctionLibrary;
import Utilities.ExcelFileUtils;
import Utilities.HtmlUtil;
import Utilities.PropertyFileUtil;

public class DriverScript {

	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	String File_Html_RelativePath;
	
	public static long iSuiteStartTime = 0;//XXXXXXX__________________________
	public static long iSuiteEndTime = 0;//XXXXXXX_____________________________
	public static double iSuiteExecutionTime = 0;//XXXXXXX______________________________
	
	public void startTest() throws Throwable {
		//HTML Instance
		HtmlUtil htmlUtil = new HtmlUtil();  
		ExcelFileUtils Excel = new ExcelFileUtils();
		String sUserName = Excel.getData("MasterTestCases", 7, 3);
		String sPassword = Excel.getData("MasterTestCases", 8, 3);
		String sEnvironment = Excel.getData("MasterTestCases", 6, 3);
		System.out.println("Environment :-" + sEnvironment);
		System.out.println("UserName :-" + sUserName);
		System.out.println("Password :-" + sPassword);
		String ProjectFolderPath = new File(".").getCanonicalPath();//
		System.out.println(ProjectFolderPath);
			
		//HTML Final OutPut File
		htmlUtil.CreateHtmlFile("./TestOutPut/Arbella_OutPutFile.html");
		//HTML To Insert Logos
		htmlUtil.InsertLogos();
		//HTML To Insert EnvironmentAndHeaders
		htmlUtil.InsertEnvironmentAndHeaders("Arbella ",sEnvironment);

		for (int i = 5; i <= Excel.rowCount("MasterTestCases"); i++) {
			if (Excel.getData("MasterTestCases", i, 9) == "") {
				break;
			}
			
	       //			
			iSuiteStartTime = System.currentTimeMillis(); //Newly added//XXXXXXX___________________________________
			//
			
			String ModuleStatus = "";
			String ModuleStatusMasterTestCase = "true";

			if (Excel.getData("MasterTestCases", i, 10).equalsIgnoreCase("Yes")) {
				String TCModule = Excel.getData("MasterTestCases", i, 9);
				System.out.println( TCModule + ": ----------> is started ");

				File_Html_RelativePath = "./Reports/" + TCModule + "_" + FunctionLibrary.generateDateTimeForHtmlFile()
						+ ".html";
				reports = new ExtentReports(File_Html_RelativePath);

				// Generate Extent Reports
				logger = reports.startTest(TCModule);

				int rowCount = Excel.rowCount(TCModule);
				System.out.println(rowCount);
				for (int j = 2; j <= rowCount; j++) {
					String ModuleStatusTrueFalse = "true";

					// String Sno= Excel.getData(TCModule, j, 0);
					String YesNo = Excel.getData(TCModule, j, 1);
					if (YesNo.equalsIgnoreCase("EndTest")) {
						break;
					}
					String Description = Excel.getData(TCModule, j, 3);
					String Keyword = Excel.getData(TCModule, j, 4);
					String Locator_Type = Excel.getData(TCModule, j, 5);
					String Locator_Value = Excel.getData(TCModule, j, 6);
					String Test_Data = Excel.getData(TCModule, j, 7);

					if (YesNo.equalsIgnoreCase("Y")) {
						try {

							if (Keyword.equalsIgnoreCase("ReporterHeading")) {
								logger.log(LogStatus.INFO, Description);
							}

							else if (Keyword.equalsIgnoreCase("startBrowser")) {
								driver = FunctionLibrary.startBrowser(driver, sEnvironment);
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("openApplication")) {
								FunctionLibrary.openApplication(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");
							} else if (Keyword.equalsIgnoreCase("verify_Login")) {
								Keywords.verify_Login(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("waitForElement")) {
								FunctionLibrary.waitForElement(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("waitForElementToBeClickable")) {
								FunctionLibrary.waitForElement(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								logger.log(LogStatus.PASS, Description + "------->Pass");
							} else if (Keyword.equalsIgnoreCase("typeAction")) {
								FunctionLibrary.typeAction(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("typeActionEmptyField")) {
                                FunctionLibrary.typeActionEmptyField(driver, Locator_Type,
                                              PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
                                logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");

							} 
							else if (Keyword.equalsIgnoreCase("clickAction")) {
								FunctionLibrary.clickAction(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("closeApplication")) {
								FunctionLibrary.closeApplication(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("titleValidation")) {
								FunctionLibrary.titleValidation(driver, Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("selectAction")) {
								FunctionLibrary.selectAction(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("selectActionByVisibleText")) {
								FunctionLibrary.selectActionByVisibleText(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");

							}
							else if (Keyword.equalsIgnoreCase("selectByIndex")) {
								FunctionLibrary.selectByIndex(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");

							}
							else if (Keyword.equalsIgnoreCase("captureData")) {
								FunctionLibrary.captureData(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("tableValidation")) {
								FunctionLibrary.tableValidation(driver, Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
							} else if (Keyword.equalsIgnoreCase("handleAlerts")) {
								FunctionLibrary.handleAlerts(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("MouseOverOnElement")) {
								FunctionLibrary.MouseOverOnElement(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword
									.equalsIgnoreCase("ClickOn_NB_PersonalLines_Massachusetts_PersonalAuto")) {
								Keywords.mouseOverOnPersonalLine(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("ClickOn_NB_PersonalLines_Massachusetts_Homeowners")) {
								Keywords.ClickOn_NB_PersonalLines_Massachusetts_Homeowners(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("deleteAction")) {
								Keywords.deleteAction(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("navigateBack")) {
								Keywords.navigateBack(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("PageElementValidation")) {
								FunctionLibrary.PageElementValidation(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "------->Pass");

							} else if (Keyword.equalsIgnoreCase("implicitWait")) {
								FunctionLibrary.implicitWait(Test_Data);

							} else if (Keyword.equalsIgnoreCase("LoginToApplication")) {
								Keywords.LoginToApplication(driver, sUserName, sPassword);
								logger.log(LogStatus.PASS,
										Description + "\"" + sUserName + "," + sPassword + "\"" + "------->Pass");
							} 
							 else if (Keyword.equalsIgnoreCase("LoginToApplicationTester1")) {
									Keywords.LoginToApplicationTester1(driver);
									logger.log(LogStatus.PASS,
											Description + "\"" + sUserName + "," + sPassword + "\"" + "------->Pass");
								}
							 else if (Keyword.equalsIgnoreCase("LoginToApplicationTester2")) {
									Keywords.LoginToApplicationTester2(driver);
									logger.log(LogStatus.PASS,
											Description + "\"" + sUserName + "," + sPassword + "\"" + "------->Pass");
								}else if (Keyword.equalsIgnoreCase("TakeScreenShot")) {
								File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
								String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"
										+ FunctionLibrary.generateDate() + ".jpg";
								FileUtils.copyFile(srcfile, new File(screenPath));
								File file = new File(screenPath);
								String absoultePath = file.getCanonicalPath();
								Thread.sleep(2000);
								logger.log(LogStatus.PASS,
										Description + "------->Pass" + logger.addScreenCapture(absoultePath));
							}
							else if (Keyword.equalsIgnoreCase("TakeScreenShotAlert")) {		
								
								Robot robot = new Robot();
								// create rectangle for full screenshot
								Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
								// capture screen of the desktop
								BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
								
								String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"
										+ FunctionLibrary.generateDate() + ".jpg";
								ImageIO.write(screenFullImage, "png", new File(screenPath));
								
								//FileUtils.copyFile(screenFullImage, new File(screenPath));
								File file = new File(screenPath);
								String absoultePath = file.getCanonicalPath();
								Thread.sleep(2000);
								logger.log(LogStatus.PASS,
										Description + "------->Pass" + logger.addScreenCapture(absoultePath));
							} 

							else if (Keyword.equalsIgnoreCase("TakeScreenShotAtTop")) {

								JavascriptExecutor jse = (JavascriptExecutor) driver;

								jse.executeScript("window.scrollBy(0,-3000)");

								File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

								String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"

										+ FunctionLibrary.generateDate() + ".jpg";

								FileUtils.copyFile(srcfile, new File(screenPath));

								File file = new File(screenPath);

								String absoultePath = file.getCanonicalPath();

								Thread.sleep(2000);

								logger.log(LogStatus.PASS,

										Description + "------->Pass" + logger.addScreenCapture(absoultePath));
							}
							else if (Keyword.equalsIgnoreCase("TakeScreenShotAtMiddle")) {

								JavascriptExecutor jse = (JavascriptExecutor) driver;

								jse.executeScript("window.scrollBy(300,300)");

								File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

								String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"

										+ FunctionLibrary.generateDate() + ".jpg";

								FileUtils.copyFile(srcfile, new File(screenPath));

								File file = new File(screenPath);

								String absoultePath = file.getCanonicalPath();

								Thread.sleep(2000);

								logger.log(LogStatus.PASS,

										Description + "------->Pass" + logger.addScreenCapture(absoultePath));
							} 
							
                              else if (Keyword.equalsIgnoreCase("TakeScreenShotAtBottom")) {

  								JavascriptExecutor jse = (JavascriptExecutor) driver;

  								jse.executeScript("window.scrollBy(0,3000)");

  								File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

  								String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"

  										+ FunctionLibrary.generateDate() + ".jpg";

  								FileUtils.copyFile(srcfile, new File(screenPath));

  								File file = new File(screenPath);

  								String absoultePath = file.getCanonicalPath();

  								Thread.sleep(2000);

  								logger.log(LogStatus.PASS,

  										Description + "------->Pass" + logger.addScreenCapture(absoultePath));
  							}

							else if (Keyword.equalsIgnoreCase("ClickText")) {
								Keywords.ClickText(driver, Locator_Type, Test_Data);
								logger.log(LogStatus.PASS,
										Description + "\"" + Test_Data + "\"" + "," + "------->Pass");
							} else if (Keyword.equalsIgnoreCase("verifyUnderWriterRule")) {
								boolean TrueFalse = Keywords.verifyUnderWriterRule(driver, Test_Data);
								if (TrueFalse)
								{
									logger.log(LogStatus.PASS,Description + "\"" + Test_Data + "\"" + "," + "------->Pass");
								}
								else
								{
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL,Description + "\"" + Test_Data + "\"" + "," + "------->Fail"+ logger.addScreenCapture(absoultePath));									
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}								
					
							}else if (Keyword.equalsIgnoreCase("enterValueByJavaScript")) {
								Keywords.enterValueByJavaScript(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS,
										Description + "\"" + Test_Data + "\"" + "," + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("sEnterCityState")) {
								Keywords.sEnterCityState(driver);
								logger.log(LogStatus.PASS, Description +  "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("selectRadioBtnByName")) {
								if (Locator_Type.equalsIgnoreCase("NA")) {
									Keywords.selectRadioBtnByName(driver,
											PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),
											Test_Data);
								} 
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}


							else if (Keyword.equalsIgnoreCase("alertVerificationMsg")) {

								boolean trueFalse = Keywords.alertVerificationMsg(driver, Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							} else if (Keyword.equalsIgnoreCase("selectRadioBtnByName")) {
								if (Locator_Type.equalsIgnoreCase("NA")) {
									Keywords.selectRadioBtnByName(driver,
											PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),
											Test_Data);
								} 
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}else if (Keyword.equalsIgnoreCase("verifyRadioButtonIsSelected")) {
								
								boolean trueFalse = Keywords.verifyRadioButtonIsSelected(driver, PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),
										Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}	
							}else if (Keyword.equalsIgnoreCase("verifyDefaultValueForSelectDropDown")) {
								
								boolean trueFalse = Keywords.verifyDefaultValueForSelectDropDown(driver, Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),
										Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}	
							}

							else if (Keyword.equalsIgnoreCase("selectRadioBtnByNameInWebTable")) {
								if (Locator_Type.equalsIgnoreCase("NA")) {
									Keywords.selectRadioBtnByNameInWebTable(driver,
											PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),
											Test_Data);
								} 
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("selectEffectiveDate")) {

								Keywords.selectEffectiveDate(driver);
								logger.log(LogStatus.PASS, Description + "------->Pass");
							}
						
							else if (Keyword.equalsIgnoreCase("selectFuturePreviousDate")) {

								String actualTestData = Keywords.selectFuturePreviousDate(driver, Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + actualTestData + "\"" + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("selectGenericFuturePreviousDate")) {
								
								String actualTestData = Keywords.selectGenericFuturePreviousDate(driver, Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + actualTestData + "\"" + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("selectGenericFuturePreviousMonth")) {

								String actualTestData = Keywords.selectGenericFuturePreviousMonth(driver,Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + actualTestData + "\"" + "------->Pass");
							}							
							else if (Keyword.equalsIgnoreCase("selectGenericFuturePreviousYear")) {

								String actualTestData = Keywords.selectGenericFuturePreviousYear(driver,Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + actualTestData + "\"" + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("selectGenericFuturePreviousMonthOnly")) {

								String actualTestData = Keywords.selectGenericFuturePreviousMonthOnly(driver,Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + actualTestData + "\"" + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("selectGenericFuturePreviousYearOnly")) {

								String actualTestData = Keywords.selectGenericFuturePreviousYearOnly(driver,Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + actualTestData + "\"" + "------->Pass");
							}							
							
							else if (Keyword.equalsIgnoreCase("selectDateOfBirth")) {

								Keywords.selectDateOfBirth(driver, Test_Data);
								logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
							}

							else if (Keyword.equalsIgnoreCase("isPresent")) {

								boolean trueFalse = Keywords.isPresent(driver);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							}
							else if (Keyword.equalsIgnoreCase("verifyFormLabel")) {

								boolean trueFalse = FunctionLibrary.verifyFormLabel(driver,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							}
							else if (Keyword.equalsIgnoreCase("verifyGenericLabel")) {

								boolean trueFalse = FunctionLibrary.verifyGenericLabel(driver,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							}
							else if (Keyword.equalsIgnoreCase("verifyGenericLabelNotDisplayed")) {

								boolean trueFalse = FunctionLibrary.verifyGenericLabelNotDisplayed(driver,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							}
							else if (Keyword.equalsIgnoreCase("verifyUnderWriterRuleGeneric")) {
								boolean TrueFalse = Keywords.verifyUnderWriterRuleGeneric(driver,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								if (TrueFalse) {
									logger.log(LogStatus.PASS,
											Description + "\"" + Test_Data + "\"" + "," + "------->Pass");
								} else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL,
											Description + "\"" + Test_Data + "\"" + "," + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}

							}

							else if (Keyword.equalsIgnoreCase("isElementDisplayed"))

							{

								boolean trueFalse = Keywords.isElementDisplayed(driver, Locator_Type,

										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							
							else if (Keyword.equalsIgnoreCase("isElementDisabled"))

							{

								boolean trueFalse = Keywords.isElementDisabled(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							else if (Keyword.equalsIgnoreCase("isElementEnabled"))

							{

								boolean trueFalse = Keywords.isElementEnabled(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							else if (Keyword.equalsIgnoreCase("verifyFormLabelIsNotDisplayed")) {

								boolean trueFalse = FunctionLibrary.verifyFormLabelIsNotDisplayed(driver,Locator_Type,Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							}
							else if (Keyword.equalsIgnoreCase("ElementisNotPresent")) {

								boolean trueFalse = Keywords.ElementisNotPresent(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value), Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
							}
							else if (Keyword.equalsIgnoreCase("webElementisDisplayedOrNot")) {

								boolean trueFalse = Keywords.webElementisDisplayedOrNot(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								if (trueFalse)
									logger.log(LogStatus.PASS, Description +  "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
								
							}
							else if (Keyword.equalsIgnoreCase("webElementisNotDisplayedorNot")) {

								boolean trueFalse = Keywords.webElementisNotDisplayedorNot(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								if (trueFalse)
									logger.log(LogStatus.PASS, Description +  "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
							}
							else if (Keyword.equalsIgnoreCase("webElementisNotDisplayed")) {

								boolean trueFalse = Keywords.webElementisNotDisplayed(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								if (trueFalse)
									logger.log(LogStatus.PASS, Description +  "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
							}

							else if (Keyword.equalsIgnoreCase("verifyValueIsDisplayedInDropDown")) {

								boolean trueFalse = Keywords.verifyValueIsDisplayedInDropDown(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + Test_Data +  "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + Test_Data + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
							}
							else if (Keyword.equalsIgnoreCase("getValueOutFromTextFieldAndVerify")) {

								boolean trueFalse = Keywords.getValueOutFromTextFieldAndVerify(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description +  "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
							}
							else if (Keyword.equalsIgnoreCase("LoginToMIAPApplication")) {
								Keywords.LoginToMIAPApplication(driver);
								logger.log(LogStatus.PASS,
										Description + "\"" + sUserName + "," + sPassword + "\"" + "------->Pass");

							}
							else if (Keyword.equalsIgnoreCase("webElementisReadOnly")) {

								boolean trueFalse = Keywords.webElementisReadOnly(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));
								if (trueFalse)
									logger.log(LogStatus.PASS, Description +  "------->Pass");
								else {
									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								      }
							}
							else if (Keyword.equalsIgnoreCase("checkOrUnCheck_CheckBox")) {

								Keywords.checkOrUnCheck_CheckBox(driver, Locator_Type,
									PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);								
									logger.log(LogStatus.PASS, Description + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("deSelectAllTheCheckBoxes")) {

								Keywords.deSelectAllTheCheckBoxes(driver);								
									logger.log(LogStatus.PASS, Description + "------->Pass");
							}
							else if (Keyword.equalsIgnoreCase("isElementNotEnabled"))

							{

								boolean trueFalse = Keywords.isElementNotEnabled(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value));

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {

									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							else if (Keyword.equalsIgnoreCase("getHo3CovCPersonalProperty"))

							{

								boolean trueFalse = FunctionLibrary.getHo3CovCPersonalProperty(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {

									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							
							else if (Keyword.equalsIgnoreCase("getHo3CovDPersonalPropertyFromCovA"))

							{

								boolean trueFalse = FunctionLibrary.getHo3CovDPersonalPropertyFromCovA(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {

									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							else if (Keyword.equalsIgnoreCase("getHo4CovDLossofUseValue"))

							{

								boolean trueFalse = FunctionLibrary.getHo4CovDLossofUseValue(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {

									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							else if (Keyword.equalsIgnoreCase("getHo6CovDLossofUseValue"))

							{

								boolean trueFalse = FunctionLibrary.getHo6CovDLossofUseValue(driver, Locator_Type,
										PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);

								if (trueFalse)

									logger.log(LogStatus.PASS, Description + "------->Pass");

								else {

									String absoultePath = Keywords.failScreenShot(driver, Description);
									logger.log(LogStatus.FAIL, Description + "------->Fail"+ logger.addScreenCapture(absoultePath));

									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";

								}
							}
							else if (Keyword.equalsIgnoreCase("verifyAllValuesInDropDown")) {

								boolean trueFalse = Keywords.verifyAllValuesInDropDown(driver,Locator_Type,PropertyFileUtil.getValueForKeyFromObjectRepository(Locator_Value),Test_Data);
								if (trueFalse)
									logger.log(LogStatus.PASS, Description + "\"" + Test_Data + "\"" + "------->Pass");
								else {
									logger.log(LogStatus.FAIL, Description + "\"" + Test_Data + "\"" + "------->Fail");
									ModuleStatusTrueFalse = "false";
									ModuleStatusMasterTestCase = "false";
								}
							}
							
							else
							{
								Excel.setData(TCModule, j, 8, "Function is Not There");
							}
							// Reporting Pass or Fail
							if (Keyword.equalsIgnoreCase("ReporterHeading")) 
							{
							}
							else if (ModuleStatusTrueFalse.equalsIgnoreCase("false"))
							{
								Excel.setData(TCModule, j, 8, "Fail");
							}
							else 
							{
								Excel.setData(TCModule, j, 8, "Pass");

								ModuleStatus = "true";
							}
						}

						catch (Exception e) {
							e.printStackTrace();
							Excel.setData(TCModule, j, 8, "Fail");
							ModuleStatus = "false";

							File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"
									+ FunctionLibrary.generateDate() + ".jpg";
							FileUtils.copyFile(srcfile, new File(screenPath));
							File file = new File(screenPath);
							String absoultePath = file.getCanonicalPath();
							logger.log(LogStatus.FAIL, Description + logger.addScreenCapture(absoultePath));
							// FunctionLibrary.closeApplication(driver);
							break;
						} catch (AssertionError a) {
							a.printStackTrace();
							Excel.setData(TCModule, j, 8, "Fail");
							ModuleStatus = "false";

							File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							String screenPath = "./SreenShot/" + Description.replace("\"", "") + "_"
									+ FunctionLibrary.generateDate() + ".jpg";
							FileUtils.copyFile(srcfile, new File(screenPath));
							File file = new File(screenPath);
							String absoultePath = file.getCanonicalPath();
							logger.log(LogStatus.FAIL, Description + logger.addScreenCapture(absoultePath));
							// FunctionLibrary.closeApplication(driver);
							break;
						}
					} else {
						Excel.setData(TCModule, j, 8, "NA");
					}

				}
				
		/*		reports.endTest(logger);
				reports.flush();*/
				Thread.sleep(5000);

				if (ModuleStatus.equalsIgnoreCase("true") && ModuleStatusMasterTestCase.equalsIgnoreCase("true")) {
					File file = new File(File_Html_RelativePath);
					String absoultePath = file.getCanonicalPath();
					System.out.println(absoultePath);
					Excel.setHyperLink("MasterTestCases", i, 11, "Pass", File_Html_RelativePath);
					htmlUtil.WritePass(Excel.getData("MasterTestCases", i, 6),Excel.getData("MasterTestCases", i, 7),Excel.getData("MasterTestCases", i, 8),Excel.getData("MasterTestCases", i, 9),Excel.getData("MasterTestCases", i, 10),absoultePath);   //------------------------------
				} else
				{
					
					File file = new File(File_Html_RelativePath);
					String absoultePath = file.getCanonicalPath();
					System.out.println(absoultePath);
					Excel.setHyperLink("MasterTestCases", i, 11, "Fail", File_Html_RelativePath);
					htmlUtil.WriteFail(Excel.getData("MasterTestCases", i, 6),Excel.getData("MasterTestCases", i, 7),Excel.getData("MasterTestCases", i, 8),Excel.getData("MasterTestCases", i, 9),Excel.getData("MasterTestCases", i, 10),absoultePath);   //------------------------------
				}

				reports.endTest(logger);
				reports.flush();
				//htmlUtil.CloseHtmlReport();
				htmlUtil.FlushHtmlReport();

			} else {
				Excel.setData("MasterTestCases", i, 11, "NotExecuted");
				htmlUtil.WriteNotExecuted(Excel.getData("MasterTestCases", i, 6),Excel.getData("MasterTestCases", i, 7),Excel.getData("MasterTestCases", i, 8),Excel.getData("MasterTestCases", i, 9),Excel.getData("MasterTestCases", i, 10));   //------------------------------
			}

		}
		htmlUtil.CloseHtmlReport();
		htmlUtil.FlushHtmlReport();
		iSuiteEndTime = System.currentTimeMillis(); //Newly added
		System.out.println("TotalTime in milliseconds: " +  (iSuiteEndTime-iSuiteStartTime)  );
		iSuiteExecutionTime = (iSuiteEndTime-iSuiteStartTime)/60000.0;//Newly added
		System.out.println("TotalTime in seconds: " + iSuiteExecutionTime  );//Newly added
		
		System.setProperty("webdriver.chrome.driver", "./CommonJarFile/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ProjectFolderPath+"/TestOutPut/Arbella_OutPutFile.html");
		
	}
	

}

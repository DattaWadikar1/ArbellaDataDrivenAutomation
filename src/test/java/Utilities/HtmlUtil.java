package Utilities;

import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
//import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.time.LocalTime;
import java.util.Date;
//import java.util.Random;

//import org.apache.poi.ss.formula.functions.Now;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.testng.annotations.Test;

//import CommonFunctionLibrary.FunctionLibrary;

public class HtmlUtil {

	 String File_Html_RelativePath;
	 File myFile;
	 FileOutputStream fis;
		//creating constructor for load excel file
		
	public  void CreateHtmlFile(String File_Html_RelativePath) throws Throwable{
						
			
			myFile=new File(File_Html_RelativePath);
			myFile.createNewFile();
			fis = new FileOutputStream(File_Html_RelativePath);
			
			String s="<html>\r\n" + 
					"\r\n" + 
					"<head> <meta charset=\"UTF-8\">\r\n" + 
					"\r\n" + 
					"<title>RSPAuditUserLogin-0- Execution Results</title> \r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"Screenshots/css/datatable/jquery.dataTables.css\">\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"Screenshots/css/jquery-ui.css\">\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"Screenshots/css/datatable/dataTables.jqueryui.css\">\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"Screenshots/css/custom.css\">\r\n" + 
					"\r\n" + 
					"<script type=\"text/javascript\" language=\"javascript\" src=\"Screenshots/js/jquery-1.11.1.min.js\"></script>\r\n" + 
					"<script type=\"text/javascript\" language=\"javascript\" src=\"Screenshots/js/datatable/jquery.dataTables.min.js\"></script>\r\n" + 
					"<script type=\"text/javascript\" language=\"javascript\" src=\"Screenshots/js/datatable/dataTables.jqueryui.js\"></script>\r\n" + 
					"<script type=\"text/javascript\" language=\"javascript\" src=\"Screenshots/js/jquery-ui.min.js\"></script>\r\n" + 
					"<script type=\"text/javascript\" language=\"javascript\" src=\"Screenshots/js/custom.js\"></script>\r\n" + 
					"\r\n" + 
					"<style type=\"text/css\"> body { background-color: #FFFFFF; font-family: Verdana, Geneva, sans-serif; text-align: center; } small { font-size: 0.7em; } table { box-shadow: 9px 9px 10px 4px #BDBDBD;border: 0px solid #4D7C7B; border-collapse: collapse; border-spacing: 0px; width: 1000px; margin-left: auto; margin-right: auto; } tr.heading { background-color: #041944; color: #FFFFFF; font-size: 0.7em; font-weight: bold; background:-o-linear-gradient(bottom, #999999 5%, #000000 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #999999), color-stop(1, #000000) );background:-moz-linear-gradient( center top, #999999 5%, #000000 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#999999, endColorstr=#000000);	background: -o-linear-gradient(top,#999999,000000);} tr.subheading { background-color: #FFFFFF; color: #000000; font-weight: bold; font-size: 0.7em; text-align: justify; } tr.section { background-color: #A4A4A4; color: #333300; cursor: pointer; font-weight: bold; font-size: 0.7em; text-align: justify; background:-o-linear-gradient(bottom, #56aaff 5%, #e5e5e5 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #56aaff), color-stop(1, #e5e5e5) );background:-moz-linear-gradient( center top, #56aaff 5%, #e5e5e5 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#56aaff, endColorstr=#e5e5e5);	background: -o-linear-gradient(top,#56aaff,e5e5e5);} tr.subsection { cursor: pointer; } tr.content { background-color: #FFFFFF; color: #000000; font-size: 0.7em; display: table-row; } tr.content2 { background-color: #FFFFFF; border: 1px solid #4D7C7B;color: #000000; font-size: 0.75em; display: table-row; } td, th { padding: 5px; border: 1px solid #4D7C7B; text-align: inherit/; } th.Logos { padding: 5px; border: 0px solid #4D7C7B; text-align: inherit /;} td.justified { text-align: justify; } td.pass { font-weight: bold; color: green; } td.fail { font-weight: bold; color: red; } td.done, td.screenshot { font-weight: bold; color: black; } td.debug { font-weight: bold;color: blue; } td.warning { font-weight: bold; color: orange; } \r\n" + 
					"</style>\r\n" + 
					"<script> function toggleMenu(objID) { if (!document.getElementById) return; var ob = document.getElementById(objID).style; if(ob.display === 'none') { try { ob.display='table-row-group'; } catch(ex) { ob.display='block'; } } else { ob.display='none'; } } function toggleSubMenu(objId) { for(i=1; i<10000; i++) { var ob = document.getElementById(objId.concat(i)); if(ob === null) { break; } if(ob.style.display === 'none') { try { ob.style.display='table-row'; } catch(ex) { ob.style.display='block'; } } else { ob.style.display='none'; } } }\r\n" + 
					"</script>\r\n" + 
					"</head>";  
			byte b[]=s.getBytes();//converting string into byte array  
			fis.write (b);
			//InsertLogos();
	}
	
	public void InsertLogos() throws Throwable
	{		
		String ProjectFolderPath = new File(".").getCanonicalPath();
		
			
			String s="<table id=\"Logos\" class=\"testData\">\r\n" + 
					"<colgroup>\r\n" + 
					"<col style=\"width: 25%\">\r\n" + 
					"<col style=\"width: 25%\">\r\n" + 
					"<col style=\"width: 25%\">\r\n" + 
					"<col style=\"width: 25%\">\r\n" + 
					"</colgroup>\r\n" + 
					"\r\n" + 
					"<thead> \r\n" + 
					"<tr class=\"content\">\r\n" + 
					"<th class=\"Logos\" colspan=\"2\">\r\n" +
					//" <img align=\"right\" src=\"C:\\Selenium\\Arbella_TrailAndRun\\logos\\logo.png\">\r\n" +
					"<img align=\"left\" src="+"\""+ProjectFolderPath +"\\logos\\logo.png\">\r\n" + 
					"</th>\r\n" + 
					"<th class=\"Logos\" colspan=\"2\">\r\n" +
					"<img align=\"right\" src="+"\"" +ProjectFolderPath +"\\logos\\cigniti_logo.png\">\r\n" +
					//" <img align=\"right\" src=\"C:\\Selenium\\Arbella_TrailAndRun\\logos\\cigniti_logo.png\">\r\n" +
					"</th> \r\n" + 
					"</tr>\r\n" + 
					" </thead>\r\n" + 
					" </table>";
            
            byte b[]=s.getBytes();//converting string into byte array			
			fis.write (b);
	}	
			
	public void InsertEnvironmentAndHeaders(String sTestCaseName,String sBrowserName) throws Throwable
	{
	
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");  
		    Date date = new Date();  
		//    System.out.println(formatter.format(date));  
		    String TimeStamp =formatter.format(date);
			
			String s="<table id=\"header\" class=\"testData\">\r\n" + 
					" <colgroup>  \r\n" + 
					"      <col style=\"width: 20%\">\r\n" + 
					"      <col style=\"width: 20%\">\r\n" + 
					"      <col style=\"width: 20%\"> \r\n" + 
					"      <col style=\"width: 20%\">\r\n" + 
					"      </colgroup>  \r\n" + 
					"\r\n" + 
					"<thead> \r\n" + 
					"   <tr class=\"heading\"> \r\n" + 
					"     <th colspan=\"4\" style=\"font-family:Copperplate Gothic Bold; font-size:1.4em;\"> **"+  sTestCaseName  +"   - Execution Results **</th> \r\n" + 
					"   </tr> \r\n" + 
					"   <tr class=\"subheading\"> \r\n" + 
					"     <th>&nbsp;Date&nbsp;&amp;&nbsp;Time&nbsp;:&nbsp;</th> \r\n" + 
					"     <th>"+ TimeStamp +"</th>\r\n" + 
					"     <th>&nbsp;Iteration&nbsp;Mode&nbsp;:&nbsp;</th> \r\n" + 
					"     <th>RunAllIterations</th> \r\n" + 
					"   </tr> \r\n" + 
					"\r\n" + 
					"   <tr class=\"subheading\"> \r\n" + 
					"      <th>Browser&nbsp;:</th> \r\n" + 
					"      <th>"+ sBrowserName +"</th> \r\n" + 
					"     <th>&nbsp;Executed&nbsp;on&nbsp;:&nbsp;</th> \r\n" + 
					"     <th>"+ InetAddress.getLocalHost().getHostName() +"</th> \r\n" + 					
					"   </tr> \r\n" + 
					"\r\n" + 
					
					
					"</thead><div class=\"mainTableDiv4\">\r\n" + 
					"\r\n" + 
					"  <div id=\"main_wrapper\" class=\"dataTables_wrapper dt-jqueryui no-footer\">\r\n" + 
					"  <div class=\"fg-toolbar ui-toolbar ui-widget-header ui-helper-clearfix ui-corner-tl ui-corner-tr\">\r\n" + 
					"</div><p>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<table id=\"main\" class=\"testData dataTable no-footer\" role=\"grid\" aria-describedby=\"main_info\">\r\n" + 
					"      <colgroup> \r\n" + 
					"      <col style=\"width: 10%\">\r\n" + 
					"      <col style=\"width: 15%\"> \r\n" + 
					"      <col style=\"width: 15%\"> \r\n" + 
					"      <col style=\"width: 20%\">\r\n" + 
					"      <col style=\"width: 10%\">\r\n" + 
					"      <col style=\"width: 10%\">\r\n" + 
					"      <col style=\"width: 20%\">\r\n" + 
					 
					"      </colgroup> \r\n" + 
					"\r\n" + 
					"<thead> \r\n" + 
					"\r\n" + 
					" <tr class=\"heading\" role=\"row\">\r\n" + 
					"   <th class=\"sorting ui-state-default sorting_asc\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"S.NO: activate to sort column descending\" style=\"width: 42px;\"><div class=\"DataTables_sort_wrapper\">S.NO<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-triangle-1-n\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" + 
					"   <th class=\"sorting ui-state-default\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-label=\"Details: activate to sort column ascending\" style=\"width: 490px;\"><div class=\"DataTables_sort_wrapper\">Test Case ID<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" + 
					"   <th class=\"sorting ui-state-default\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-label=\"Status: activate to sort column ascending\" style=\"width: 20px;\"><div class=\"DataTables_sort_wrapper\">Module<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" + 
					"   <th class=\"sorting ui-state-default\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-label=\"Time: activate to sort column ascending\" style=\"width: 10px;\"><div class=\"DataTables_sort_wrapper\">Test Case Name<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" + 
					"   <th class=\"sorting ui-state-default\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-label=\"Time: activate to sort column ascending\" style=\"width: 10px;\"><div class=\"DataTables_sort_wrapper\">Execute<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" +
					"   <th class=\"sorting ui-state-default\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-label=\"Time: activate to sort column ascending\" style=\"width: 10px;\"><div class=\"DataTables_sort_wrapper\">Result<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" +
					"   <th class=\"sorting ui-state-default\" tabindex=\"0\" aria-controls=\"main\" rowspan=\"1\" colspan=\"1\" aria-label=\"Time: activate to sort column ascending\" style=\"width: 10px;\"><div class=\"DataTables_sort_wrapper\">Time<span class=\"DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s\"></span></div>\r\n" + 
					"   </th>\r\n" + 
					"\r\n" +
					"</tr> \r\n" + 
					"\r\n" + 
					"</thead> \r\n";
            
            byte b[]=s.getBytes();//converting string into byte array			
			fis.write (b);

	}			
			
	
	public void WritePass(String Sno,String Test_Case_ID,String Module,String Test_Case_Name,String Execute,String File_Html_RelativePath) throws Throwable
	{
		String ProjectFolderPath = new File(".").getCanonicalPath();

		
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");  
		    Date date = new Date();  
		    //System.out.println(formatter.format(date));  
		    String TimeStamp =formatter.format(date);
		
		String s="<tbody>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<tr class=\"content2\">\r\n" + 
					"  <td class=\"sorting_1\">   "+ Sno +"  </td> \r\n" + 
					"  <td class=\"justified\">"+ Test_Case_ID +"</td> \r\n" +
					"  <td class=\"justified\">"+ Module +"</td> \r\n" +
					"  <td class=\"justified\">"+ Test_Case_Name +"</td> \r\n" +
					"  <td class=\"justified\">"+ Execute +"</td> \r\n" +
					//"  <td class=\"Pass\" align=\"center\"><a href="+ File_Html_RelativePath +" target=\"_blank\"><img src=\"C:\\Selenium\\Arbella_TrailAndRun\\logos\\passed.ico\" width=\"18\" height=\"18\"></td>\r\n" +
					"  <td class=\"Pass\" align=\"center\"><a href="+ File_Html_RelativePath +" target=\"_blank\"><img src="+"\""+ ProjectFolderPath +"\\logos\\passed.ico\" width=\"18\" height=\"18\"></td>\r\n" +
					                                       //<a href="https://www.w3schools.com/" target="_blank">Visit W3Schools!</a>
					"  <td><small>" + TimeStamp + "</small></td>\r\n" + 
					" </tr>";
            
            byte b[]=s.getBytes();//converting string into byte array			
			fis.write (b);
			
	}	


	public void WriteFail(String Sno,String Test_Case_ID,String Module,String Test_Case_Name,String Execute,String File_Html_RelativePath) throws Throwable
	{
		String ProjectFolderPath = new File(".").getCanonicalPath();
		
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");  
		    Date date = new Date();  
		  //  System.out.println(formatter.format(date));  
		    String TimeStamp =formatter.format(date);
		    
		
		String s="<tbody>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<tr class=\"content2\">\r\n" + 
				"  <td class=\"sorting_1\">   "+ Sno +"  </td> \r\n" + 
				"  <td class=\"justified\">"+ Test_Case_ID +"</td> \r\n" +
				"  <td class=\"justified\">"+ Module +"</td> \r\n" +
				"  <td class=\"justified\">"+ Test_Case_Name +"</td> \r\n" +
				"  <td class=\"justified\">"+ Execute +"</td> \r\n" +
				//"  <td class=\"Pass\" align=\"center\"><a href=\"https://www.w3schools.com/\" target=\"_blank\"><img src=\"C:\\Selenium\\Arbella_TrailAndRun\\logos\\failed.ico\" width=\"18\" height=\"18\"></td>\r\n" +
				"  <td class=\"Pass\" align=\"center\"><a href="+ File_Html_RelativePath +" target=\"_blank\"><img src="+"\""+ ProjectFolderPath +"\\logos\\failed.ico\" width=\"18\" height=\"18\"></td>\r\n" +
				"  <td><small>" + TimeStamp + "</small></td>\r\n" +  
				" </tr>";
        
        byte b[]=s.getBytes();//converting string into byte array			
		fis.write (b);

	}	
	
	public void WriteNotExecuted(String Sno,String Test_Case_ID,String Module,String Test_Case_Name,String Execute) throws Throwable
	{
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");  
		    Date date = new Date();
		    String TimeStamp =formatter.format(date);
          // System.out.println(TimeStamp);
		
		String s="<tbody>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<tr class=\"content2\">\r\n" + 
				"  <td class=\"sorting_1\">   "+ Sno +"  </td> \r\n" + 
				"  <td class=\"justified\">"+ Test_Case_ID +"</td> \r\n" +
				"  <td class=\"justified\">"+ Module +"</td> \r\n" +
				"  <td class=\"justified\">"+ Test_Case_Name +"</td> \r\n" +
				"  <td class=\"justified\">"+ Execute +"</td> \r\n" +
				"  <td class=\"justified\"> NotExecuted </td> \r\n" +					
				"  <td><small>" + TimeStamp + "</small></td>\r\n" +  
				" </tr>";
        
        byte b[]=s.getBytes();//converting string into byte array			
		fis.write (b);

	}
	
	public void TakeScreenShot(int Sno,String Stepname,String SnapShotPath) throws Throwable
	{
		String ProjectFolderPath = new File(".").getCanonicalPath();

		String s="<tr class=\"content2\">\r\n" + 
				"  <td class=\"sorting_1\">   "+ Sno +"  </td> \r\n" + 
				"  <td class=\"justified\">"+ Stepname +"</td> \r\n" + 
				//" <td class=\"Fail\" align=\"center\"><a href="+ SnapShotPath + " alt=\"Screenshot\" width=\"15\" height=\"15\" style=\"text-decoration:none;\" target=\"_blank\" ><img src=\"C:\\Selenium\\Arbella_TrailAndRun\\logos\\Camara2.png\" height=\"18\"></a></td>\r\n" +			
				" <td class=\"Fail\" align=\"center\"><a href="+ SnapShotPath + " alt=\"Screenshot\" width=\"15\" height=\"15\" style=\"text-decoration:none;\" target=\"_blank\" ><img src="+"\""+ ProjectFolderPath +"logos\\Camara2.png\" height=\"18\"></a></td>\r\n" +
				" <td><small>16:15:37 PM</small></td> \r\n" + "</tr>";
		
           
            byte b[]=s.getBytes();//converting string into byte array         
			fis.write (b);
			//CloseHtmlReport();
	}
	
	
	public void CloseHtmlReport() throws Throwable
	{

		String s="</tbody>\r\n"+"</table></html>";   
            byte b[]=s.getBytes();//converting string into byte array         
			fis.write (b);			
	}
	
	public void FlushHtmlReport() throws Throwable
	{
			fis.flush();
	}
			

	
	
}

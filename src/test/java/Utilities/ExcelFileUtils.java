package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;

public class ExcelFileUtils {
	Workbook wb;
	//creating constructor for load excel file
	public ExcelFileUtils() throws Throwable{
		FileInputStream fis=new FileInputStream("./TestInputs/InputFileData.xlsm");		
		wb=WorkbookFactory.create(fis);		
		
	}//close constructor
	
	//count row
	public int rowCount(String Sheetname)
	{
		
		return wb.getSheet(Sheetname).getLastRowNum();
	
	}
	//column count
	public int colCount(String sheetname,int rowno)
	{
		return wb.getSheet(sheetname).getRow(rowno).getLastCellNum();
		
	}
	//get data
	public String getData(String sheetname,int rowno,int colno)
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(rowno).getCell(colno).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata=(int)(wb.getSheet(sheetname).getRow(rowno).getCell(colno).getNumericCellValue());
			data=String.valueOf(celldata);
			
		}
		else
		{
			data=wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
		}
		return data;
		
	}
	public void setData(String sheetname,int rowno,int colno,String str) throws Throwable
	{
		Sheet sh=wb.getSheet(sheetname);
		Row rowNum=sh.getRow(rowno);
		Cell cell=rowNum.createCell(colno);
		cell.setCellValue(str);
		if(str.equalsIgnoreCase("pass"))
		{
			//create cell data
			CellStyle style=wb.createCellStyle();
			//create font
			Font font=wb.createFont();
			//apply color to text
			font.setColor(IndexedColors.GREEN.getIndex());
		   //apply bold to the text
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			//set font
			style.setFont(font);
			//set cell style
			rowNum.getCell(colno).setCellStyle(style);
			
		}
		else
			if(str.equalsIgnoreCase("Fail"))
			{
				//create cell data
				CellStyle style=wb.createCellStyle();
				//create font
				Font font=wb.createFont();
				//apply color to text
				font.setColor(IndexedColors.RED.getIndex());
			   //apply bold to the text
				font.setBoldweight(font.BOLDWEIGHT_BOLD);

				//set font
				style.setFont(font);
				//set cell style
				rowNum.getCell(colno).setCellStyle(style);
				
			}
			else
				if(str.equalsIgnoreCase("NotExcuted"))
				{
					//create cell data
					CellStyle style=wb.createCellStyle();
					//create font
					Font font=wb.createFont();
					//apply color to text
					font.setColor(IndexedColors.BLUE.getIndex());
				   //apply bold to the text
					font.setBoldweight(font.BOLDWEIGHT_BOLD);
					//set font
					style.setFont(font);
					//set cell style
					rowNum.getCell(colno).setCellStyle(style);
					
				}
		   FileOutputStream fos=new FileOutputStream("./TestOutPut/OutPutFile.xlsm");
	       wb.write(fos);	       
	       fos.close();	       
	}
	
	
	public void setHyperLink(String sheetname,int rowno,int colno,String str,String linkAddress) throws Throwable
	{
		Sheet sh=wb.getSheet(sheetname);
		Row rowNum=sh.getRow(rowno);
		Cell cell=rowNum.createCell(colno);
		cell.setCellValue(str);
		
		if(str.equalsIgnoreCase("pass"))
		{
			//create cell data
			CellStyle style=wb.createCellStyle();
			//create font
			Font font=wb.createFont();
			//apply color to text
			font.setColor(IndexedColors.GREEN.getIndex());
		   //apply bold to the text
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			//set font
			style.setFont(font);
			//set cell style
			rowNum.getCell(colno).setCellStyle(style);
			
			
		    Hyperlink href = wb.getCreationHelper().createHyperlink(HyperlinkType.URL);				
			File HtmlFile = new File(linkAddress);
			String File_Html_AbsoultePath_AbsoutePath = HtmlFile.getCanonicalPath();				
			href.setAddress(File_Html_AbsoultePath_AbsoutePath.replace("\\", "/"));
		    cell.setHyperlink(href);
			
			
		}
		else
			if(str.equalsIgnoreCase("Fail"))
			{
				//create cell data
				CellStyle style=wb.createCellStyle();
				//create font
				Font font=wb.createFont();
				//apply color to text
				font.setColor(IndexedColors.RED.getIndex());
			   //apply bold to the text
				font.setBoldweight(font.BOLDWEIGHT_BOLD);

				//set font
				style.setFont(font);
				//set cell style
				rowNum.getCell(colno).setCellStyle(style);	
				
			    Hyperlink href = wb.getCreationHelper().createHyperlink(HyperlinkType.URL);				
				File HtmlFile = new File(linkAddress);
				String File_Html_AbsoultePath_AbsoutePath = HtmlFile.getCanonicalPath();				
				href.setAddress(File_Html_AbsoultePath_AbsoutePath.replace("\\", "/"));
			    cell.setHyperlink(href);
				
			}
			
		   FileOutputStream fos=new FileOutputStream("./TestOutPut/OutPutFile.xlsm");
	       wb.write(fos);	       
	       fos.close();	       
	}
	
}

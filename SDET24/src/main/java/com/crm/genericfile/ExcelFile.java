package com.crm.genericfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile
{
    

       public static String getData(String sheet,int row,int cell) throws Throwable
{
	   
    	  // String val="";
	   
		     FileInputStream fis=new FileInputStream("./Data/Book1.xlsx");
		    
		   Workbook wb = WorkbookFactory.create(fis);
		      String ce = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		     
		      String val = ce.toString();
	     
		return val;
}
       
       public static void main(String[] args) throws Throwable {
		String data=getData("Sheet1", 0, 0);
		System.out.println(data);
	}
}



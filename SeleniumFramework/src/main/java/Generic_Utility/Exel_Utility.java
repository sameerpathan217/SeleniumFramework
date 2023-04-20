package Generic_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exel_Utility {
	/**
	 * This method is not use for all data like it not support contact number, decimal value  
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ExcelDta(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream("./src/test/resources/vTiger.xlsx");
		Workbook book = WorkbookFactory.create(fs);
		       Sheet sheet = book.getSheet(sheetName);
		       Row row1 = sheet.getRow(row);
		       Cell cell1 = row1.getCell(cell);
		       String value = cell1.getStringCellValue();
		       return value;
		       
		     
	} 
	/**
	 * This method is  use for all data like it support contact number, decimal value
	 */
	public String getExcelDataFormatter(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream("./src/test/resources/vTiger.xlsx");
		Workbook book = WorkbookFactory.create(fs);
		DataFormatter format=new DataFormatter();
		     String data = format.formatCellValue(book.getSheet(sheetName).getRow(row).getCell(cell));
		     return data;
	}
		     
		     
		       public String DataFormatter1(String sheetname, int row,int cell) throws EncryptedDocumentException, IOException{
		    	   FileInputStream fis=new FileInputStream("./src/test/resources/vTiger.xlsx");
		       Workbook book = WorkbookFactory.create(fis);
		       DataFormatter df=new DataFormatter();
		       String alldata = df.formatCellValue(book.getSheet(sheetname).getRow(row).getCell(cell));
		       return alldata;
		       }
		      
		       
		       public String  AddContactInSheet(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		    	   FileInputStream fis=new FileInputStream("./src/test/resources/vTiger.xlsx");
		    	   Workbook book = WorkbookFactory.create(fis);
		    	   
		    	   DataFormatter df=new DataFormatter();
		    	   String alldata = df.formatCellValue(book.getSheet(sheetName).getRow(row).getCell(cell));
		    	  return alldata;
		       }
		      
		      public  Object[][] excelDatafetch(String sheetname) throws EncryptedDocumentException, IOException{
		       
		    	  FileInputStream fis=new FileInputStream("./src/test/resources/vTiger.xlsx");
		    	  Workbook book = WorkbookFactory.create(fis);
		    	  Sheet sheet = book.getSheet(sheetname);
		    	 int row = sheet.getLastRowNum()+1;
		    	 int cell = sheet.getRow(0).getLastCellNum();
		    	 Object[][] obj=new Object[row][cell]; 
		    	 for(int i=0;i<row;i++){
		    		 for(int k=0;k<cell;k++) {
		         obj[i][k]=sheet.getRow(i).getCell(k).getStringCellValue();
		    		 }
		    	 }
		    	 
				return obj;	    	  
		      // Object[][] obj=new Object[][];
		       
		    }
		      
		      public String writeDta(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException{
		    	  
		  		FileInputStream fs=new FileInputStream("./src/test/resources/vTiger.xlsx");
				Workbook book = WorkbookFactory.create(fs);
				       Sheet sheet = book.getSheet(sheetName);
				       Row row1 = sheet.getRow(row);
				       Cell cell1 = row1.getCell(cell);
				       String value = cell1.getStringCellValue();
				       
		  		  return value;
		    	  }
		     
		    
		    	  
		    	
		    	 
		      

}

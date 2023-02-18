package ey.qa.opencart.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	
	public static String file_Path = "./src/test/java/resources/Registers.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	
	public static Object[][] readFileData(String sheetName)
	{
		
		Object[][] fileData = null; 
	try {
		FileInputStream fis = new FileInputStream(file_Path);
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetName);
		
		//Now to read the data, We have to use 2D array
		
		fileData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				fileData[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return fileData;
	}
	
}

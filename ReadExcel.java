package bootcampdoubts;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		//FileInputStream excel=new FileInputStream("./data/SalesForceLogin.xlsx");			
		XSSFWorkbook wb=new XSSFWorkbook("./data/Leaftap.xlsx");
		
		
		XSSFSheet sheet=wb.getSheet("CreateLead");
		int noOfRows=sheet.getLastRowNum();
		
		System.out.println(noOfRows);
		
		int noOfCols=sheet.getRow(0).getLastCellNum();
		
		System.out.println(noOfCols);
		
		String data[][] =new String[noOfRows][noOfCols];
		
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			//XSSFRow rows=sheet.getRow(i);
			for(int j=0; j<noOfCols; j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]);
			}
		}
		
	}}
		

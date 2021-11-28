package bootcampdoubts;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static String[][] readdata() throws IOException {
		
		XSSFWorkbook wb=new XSSFWorkbook("./data/Leaftap.xlsx");
		XSSFSheet sheet = wb.getSheet("CreateLead");
		int row=sheet.getLastRowNum();
		System.out.println("row count --->"+ row);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("column count--->"+ lastCellNum);
		String[][] data=new String[row][lastCellNum];
		
		for(int i=1;i<=row;i++) {
			for(int j=0;j<lastCellNum;j++) {
				
				
				
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=stringCellValue;
				System.out.println("column1 and column2 values -->"+ stringCellValue);
				wb.close();
				
			}
		}
		return data;
	}

}
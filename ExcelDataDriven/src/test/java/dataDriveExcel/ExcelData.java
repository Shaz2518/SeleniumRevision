package dataDriveExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream excelPath = new FileInputStream("C:\\Users\\localadminuser\\Desktop\\SeleniumPractice\\DataDriverExcel\\ExcelData.xlsx");
		XSSFWorkbook excelBook = new XSSFWorkbook(excelPath);
		
		int sheetCount = excelBook.getNumberOfSheets();
		for(int i=0; i<sheetCount; i++)
		{
			if(excelBook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = excelBook.getSheetAt(i);
				Iterator<Row> sheetRow = sheet.iterator();
				Row firstRow = sheetRow.next();
				
				Iterator<Cell> rowCells = firstRow.cellIterator();
				while(rowCells.hasNext())
				{
					Cell cellValue = rowCells.next();
					if(cellValue.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						
					}
				}
				
				
			}
		}
		

	}

}

package Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriting {

	public static void main(String[] args) throws IOException {

		//Initialize the workbook object
		XSSFWorkbook wb = new XSSFWorkbook();
		
		//Create the sheet from the above workbook object
		XSSFSheet sh = wb.createSheet("Test Results");
		
		//Initialize object for 5 rows using array
		XSSFRow rows[] = new XSSFRow[5];
		
		//Crete new 5 rows for the above arrays
		rows[0] = sh.createRow(0);
		rows[1] = sh.createRow(1);
		rows[2] = sh.createRow(2);
		rows[3] = sh.createRow(3);
		rows[4] = sh.createRow(4);
		
		//Initialize an array of string for titles
		String titles [] = new String [4];
		titles [0] = "Serial No";
		titles [1] = "Test Case Name";
		titles [2] = "Result";
		
		//Write the above array of string values into the cells of first row
		rows[0].createCell(0).setCellValue(titles[0]);
		rows[0].createCell(1).setCellValue(titles[1]);
		rows[0].createCell(2).setCellValue(titles[2]);
		
		//Write the serial number values from first row to last row for cell 1
		rows[1].createCell(0).setCellValue(1);
		rows[2].createCell(0).setCellValue(2);
		rows[3].createCell(0).setCellValue(3);
		rows[4].createCell(0).setCellValue(4);
		
		//Initialize an array of string for test case names
		String testcases [] = new String [4];
		testcases [0] = "Create Lead";
		testcases [1] = "Edit Lead";
		testcases [2] = "Delete Lead";
		testcases [3] = "Merge Lead";
		
        //For loop to write the above array of strings into the particular cells
		int j = 1 , a = 0;
        for(int i=1 ; i<=4 ; i++)		
        {
        	rows[i].createCell(j).setCellValue(testcases[a]);
        	a++;
        }
        
        //Create a for loop to write the test results ' PASS / FAIL ' in the last cell of every row        
        int b = 1, c = 2;
        for(int k=2; k<=5;k++)
        {
        	if((k%2) == 0 )
        	{
        		rows[b].createCell(c).setCellValue("FAIL");
        	}
        	else
        	{
        	   rows[b].createCell(c).setCellValue("PASS");
        	}
        	b++;
        }
		
		FileOutputStream fos = new FileOutputStream(new File("d://sheet/TestBook.xlsx"));
		
		wb.write(fos);
		wb.close();
		
		
		
		
	}

}

package Week3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelHandling {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Set the system property
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
				//Launch Chrome
				ChromeDriver dri = new ChromeDriver();
				
				//Get the URL
				dri.get("http://www.amazon.in");
				dri.manage().window().maximize();
				Thread.sleep(10000);
				
				FileInputStream fis = new FileInputStream(new File("./data/Book1.xlsx"));

				XSSFWorkbook wb = new XSSFWorkbook(fis);
		
				XSSFSheet sheet = wb.getSheet("Sheet1");
		
				System.out.println("Number of rows:"+ sheet.getLastRowNum());
				
		     XSSFRow currentrow = sheet.getRow(1);
		     
		      
		     System.out.println("First Row value:"+currentrow.getCell(0).getStringCellValue());
		   //dri.findElementByXPath("//*[@id='redir-overlay']").click();
		     
		    dri.findElementById("twotabsearchtextbox").sendKeys(currentrow.getCell(0).getStringCellValue());
		     
		//     String parentwindow = dri.getWindowHandle();
		     
		  //   Set <String> session= dri.getWindowHandles();
		     
           /* for (String currentwindow : session) {
            	dri.switchTo().window(currentwindow);
            	if(!dri.getWindowHandle().equals(parentwindow))
            	{
            		System.out.println("This is a window");
            		dri.close();
            	}
				dri.switchTo().defaultContent();
			}*/
		     
		     dri.findElementByXPath("//*[@id='nav-search']/form/div[2]/div/input").click();
		     
		     String thirdvalue = currentrow.getCell(1).getStringCellValue();
		     
		     System.out.println(thirdvalue);
		     
		     List <WebElement> links= dri.findElementsByTagName("h2");
		     
          for (WebElement eachlink : links) {
			if(eachlink.getText().equals("HP Entry Level Backpack (Black)"))
			{
				eachlink.click();
			}
		}
	}

}


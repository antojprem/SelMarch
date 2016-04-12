package Week3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonExcel {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Set the system property
		System.setProperty("Webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Initialise the dirver
		ChromeDriver dri = new ChromeDriver();
		
		//Launch the browser
		dri.get("http://www.amazon.in/");
		
		//maximize the window
		dri.manage().window().maximize();
		
		//Initialise the file input stream
//		FileInputStream fis = new FileInputStream("./projects/data/Book1.xlsx");

	}

}

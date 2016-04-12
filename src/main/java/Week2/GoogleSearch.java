package Week2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //Launch Firefox driver
//		FirefoxDriver dri = new FirefoxDriver();
     
     //set the system property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//Launch the chrome browser
		ChromeDriver dri = new ChromeDriver();
		
		//Maximize the browser
		dri.manage().window().maximize();
     
	//Navigate to url
		dri.get("http://www.crystalcruises.com/Calendar.aspx");
		
		
	}

}

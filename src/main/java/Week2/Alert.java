package Week2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) {
		//Set system property for chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Initialize the driver
		ChromeDriver dri = new ChromeDriver();
		
		//maximize the window
		dri.manage().window().maximize();
		
		//Launch the site
		dri.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		//click the button
		dri.findElement(By.id("loginbutton")).click();
		
		try {
			//Declare an Alert object
			org.openqa.selenium.Alert a = dri.switchTo().alert();
			
			//Print the text of the alert
			System.out.println("This is the alert text just popped up:"+a.getText());
			
			//accept the alert
			a.accept();
		} catch (Exception e) {
          System.out.println("There is no alert");
		}
		
	}

}

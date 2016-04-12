package Week2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
    //set the chrome property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Initialize the chrome driver
		ChromeDriver dri = new ChromeDriver();
		
		//maximize the window
		dri.manage().window().maximize();
		
		//launch the url
		dri.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		Select dropdowns = new Select(dri.findElement(By.id("userRegistrationForm:securityQ")));
		List <WebElement> dropitems = dropdowns.getOptions();
		System.out.println(dropitems.get(1).toString());
		dropdowns.selectByIndex(1);
		//dropdowns.selectByValue(arg0);
	  //  System.out.println(dropdowns);
//		dropdowns.selectByVisibleText("What is your pet name?");
	    
		
		/*int count = 0;
		for (WebElement listitem : nooflistitems) {
			
			System.out.println("List Items "+listitem.getText());
			count = count + 1;
			System.out.println("Number of dropdowns "+count);
		}
		
		System.out.println("Number of dropdowns "+count);

*/
	}

}

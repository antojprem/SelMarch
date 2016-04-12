package Week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOpenTaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
  //launch Firefox
   FirefoxDriver dri = new FirefoxDriver();
   
   //Navigate to the URL
   dri.get("http://demo1.opentaps.org/opentaps/control/main");
   
   //Maximize the window
   dri.manage().window().maximize();
   
   //Print the title
   System.out.println(dri.getTitle());
   
   //Filling the Username
   dri.findElementById("username").sendKeys("anto_jprem");
   
   //Filling the password
   dri.findElementById("password").sendKeys("homework5");
   
   //Click the Login
   dri.findElementByClassName("decorativeSubmit").click();
   
//	Setting a default time out for identifying objects (after the page is completely loaded)
   dri.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
   
   //print the title of the webpage
   System.out.println(dri.getTitle());
   
   //click CRM/FSA
   dri.findElementByClassName("crmsfa").click();
   
 //Click create lead
 	dri.findElementByLinkText("Create Lead").click();
 	
 	//Enter Company name
 	dri.findElementById("createLeadForm_companyName").sendKeys("AON");
 			
 	//Enter First name
	dri.findElementById("createLeadForm_firstName").sendKeys("Anto");
 			
 	//Enter Last name
 	dri.findElementById("createLeadForm_lastName").sendKeys("J");
 			
 	//Click Create lead
 	dri.findElementByClassName("smallSubmit").click();
 	
 	
	}

}

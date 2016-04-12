package Week3;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrapper {

	
	WebDriver dri;
	
	//Input - from OpenTapsWrpper.java ( chrome or firefox )
	//Output - to launch chrome or Firefox based on the if condition check
	
	public void launchwebsite(String browser, String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			dri = new ChromeDriver();
		    dri.get(url);	
		    dri.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			dri = new FirefoxDriver();
			dri.get(url);
			dri.manage().window().maximize();
		}
	}
	
	//Input - from OpenTapsWrapper.java ( username and password)
	//Output - to send the values to the fields username and password
	
	public void findelementsbyidsendkeys(String id, String value)
	{
		try {
			dri.findElement(By.id(id)).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Username "+id+" does not match");
		}
	}
	
	// Input - from OpenTapsWrapper.java ( clickable button value by id)
	// Output - To click the button
	
    public void clickbuttonbyidclick(String button)
    {
    	dri.findElement(By.className(button)).click();;
    }

	//Input - from OpenTapsWrapper.java ( by classname )
	//Output - to send the values to the fields username and password
	
	public void findelementsbyclassnamesendkeys(String id, String value)
	{
		try {
			dri.findElement(By.className(id)).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to access the vale : "+id);
		}
	}
	
	// Input - from OpenTapsWrapper.java ( clickable button value by classname)
	// Output - To click the button
	
    public void clickbuttonbyclassnameclick(String button)
    {
    	try {
			dri.findElement(By.className(button)).click();;
		} catch (Exception e) {
			// TODO Auto-generated catch block
   System.out.println("Not able to access the element " +button);
		}
    }

	
	//Input - from OpenTapsWrapper.java ( by xpath )
		//Output - to send the values to the fields username and password
		
		public void findelementsbyxpathsendkeys(String id, String value)
		{
			dri.findElement(By.xpath(id)).sendKeys(value);
		}
		
		public void findelementsbyxpathclick(String button)
		{
			dri.findElement(By.xpath(button)).click();
		}

	// Input - get a string value from OpenTapsWrapper.java
	//Output - Move the control to the primary window
		public void primarywindowswitch(String primarywindow)
		{
			try {
				primarywindow = dri.getWindowHandle();
				dri.switchTo().window(primarywindow);
				System.out.println("Name of the primary window : "+dri.getTitle());
			} catch (Exception e) {
				System.out.println("Not able to switch to primary window : " +primarywindow);
			}
		}
		
		public void lastwindow()
		{
			String primarywindow = dri.getWindowHandle();
			Set <String> session = dri.getWindowHandles();
			
			for (String lastwindow : session) 
			  {
				dri.switchTo().window(lastwindow);
				System.out.println("This is the last window :"+lastwindow);
				if(!dri.getWindowHandle().equals(primarywindow))
				  {
					try {
						System.out.println("This is the last window : "+dri.getTitle());
					} catch (Exception e) {
                        System.out.println("Not able to find the last window :"+lastwindow);
					}
					dri.close();
				  }
				dri.switchTo().defaultContent();
			}	
		}
		public void acceptalert()
		{
			try {
				Alert a = dri.switchTo().alert();
				a.accept();
			} catch (Exception e) {
			  System.out.println("There is no alert to accept");	
			}
		}
		
		public void dismissalert()
		 {
			try {
				Alert a = dri.switchTo().alert();
				a.dismiss();
			} catch (Exception e) {
              System.out.println("There is no alert to dismiss");
			}
		 }
		public void selectvaluebyindex(int index)
		{
	     Select dropdown = new Select(dri.findElement(By.id("userRegistrationForm:securityQ")));
	     String firstelement = dropdown.getOptions().get(0).getText();
	    // List <String> value = dri.findElement(By.id("userRegistrationForm:securityQ")).gdropdown.getOptions();
	     
		}
		
		public void verifythetitle(String title)
		{
		  if(dri.getTitle().equals(title))
		  {
		  System.out.println("This is the expected title: "+dri.getTitle());
		  }
		  else
		  {
	      System.out.println("This is not the expected title: "+dri.getTitle());
		  }
		}
		
		public void geturl(String url)
		{
			if(dri.getCurrentUrl().equals(url))
			{
				System.out.println("The passing url is the expected url : "+url);
			}
			else
			{
				System.out.println("The passing url is not the expected url : "+url);
			}
		}
		
		//Switch to the first frame
		public void switchtoframe(String frame)
		{
           	dri.switchTo().frame(frame);
			System.out.println("This is the first frame in this page: "+dri.getTitle());
		}
		//Switch to the frame by element
        public void switchtoframebyelement(String frame)
        {
        	dri.switchTo().frame(dri.findElement(By.id(frame)));
            System.out.println("This is the frame by element: " +dri.getTitle());
        }
}

package Week2;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindNumberOfLinks{

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		//Set the property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//Launch Chrome browser
		ChromeDriver dri = new ChromeDriver();

		//Get the URL
		dri.get("https://www.google.co.in");

		//maximize the window
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Filling the textbox
		dri.findElementById("lst-ib").sendKeys("Anto");

		dri.findElementByTagName("button").click();
       // Thread.sleep(10000);
		Thread.sleep(5000);
        //Inspect Elements - find elements
		List<WebElement> AllLinks = dri.findElementsByTagName("a");

		System.out.println("Total Number of Links"+AllLinks.size());	

		for (WebElement Links : AllLinks) 
		    {
             if( Links.getText().contains("Anto") || ( Links.getText().contains("ANTO") &&
                ( Links.getLocation().x > 100 ) && ( Links.getAttribute("data-href").length() > 20 ) ) )
             {
			  System.out.println(Links.getText());
			
			}
		  }
	}
}

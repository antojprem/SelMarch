package Week3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonFrames {

	public static void main(String[] args) {
    //set the system property
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	//Initialise the chrome driver
	ChromeDriver dri = new ChromeDriver();
		
	//Launch the browser
	dri.get("http://www.amazon.in/");
	
	//maximize the window
	dri.manage().window().maximize();
	
	//Count the number of Main Frames
	List<WebElement> Count= dri.findElements(By.tagName("iframe"));
	int totalcount = Count.size();
	System.out.println("Total number of main frames: "+totalcount);
//	System.out.println(dri.findElement(By.tagName("iframe")).getText());
	
	//Count the child frames
	for (WebElement child : Count) 
	{
		dri.switchTo().frame(child);
	    List<WebElement> childcount = dri.findElements(By.tagName("iframe"));
	    System.out.println("Child frame count: "+childcount.size());
	    totalcount = totalcount+childcount.size();
		dri.switchTo().defaultContent();
	}
    //print the total number of frames in the site
	System.out.println("Total number of frames in this site: "+totalcount);
	
	}

}

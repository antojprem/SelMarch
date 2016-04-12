package Week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindNumberOfFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Set the system property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Launch Chrome
		ChromeDriver dri = new ChromeDriver();
		
		//Get the URL
		dri.get("http://layout.jquery-dev.com/demos/iframes_many.html");
	
		//maximize the window
		dri.manage().window().maximize();
		//List<WebElement> Parents = dri.findElementsByTagName("button");
		
		//Move to IFrame
//		dri.switchTo().frame(dri.findElementByTagName("iframe"));
		
	   List<WebElement> Count = dri.findElementsByTagName("iframe");
		System.out.println(Count.size());
		
		int count1 = Count.size(); 
	   
	   for (WebElement Find : Count)
	       {
		   dri.switchTo().frame(Find);
			//dri.switchTo().frame(dri.findElementByTagName("iframe"));
			List<WebElement> child1 = dri.findElementsByTagName("iframe");
			System.out.println(child1.size());
			count1 = count1 + child1.size();
			dri.switchTo().defaultContent();
	       }
	   
	   System.out.println("Total Number of Frames:"+count1);
		
		//dri.close();
	}

}

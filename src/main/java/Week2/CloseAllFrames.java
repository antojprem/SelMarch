package Week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAllFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Set the system property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Launch Chrome
		ChromeDriver dri = new ChromeDriver();
		
		//Get the URL
		dri.get("http://layout.jquery-dev.com/demos/iframe_local.html");
	
		//maximize the window
		dri.manage().window().maximize();
		
		List<WebElement> Parents = dri.findElementsByTagName("button");
		
		for (WebElement Name : Parents) {
			if(Name.getText().equals("Close Me"))
			{
				System.out.println(Name);
				Name.click();
			}
		}
		dri.findElementByXPath("/html/body/div[5]/div").click();
		dri.findElementByXPath("/html/body/div[6]/div").click();
		
		//Move to IFrame
		dri.switchTo().frame("childIframe");
		//dri.switchTo().defaultContent();
		List<WebElement> child = dri.findElementsByTagName("button");
		
		for (WebElement subframe : child) {
			if(subframe.getText().equals("Close Me"))
			{
				subframe.click();
			}
		}
		
		dri.findElementByXPath("/html/body/div[6]/div").click();
		dri.findElementByXPath("/html/body/div[7]/div").click();
		//dri.switchTo().frame(dri.findElementByClassName("ui-layout-center ui-layout-pane ui-layout-pane-center"));
		
		//Count the frames in the above page
		
		//dri.switchTo().frame(dri.findElementByClassName("navbar-header"));
		//System.out.println(dri.getTitle());
	}

}

package Week3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrapper1 {
	
	WebDriver dri;
	
	public void launchbrowser(String browser, String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        if(browser.equals("chrome"))
        {
        	dri = new ChromeDriver();
    		dri.get(url);
    		dri.manage().window().maximize();
    		
    		dri.findElement(By.linkText("Multi-PopUp Test #2")).click();
        }
		
		
	}
	
	public void getprimarywindow(String value)
	{
		value = dri.getWindowHandle();
		System.out.println("Name of the Primary window : "+dri.getTitle());
	}
	
	public void getsecondarywindow(String primaryvalue)
	{
		primaryvalue = dri.getWindowHandle();
		Set <String> childvalue = dri.getWindowHandles();
		for (String childtemp : childvalue) {
			dri.switchTo().window(childtemp);
			if(!dri.getWindowHandle().equals(primaryvalue))
			{
				System.out.println("This is one of the child window : "+dri.getTitle());
				dri.close();
			}
			dri.switchTo().window(primaryvalue);
		}
		
	}
	
	public void movetolastwindow(String primarywindow)
	{
		primarywindow = dri.getWindowHandle();
		Set <String> allwindow = dri.getWindowHandles();
		int count  = allwindow.size();
		System.out.println(count);	
		for(int i =1;i<count;i++)
		{
			allwindow.remove(allwindow.iterator().next());
		}
		String lastwindow = allwindow.iterator().next();
		System.out.println(lastwindow);
		
	}
}

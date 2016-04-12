package Week2;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver dri = new ChromeDriver();
		
		dri.get("http://popuptest.com/");
		
		dri.manage().window().maximize();
		
		dri.findElementByLinkText("Multi-PopUp Test #2").click();
		
		String parentwindow = dri.getWindowHandle();
		
		Set <String> sessions = dri.getWindowHandles();
		
		for (String session : sessions)
		{
			
			dri.switchTo().window(session);
			if(!dri.getWindowHandle().equals(parentwindow))
			{
				System.out.println(dri.getTitle());
				dri.close();
			}
			
			dri.switchTo().window(parentwindow);
		}
		System.out.println("Title of the parent window"+dri.getTitle());
	}
}

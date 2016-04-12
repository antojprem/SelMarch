package Week2;

import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		// Set the system properties
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch Browser - Google Chrome
		ChromeDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to URL
		driver.get("http://jqueryui.com/draggable");

		// switch to frame
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));

		System.out.println(driver.findElementById("draggable").isDisplayed());

		driver.switchTo().defaultContent(); // Moves to the main page
		 
		//driver.findElementByLinkText("Droppable").click();

		// driver.quit();


	}

}

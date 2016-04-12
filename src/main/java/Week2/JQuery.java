package Week2;

import org.openqa.selenium.chrome.ChromeDriver;

public class JQuery {

	public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
       
       ChromeDriver dri = new ChromeDriver();
       
       dri.get("http://jqueryui.com/");
       
       dri.manage().window().maximize();
       
       dri.findElementByLinkText("Draggable").click();;
       
       dri.switchTo().frame(dri.findElementByClassName("demo-frame"));
       
       System.out.println("Items inside Draggable" + dri.findElementById("draggable").getText());
       
       dri.switchTo().defaultContent();
       
       dri.findElementByLinkText("Droppable");
       
       


	}

}

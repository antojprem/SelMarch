package Week3;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OpenTapsWrapper extends Wrapper{

@Test
public void OpenTaps()
{
	launchwebsite("chrome","http://layout.jquery-dev.com/demos/iframe_local.html");
//	findelementsbyidsendkeys("username","DemoSalesManager");
//	findelementsbyidsendkeys("password","crmsfa");
//	clickbuttonbyidclick("decorativeSubmit");
//	primarywindowswitch("MainWindow");
//	lastwindow();
//	acceptalert();
//	dismissalert();
//	selectvaluebyindex(8);
//	verifythetitle("IRCTC Next Generation eTicketing System");
//	geturl("https://www.irctc.co.in/eticketing/userSignUp.jsf");
	switchtoframe("childIframe");
	switchtoframebyelement("childIframe");
}
}

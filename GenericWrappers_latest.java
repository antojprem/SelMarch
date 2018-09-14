package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;

public class GenericWrappers {
	
protected static RemoteWebDriver driver;
protected static Properties prop;
protected String appURL;

public GenericWrappers() {
	
	Properties prop = new Properties();
	try {
		prop.load(new FileInputStream(new File("./config.properties")));
		appURL = prop.getProperty("URL");
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

/* This will launch the browser and set the wait for 30 seconds and load the url
 * @author - Anto Prem
 */
	public boolean invokeApp(String browser) {
		boolean bReturn = false;
		try{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.WINDOWS);
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Reporter.reportStep("The browser:"+browser+"launched successfully", "PASS");
		bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The browser:"+browser+"could not be launched", "FAIL");
		}

		return bReturn;
	}
	
/*
 * Input - webelement id and string to be filled in the webelement
 * Output - Enters given string in the desired web-object in the webelement
 * @author - Anto Prem
 */
	public boolean enterById(String id, String value) {
		boolean bReturn = false;
		try {
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(value);
		Reporter.reportStep("The data:"+value+"entered successfully in the field:"+id, "PASS");
		bReturn = true;
		}catch(NoSuchElementException e) {
			Reporter.reportStep("The data:"+value+"could not entered into the filed:"+id, "FAIL");
		}
		return bReturn;
	}

/*
 * Input - web element xpath and string to be filled in the web element
 * Output - Enters given string in the desired web-object in the web element
 * @author - Anto Prem
 */
	public boolean enterByXpath(String xpath, String value) {
		boolean bReturn = false;
		try{
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			Reporter.reportStep("The data:"+value+" entered successfully in the field:"+xpath, "PASS");
			bReturn = true;
		}catch(NoSuchElementException e) {
			Reporter.reportStep("The data:"+value+" could not entered into the filed:"+xpath, "FAIL");
		}
		
		return bReturn;
	}
	
	/*
	 * Input - web element cssSelector and string to be filled in the web element
	 * Output - Enters given string in the desired web-object in the web element
	 * @author - Anto Prem
	 */
	public boolean enterBycssSelector(String cssSelector, String value){
		boolean bReturn = false;
		try{
			driver.findElement(By.cssSelector(cssSelector)).clear();
			driver.findElement(By.cssSelector(cssSelector)).sendKeys(value);
			Reporter.reportStep("The data:"+value+" entered successfully in the field:"+cssSelector, "PASS");
		}catch(Exception e){
			Reporter.reportStep("The data:"+value+" could not entered into the field:"+cssSelector, "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will verify the given text 
	 * @param xpath - The locator of the object in xpath
	 * @param text - The text to be verified
	 * @author - Anto Prem
	 */
	public boolean verifyTextByXpath(String xpath,String value){
		boolean bReturn = false;
		String sText = driver.findElement(By.xpath(xpath)).getText();
		if(sText.equalsIgnoreCase(value)){
			Reporter.reportStep("The text:"+sText+"matches with the given value:"+value, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text:"+sText+"did not match with the given value:"+value, "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will click the given element using id as locator
	 * @param - The id of the element
	 * @author - Anto Prem
	 */
	public boolean clickById(String id){
		boolean bReturn = false;
		try{
		driver.findElement(By.id(id)).click();
		Reporter.reportStep("The element with id:"+id+" is clicked", "PASS");
		bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with id:"+id+" could not be clicked", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will click the given element using xpath as locator
	 * @param - The xpath of the element
	 * @author - Anto Prem
	 */
	public boolean clickByXpath(String xpath){
		boolean bReturn = false;
		try{
		driver.findElement(By.xpath(xpath)).click();
		Reporter.reportStep("The element with xpath:"+xpath+" is clicked", "PASS");
		bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with xpath:"+xpath+" could not be clicked", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will click the given element using cssSelector as locator
	 * @param - The cssValue of the element
	 * @author - Anto Prem
	 */
	public boolean clickByCssSelector(String cssSelector){
		boolean bReturn = false;
		try{
			driver.findElement(By.cssSelector(cssSelector)).click();
			Reporter.reportStep("The element with cssSelector:"+cssSelector+" is clicked", "PASS");
			bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with cssSelector:"+cssSelector+" could not be clicked", "FAIL");
		}
		
		return bReturn;
	}
	
	/*
	 * This method will click the given element using class name as locator
	 * @param - The class name of the element
	 * @author - Anto Prem
	 */
	public boolean clickByClassName(String className){
		boolean bReturn = false;
		try{
			driver.findElement(By.className(className)).click();
			Reporter.reportStep("The element with classname:"+className+" is clicked", "PASS");
			bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with classname:"+className+" could not be clicked", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will click the given element using link text as a locator
	 * @param - The link text of the element
	 * @author - Anto Prem
	 */
	public boolean clickByLinkText(String linkText){
		boolean bReturn = false;
		try{
			driver.findElement(By.linkText(linkText)).click();
			Reporter.reportStep("The element with link text:"+linkText+" is clicked", "PASS");
			bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with link text:"+linkText+" could not be clicked", "FAIL");
		}
		return bReturn;
	}
/*
 * This method will verify the title of the browser
 * @author - Anto Prem
 */
	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if(driver.getTitle().equalsIgnoreCase(title)) {
				Reporter.reportStep("The title of the page matches with the value:"+title, "PASS");
				bReturn = true;
			}else
				Reporter.reportStep("The title of the page not matches with the value:"+title, "FAIL");
		}catch(Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}
		return bReturn;
	}
	
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		}catch(Exception e){
			Reporter.reportStep("Element with xpath"+xpathVal+" could not be found", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method is used to accept the alert
	 * @author - Anto Prem
	 */
	public String acceptAlert(){
		String bReturn = "";
		try{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
		}catch(NoAlertPresentException e){
			Reporter.reportStep("The given alert not present", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method is used to cancel the alert
	 * @author - Anto Prem
	 */
	public String cancelAlert(){
		String bReturn = "";
		try{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.dismiss();
		}catch(NoAlertPresentException e){
			Reporter.reportStep("The given alert not present", "FAIL");
		}
		return bReturn;
	}
	
	/* This method is used to generate a 10 digit random number
	 * Input - no input
	 * Output - newly generate random number
	 * @author - Anto Prem
	 */
	public String generateRandomNumber(){
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++){
			sb.append((char)('0'+rd.nextInt(10)));
		}
		return sb.toString();
	}
	
	/* This method is used to reverse the given string value
	 * Input - string value
	 * Output - reverse of that string
	 * @author - Anto Prem
	 */
	public String reverseString(String value){
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		return (sb.reverse().toString());
	}
	
	/* This method is used to move the file in the given path
	 * Input - Source & Destination file path
	 * Output - Move the source file to the destination path
	 * @author - Anto Prem
	 */
	public void fileArchieve(String sourceFilePath,String destinationFilePath) throws IOException{
	File downloadDirectoryFile = new File(sourceFilePath);
	File[] files = downloadDirectoryFile.listFiles();
	File lastModifiedFile = files[0];
	for (int i = 1; i < files.length; i++) {
		if (lastModifiedFile.lastModified() < files[i].lastModified()) {
			lastModifiedFile = files[i];
		}
	}
	FileUtils.moveFileToDirectory(lastModifiedFile, new File(destinationFilePath), true);
	}
	
	/*
	 * This method is used to change the given date into a specified format
	 * Input - date & required format
	 * Output - date into the required format
	 * @author - Anto Prem
	 */
	public String dateConversion(String Date, String format){
		String ConvertedDate=null, ActualDate=null, myDate1=null, myDate2=null;
		Date conDate=null;
		SimpleDateFormat formatter = new SimpleDateFormat();
		
		ActualDate = Date;
		myDate1 = ActualDate.replace("-", "/");
		myDate2 = myDate1.replaceAll(myDate1.substring(9, 18), "");
		
        conDate = new Date(myDate2);
        switch (format){
        case "MM/dd/yyyy":
        	formatter=new SimpleDateFormat("MM/dd/yyyy");
        	break;
        case "dd/MM/yyyy":
        	formatter=new SimpleDateFormat("dd/MM/yyyy");
        	break;
        case "yyyy/MM/dd":
        	formatter=new SimpleDateFormat("yyyy/MM/dd");
        	break;
        }
        ConvertedDate=formatter.format(conDate);
	return ConvertedDate;
	}

	/*
	 * This method is used to read an excel file
	 * Input - excelfile name, row, cell position
	 * Output - text in the give cell position
	 * @author - Anto Prem
	 */
	public String readExcel(String excelfile, int rowposition, int cellposition){
	String cellValue = "";
	try{
	FileInputStream fis = new FileInputStream(new File(excelfile));
	System.out.println(fis);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(0);
	cellValue = sheet.getRow(rowposition).getCell(cellposition).getStringCellValue();
	}catch (IOException io)
	{
		io.printStackTrace();
	}
	return cellValue;
	}
	/*
	 * This method will select the drop down value using id as locator
	 * @param id - The locator of the drop down element
	 * @param value - The value to be selected (visible text) from the drop down
	 * @author - Anto Prem
	 */
	public boolean selectDropDownById(String id,String value){
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			Reporter.reportStep("The element with id"+id+" is selected with the value"+value, "PASS");
			bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with id"+id+" could not be selected", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will select the drop down value using name as locator
	 * @param id - The locator of the drop down element
	 * @param value - The value to be selected (visible text) from the drop down
	 * @author - Anto Prem
	 */
	public boolean selectDropDownByName(String name,String value){
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.name(name))).selectByVisibleText(value);
			Reporter.reportStep("The element with id"+name+" is selected with the value"+value, "PASS");
			bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with id"+name+" could not be selected", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will select the drop down value using id as locator
	 * @param xpath - The locator of the drop down element
	 * @param value - The value to be selected (visible text) from the drop down
	 * @author - Anto Prem
	 */
	public boolean selectDropDownByXpath(String xpath,String value){
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			Reporter.reportStep("The element with xpath"+xpath+" is selected with the value"+value, "PASS");
			bReturn = true;
		}catch(Exception e){
			Reporter.reportStep("The element with xpath"+xpath+" could not be selected", "FAIL");
		}
		return bReturn;
	}
	
	/*
	 * This method will switch to the primary or parent window
	 * Input - no input
	 * @author - Anto Prem
	 */
	public boolean switchToPrimaryWindow(){
		boolean bReturn = false;
		
		
		return bReturn;
	}
	
	
	/*
	 * This method will load the objects from the object.properties file
	 * @author - Anto Prem
	 */
	
	public void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./object.properties")));
	}
}

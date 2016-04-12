package Week1;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

// Program to automate IRCTC Registration until capta
public class IrctcRegistration {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    FirefoxDriver dri = new FirefoxDriver();
    
    dri.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
    dri.manage().window().maximize();
    
    // get the webpage title
    System.out.println(dri.getTitle());
    
    //Filling the Registration form
    
    //Filling User Id
    dri.findElementById("userRegistrationForm:userName").sendKeys("anto_jprem");
    
    //Filling Password
    dri.findElementById("userRegistrationForm:password").sendKeys("homework4");
    
    //Fillng Confirm Password
    dri.findElementById("userRegistrationForm:confpasword").sendKeys("homework4");
    
    //Filling Security Question
    dri.findElementById("userRegistrationForm:securityQ").sendKeys("What was the name of your first school?");
    
    //Filling Security Answer
    dri.findElementById("userRegistrationForm:securityAnswer").sendKeys("St.Peter's");
    
    //Filling First Name
    dri.findElementById("userRegistrationForm:firstName").sendKeys("Anto");
    
    //Filling Middle Name
    dri.findElementById("userRegistrationForm:middleName").sendKeys("");
    
    //Filling Last Name
    dri.findElementById("userRegistrationForm:lastName").sendKeys("Prem");
    
    //Filling Gender
    dri.findElementById("userRegistrationForm:gender:0").click();
    
    //Filling Marital Status
    dri.findElementById("userRegistrationForm:maritalStatus:0").click();
    		
    //Fillig Date Of Birth
    dri.findElementById("userRegistrationForm:dobDay").sendKeys("15");
    dri.findElementById("userRegistrationForm:dobMonth").sendKeys("MAY");
    dri.findElementById("userRegistrationForm:dateOfBirth").sendKeys("1982");
    
    //Filling Occupation
    dri.findElementById("userRegistrationForm:occupation").sendKeys("PRIVATE");
    
    //Filling Aadhar Number
    dri.findElementById("userRegistrationForm:uidno").sendKeys("ABCD1234");
    
    //Filling Email id
    dri.findElementById("userRegistrationForm:email").sendKeys("anto_jprem@yahooo.co.in");
    
    //Filling Mobile Number
    dri.findElementByName("userRegistrationForm:mobile").sendKeys("9840586779");
    
    //Filling Nationality
    dri.findElementByName("userRegistrationForm:nationalityId").sendKeys("India");
    
    //Filling Residential Address
    dri.findElementById("userRegistrationForm:address").sendKeys("523");
	dri.findElementById("userRegistrationForm:street").sendKeys("Ram Nager");
	dri.findElementById("userRegistrationForm:area").sendKeys("Madipakkam");
	dri.findElementById("userRegistrationForm:countries").sendKeys("India");
	dri.findElementById("userRegistrationForm:pincode").sendKeys("600091");
    
	//To wait for the web page to load city and post office
	Thread.sleep(10000);
	
	//Filling City and post office
	dri.findElementById("userRegistrationForm:cityName").sendKeys("Kanchipuram");
	dri.findElementById("userRegistrationForm:postofficeName").sendKeys("Madipakkam S.O");
	dri.findElementById("userRegistrationForm:landline").sendKeys("9840586779");

	dri.quit();
	
	
   System.out.println("I got the IRCTC site registration page open successfully");
	}

}

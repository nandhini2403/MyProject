package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
		
	//CREATE object repository 
	
	// @Findby is a replacement of driver.findElement(By.
	@FindBy(css ="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement Username;

	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")
	WebElement Password;
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
    WebElement LoginButton;
	
	
	//INITIATE PAGE ELEMENTS
	public PomLogin() {
		PageFactory.initElements(driver,this);
		
	}
	public void typeusername(String name) {
		System.out.println("inside typeusername method");
		System.out.println(Username);
			Username.sendKeys();
}
	public void typepassword (String pass) {
		Password.sendKeys(pass);
		
	}
	public void clickbtn() {
		//LoginButton.click();
		
	}
	public String verify() {
		return driver.getTitle();
	}
} 
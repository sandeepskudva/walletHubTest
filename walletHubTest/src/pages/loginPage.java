package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableFunctions.Resuse;

public class loginPage {
	
	WebDriver driver;

	
	@FindBy(name="em")
	WebElement emailAddress;
	
	@FindBy(name="pw")
	WebElement passwordTxt;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement Loginbtn;
	
	public loginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
	
	public void accountLogin(String username,String password){

		Resuse.simpleLog("Entering Username");
		emailAddress.sendKeys(username);
		Resuse.simpleLog("Entering Password");
		passwordTxt.sendKeys(password);
		Loginbtn.click();

	}

}

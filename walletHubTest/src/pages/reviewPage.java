package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import reusableFunctions.Resuse;

public class reviewPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='dropdown second']")
	WebElement reviewType;
	
	@FindBy(xpath="//li[text()='Health Insurance']")
	WebElement selectHealthInsurance;
	
	@FindBy(xpath="//textarea[starts-with(@placeholder,'Write your')]")
	WebElement reviewTxtArea;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Submitbtn;
	
	@FindBy(xpath="//h2")
	WebElement confrimHeading;
	
	@FindBy(xpath="//h4")
	WebElement postConfirmation;
	
	@FindBy(xpath="//div[@class='rvc-body-middle']//p")
	WebElement reviewtxtConfirmation;
	
	@FindBy(xpath="//div[text()='Continue']")
	WebElement continueBtn;
		
	public reviewPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
	
	public void addReview(String Reviewcontent){

		// Select Health insurance in dropdown
		Resuse.simpleLog("Selecting Dropown value");
		reviewType.click();
		
		Resuse.simpleLog("Health Insurance");
		selectHealthInsurance.click();
		
		
		Resuse.simpleLog("Enter Review Comment");
		reviewTxtArea.sendKeys(Reviewcontent);
		Submitbtn.click();
		
		Resuse.simpleLog("Confirming that Review comment is posted");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(confrimHeading,"Awesome!"));
		
		
		Assert.assertEquals(postConfirmation.getText(), "Your review has been posted.");
		Assert.assertEquals(reviewtxtConfirmation.getText(), Reviewcontent);
		

	}
	
	public void NavigateToHome()
	{
		
		continueBtn.click();
		
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import reusableFunctions.Resuse;


public class testInsurancePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginlnk;
	
	@FindBy(xpath="(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[24]")
	WebElement fourStar; 
	
	@FindBy(xpath="(//*[name()='svg'])[14]")
	WebElement fourStarbtn;	
	
	@FindBy(xpath="//h1")
	WebElement heading;
	
	@FindBy(xpath="//span[contains(text(),'Your Review')]")
	WebElement reviewcommentHeader;
	
	
	@FindBy(xpath="//span[contains(text(),'wallet hubtest')]//ancestor::article//div[@itemprop='description']")
	WebElement commentDescription;
	
	
	public testInsurancePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
	
	public void navigateToLogin(){
		
		Resuse.simpleLog("Clicking on Login...");
		loginlnk.click();	
	}
	
	public void vaildateInsuranceHomePage(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(heading,"Test Insurance Company"));
		
		 
	}
	
	public void rateInsuranceCompany()
	{
		Resuse.simpleLog("4 Star Value Before Hover "+fourStar.getAttribute("fill"));		
		
		Actions action = new Actions(driver);
		action.moveToElement(fourStar).perform();
		
		Resuse.simpleLog("4 Star Value Before Hover "+fourStar.getAttribute("fill"));
		
		
		//value of attribute changes to none when star is filled
		Resuse.simpleLog("Confirming the star is colourful");
		Assert.assertEquals(fourStar.getAttribute("fill"), "none");
		
		fourStarbtn.click();	  
	}
	
	public void checkReview(String comment){
		
		Resuse.simpleLog("Checking comment header");
		Assert.assertEquals(reviewcommentHeader.isDisplayed(), true);  
		
		Resuse.simpleLog("Checking comment description");
		Assert.assertEquals(commentDescription.getText(), comment);
		
		Resuse.simpleLog("The added comment is: "+commentDescription.getText());

	}

}

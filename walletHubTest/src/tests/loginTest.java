package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.loginPage;
import pages.reviewPage;
import pages.testInsurancePage;

public class loginTest {
	
	WebDriver driver;
	
	
	
	String driverPath= "chromedriver.exe";
	
	@BeforeTest
	public void preConditions(){

        System.setProperty("webdriver.chrome.driver", driverPath);        
        driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
        driver.manage().window().maximize();

    }
	
	
	
		
	
	
	@Test
	public void Login()
	{
		testInsurancePage tIp = new testInsurancePage(driver);
		loginPage lp = new loginPage(driver);
		reviewPage rp = new reviewPage(driver);
		
		//Login to wallethub light
		tIp.navigateToLogin();
		lp.accountLogin("wallethubfinal_2@yahoo.com","Automationtest@12");			
		tIp.vaildateInsuranceHomePage(driver);
		tIp.rateInsuranceCompany();
		String comment ="Your health insurance policy provides you with financial assistance at the time of a medical emergency. Health risks and uncertainties are part of life. Hence, it is important you opt for a health insurance plan.";
		rp.addReview(comment);
		rp.NavigateToHome();
		tIp.vaildateInsuranceHomePage(driver);
		tIp.checkReview(comment);
		
		driver.quit();		
		
	}

}

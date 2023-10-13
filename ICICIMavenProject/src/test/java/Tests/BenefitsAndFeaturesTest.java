package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.BenefitsAndFeaturesPage;
import pages.HeaderClass;
import pages.HomePage;

public class BenefitsAndFeaturesTest 
{

	public static void main(String[] args)
	{
		//System.setProperty("webdriver.chrome.driver", "\D:\\PLs_Velocity\\Automation scrnshots\\selenium-server-4.11.0.jar\");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.icicibank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        
        HeaderClass headerClass=new HeaderClass(driver);
        headerClass.clickOnLoan();
        
        HomePage homePage=new HomePage(driver);
        homePage.clickOnBenefitsAndFeatures();
        
        
        BenefitsAndFeaturesPage benefitsAndFeaturesPage=new BenefitsAndFeaturesPage(driver); 
        benefitsAndFeaturesPage.ApplyButtonClick();
	}

}

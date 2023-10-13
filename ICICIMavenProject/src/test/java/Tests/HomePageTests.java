package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HeaderClass;
import pages.HomePage;

public class HomePageTests 
{

	public static void main(String[] args)
	{
		//System.setProperty("webdriver.chrome.driver", "\D:\\PLs_Velocity\\Automation scrnshots\\selenium-server-4.11.0.jar\");
		
		//System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		//System.setProperty("webdriver.chrome.verboseLogging", "true");
		
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.icicibank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        
        HeaderClass headerClass=new HeaderClass(driver);
        headerClass.clickOnLoan();
        
        HomePage homePage=new HomePage(driver);
        homePage.clickOnBenefitsAndFeatures();
        
        

	}

}

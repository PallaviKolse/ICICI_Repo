package TestNg_ICICI;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BenefitsAndFeaturesPage;
import pages.EducationLoanPage;
import pages.HeaderClass;
import pages.HomePage;

public class LoanBenefitsAndFeaturesTest 
{
	private WebDriver driver;
	private HeaderClass headerClass;
	private HomePage homePage;
	private BenefitsAndFeaturesPage benefitsAndFeaturesPage;
	private EducationLoanPage educationLoanPage;
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\\\PLs_Velocity\\\\Automation scrnshots\\\\ChromeDriver.exe");
			driver=new ChromeDriver();
		}
		if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver","D:\\PLs_Velocity\\Automation scrnshots\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
	}
	
	
	@BeforeClass
	public void creatingPOMObjects()
	{
		headerClass=new HeaderClass(driver);
		homePage=new HomePage(driver);
		benefitsAndFeaturesPage=new BenefitsAndFeaturesPage(driver);
		educationLoanPage=new EducationLoanPage(driver);
    }
   @BeforeMethod
	public void openHomePage()
	{
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.get("https://www.icicibank.com/");
        driver.manage().window().maximize();
	}
	@Test
	public void verifyLoanBenefitAndFeature()
	{
		HeaderClass headerClass=new HeaderClass(driver);
        headerClass.clickOnLoan();
        
        HomePage homePage=new HomePage(driver);
        homePage.clickOnBenefitsAndFeatures();
        
        
        String expectedURL="https://www.icicibank.com/personal-banking/loans/education-loan/benefits-and-features";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL,"Sorry!!Navigation failed.");
        
        BenefitsAndFeaturesPage benefitsAndFeaturesPage=new BenefitsAndFeaturesPage(driver); 
        benefitsAndFeaturesPage.ApplyButtonClick();
        
        String pageName=benefitsAndFeaturesPage.CheckPageNameNavigation();
        System.out.println(pageName);
        String expectedPageName="Education Loan Benefits and features at ICICI Bank";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(pageName, expectedPageName);
        
        expectedURL="https://loans.icicibank.com/loans/education-loan/#/verify/EducationLoan/Student-VerifyDetailsPage?ITM=nli_cms_EL_benefitsfeatures_applynowbtn1";
        actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL,"Failed to navigate on Student Details Page!!");
        
        
	}
	@AfterMethod
	public void signOut()
	{
       //logout code
	}
	@AfterClass
	public void exit()
	{
		driver.quit();
		driver=null;
	}
	@AfterTest
	 public void clearObject()
	   {
		   headerClass=null;
		   homePage=null;
		   benefitsAndFeaturesPage=null;
	   }
	
}

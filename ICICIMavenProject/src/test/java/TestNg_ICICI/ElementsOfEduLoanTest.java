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

public class ElementsOfEduLoanTest
{
	private WebDriver driver;
	private HeaderClass headerClass;
	private HomePage homePage;
	private BenefitsAndFeaturesPage benefitsAndFeaturesPage;
	private EducationLoanPage educationLoanPage;
	
	@BeforeTest
	public void launchbrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\PLs_Velocity\\Automation scrnshots\\ChromeDriver.exe");
			driver=new ChromeDriver();
		}
		if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\PLs_Velocity\\Automation scrnshots\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
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
		driver.get("https://www.icicibank.com/");
	    driver.manage().window().maximize();
	}
	@Test
	public void EducationLoanPageFullNameTest()//FirstName,MiddleName,LastName Test
	{
		 
        headerClass.clickOnLoan();
        homePage.clickOnBenefitsAndFeatures();
        benefitsAndFeaturesPage.ApplyButtonClick();
        
          educationLoanPage.FirstNameTextboxTest("Pallavi");
        boolean result=educationLoanPage.FirstNameHiddenMessageTest();
        /*if(result==true)
        	System.out.println("FirstName textfield is blank and respective msg is displayed properly.");
        else
        	System.out.println("Test case fails");*/
        Assert.assertTrue(result, "Firstname is blank and respective message is not displayed");
        
        result=educationLoanPage.FirstNameTextboxAlphabatesOnlyTest("1234*&");
       /* if(result==true)
        	System.out.println("Test case pass bcoz expected msg got displayed");
        else
        	System.out.println("test case fails");*/
        Assert.assertTrue(result, "FirstName textBox accepts numbers & special characters");
              
           educationLoanPage.MiddleNameTextboxTest("Ganesh");
        result=educationLoanPage.MiddleNameTextboxInvalidDataTest("1234*");
        /*if(result==true)
        	System.out.println("testcase pass");
        else
        	System.out.println("testcase fails");*/
        Assert.assertEquals(result, true);
        
        educationLoanPage.LastNameTextboxTest("Kolse");
	   result=educationLoanPage.LastNameTextboxNotNullTest();
	   Assert.assertEquals(result, true);
 
	   result=educationLoanPage.LastNameTextboxAlphabatesOnlyTest("254&58hj");
	   Assert.assertTrue(result);
    }
	@Test(priority=2)
	public void EducationLoanPageDOBTest()//DOB
	{
		
        
        educationLoanPage.DOBTextboxTest("22/09/1990");
        boolean result=educationLoanPage.VerifyValidityOfDOB("74/65/5687");
       /* if(result==true)
        	System.out.println("Expected message is displayed...TestCase pass");
        else
        	System.out.println("TestCase failed!!");*/
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(result);
		
        result=educationLoanPage.VerifyValidityOfDOB_NotNull();
        /*if(result==true)
        	System.out.println("DOB should not be null msg displayed...PASS");
        else
        	System.out.println("Testcase failed.");*/
         softAssert.assertTrue(result);
         softAssert.assertAll();
		
	}
	@Test(priority =3, dependsOnMethods= {"EducationLoanPageFullNameTest"})
	public void EducationLoanPageMobileEmailTest()
	{
		educationLoanPage.mobileTextBoxTest("9865113572");
        
        boolean result=educationLoanPage.mobileTextboxInvalidDataTest("568*&");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(result, "Invalid mobile number message is not displayed.Testcase Failed!!");
        
        result=educationLoanPage.mobileTextboxNotNullTest();
        softAssert.assertEquals(result, true);
        
        educationLoanPage.emailTextboxTest("pallusagale2209@gmail.com");
        result=educationLoanPage.emailTextboxNotNullTest();
        softAssert.assertEquals(result, true);
        
        result=educationLoanPage.emailTextboxInvalidDataTest("456#$%ghfhfjfd");
        softAssert.assertEquals(result, true);
        softAssert.assertAll();
        
	}
	@Test(timeOut =3000)
	public void EducationLoanPageCustomerLocationTest()
	{
	   educationLoanPage.customerLocationTextboxTest();
       boolean result= educationLoanPage.customerLocationTextboxNotNullTest();
       SoftAssert softAssert=new SoftAssert();
       softAssert.assertEquals(result, true);
       
        result=educationLoanPage.customerLocationTextboxInvalidDataTest();
        softAssert.assertEquals(result, true);
        softAssert.assertAll();
        
	}
	/*@Test
	public void EducationLoanPagePANNumberTest()
	{
		
	}*/
	
	
	@AfterMethod
	public void logoutFromApplication()
	{
		//logout code
	}
   @AfterClass
   public void clearObject()
   {
	   headerClass=null;
	   homePage=null;
	   benefitsAndFeaturesPage=null;
   }
   @AfterTest
   public void closeBrowser()
   {
	   driver.quit();
	   driver=null;
   }
}

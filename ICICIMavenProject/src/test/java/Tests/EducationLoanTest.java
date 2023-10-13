package Tests;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.BenefitsAndFeaturesPage;
import pages.EducationLoanPage;
import pages.HeaderClass;
import pages.HomePage;

public class EducationLoanTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", "\D:\\PLs_Velocity\\Automation scrnshots\\selenium-server-4.11.0.jar\");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.icicibank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
        HeaderClass headerClass=new HeaderClass(driver);
        headerClass.clickOnLoan();
        
        HomePage homePage=new HomePage(driver);
        homePage.clickOnBenefitsAndFeatures();
        
        BenefitsAndFeaturesPage benefitsAndFeaturesPage=new BenefitsAndFeaturesPage(driver); 
        benefitsAndFeaturesPage.ApplyButtonClick();
        
        EducationLoanPage educationLoanPage=new EducationLoanPage(driver);
        
        ArrayList<String> address=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(address.get(1));
        
      String result= educationLoanPage.getTopLabel();
       System.out.println(result);
       String expectedText="Enter Student Details And Verify Account";
       if(result.contains(expectedText))
    	   System.out.println("Text displayed is correct.");
       else
    	   System.out.println("Wrong text displayed on screen");
        
       boolean NRIButtonResult= educationLoanPage.NRIButtonTest();
       if(NRIButtonResult==true)
    	   System.out.println("NRIButton is clickable");
       else
    	   System.out.println("NRIButton is  not clickable");
       
       boolean PANToggleResult=educationLoanPage.PANToggleButtonTest();
       if(PANToggleResult==true)
    	   System.out.println("Toggle button is not working");
       else
    	   System.out.println("Toggle button is working");
       
       educationLoanPage.PANNumberTextBoxTest();
       educationLoanPage.firstNameTextboxTest();
       educationLoanPage.MiddleNameTextboxTest();
       educationLoanPage.LastNameTextboxTest();
       educationLoanPage.DOBTextboxTest();
       educationLoanPage.mobileTextboxTest();
       educationLoanPage.customerLocationTextboxTest();
       educationLoanPage.emailTextboxTest();
       educationLoanPage.IAgreeCheckBoxTest();
       educationLoanPage.proceedButtonTest();
       driver.quit();
       
       

	}

}

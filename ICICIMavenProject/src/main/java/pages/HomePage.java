package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	
	@FindBy (xpath=("//a[text()='Benefits & Features']"))
	private WebElement benefitsAndFeatures;
	
	private WebDriver driver;
	
     public HomePage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
    	 this.driver=driver;
     }
     
   
     public void clickOnBenefitsAndFeatures()
     {
    	 Actions actions=new Actions(driver);
    	 actions.moveToElement(benefitsAndFeatures).click();
    	 benefitsAndFeatures.click();
    	
     }
     
}

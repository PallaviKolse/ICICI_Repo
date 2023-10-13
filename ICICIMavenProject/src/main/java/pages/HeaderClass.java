package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderClass 
{
	@FindBy(xpath=("//span[text()='Loans']"))
	private WebElement loan;
	
	private WebDriver driver;
	
	
	public HeaderClass(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	 public void clickOnLoan()
	     {
	    	  Actions actions=new Actions(driver);
	    	 actions.moveToElement(loan).click();
	    	 loan.click();
	 
	     }

}

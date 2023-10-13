package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BenefitsAndFeaturesPage 
{
	@FindBy (xpath=("//a[@id='getCallBackPopup']"))
	private WebElement applyButton;

	private WebDriver driver;
	
	public BenefitsAndFeaturesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void ApplyButtonClick()
	{
		
		applyButton.click();
	}
	public String CheckPageNameNavigation()
	{
		String pageName= driver.getTitle();
		return (pageName);
	}
}

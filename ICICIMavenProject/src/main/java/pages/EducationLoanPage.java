package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EducationLoanPage 
{
  @FindBy (xpath=("//div[contains(text(),'Enter Student Details And Verif')]"))
  private WebElement TopLabel;
  
  @FindBy(xpath=("//label[contains(text(),'Non Resident')]"))
  private WebElement NRIButton;
  
  @FindBy(xpath=("//span[@aria-hidden='true']"))
  private WebElement NRIPopUpCloseButton;
  
  @FindBy(xpath=("(//span[contains(@class,'switch switch-')])[1]"))
  private WebElement PANNumberToggleButton;
  
  @FindBy(xpath=("//input[@id='pan']"))
  private WebElement PanNumberTextbox;
  
  @FindBy(xpath=("//div[text()=' PAN Number must be valid ']"))
  private WebElement PanNumberTextboxValidityHiddenMessage;
  
  
  @FindBy(xpath=("//div[text()=' Pan Number is required ']"))
  private WebElement PanNumberTextboxNotNullHiddenMessage;
  
  @FindBy(xpath=("//input[@id='fname']"))
  private WebElement FirstNameTextbox;
  
  @FindBy(xpath=("//div[text()='Only alphabets are allowed']"))
  private WebElement FirstNameTextboxHiddenMessageForAlphabatesOnly;
  
  @FindBy(xpath=("//div[text()=' First Name is required ']"))
  private WebElement FirstNameTextboxNotBlankHiddenMessage;
  
  @FindBy(xpath=("//input[@id='mname']"))
  private WebElement MiddleNameTextbox;
  
  @FindBy(xpath=("//div[text()='Only alphabets are allowed']"))
  private WebElement MiddleNameTextBoxAlphabatesOnlyMessage;
  
  @FindBy(xpath=("//input[@id='lname']"))
  private WebElement LastNameTextbox;
  
  @FindBy(xpath=("//div[text()=' Last Name is required ']"))
  private WebElement LastNameTextboxHiddenMessage;
  
  @FindBy(xpath=("//div[text()='Only alphabets are allowed']"))
  private WebElement LastNameTextboxAlphabatesOnlyHiddenMessage;
  
  @FindBy(xpath=("//input[@id='dob']"))
  private WebElement DOB;
  
  @FindBy(xpath=("//div[text()=' Please Enter a valid date ']")) 
  private WebElement Valid_DOB_HiddenMessage;
  
  @FindBy(xpath=("//div[text()='Date of Birth is required ']"))
  private WebElement DOB_NotNullHiddenMessage;
  
  @FindBy(xpath=("//input[@id='mobile']"))
  private WebElement mobile;
  
  @FindBy(xpath=("//div[text()=' Mobile number entered is not valid']"))
  private WebElement mobileValidity;
  
  @FindBy(xpath=("//div[text()=' Mobile Number is required ']"))
  private WebElement mobileNotNull;
  
  @FindBy(xpath=("//input[@id='custlocation']"))
  private WebElement customerLocation;
  
  @FindBy(xpath=("//div[text()=' Customer Location is required ']"))
  private WebElement customerLocationNotNull;
  
  @FindBy(xpath=("//div//ul//li//span[text()='No Data Found']"))
  private WebElement customerLocationInvalidMessage;
  
  @FindBy(xpath=("//input[@id='email']"))
  private WebElement email;
  
  @FindBy(xpath=("//div[text()=' Email is required ']"))
  private WebElement emailNotNull;
  
  @FindBy(xpath=("//div[text()=' Email entered is not valid']"))
  private WebElement emailInvalidData;
  
  @FindBy(xpath=("//span[text()=' I agree to the ']"))
  private WebElement IAgreeCheckBox;
  
  @FindBy(xpath=("//button[text()='Proceed']"))
  private WebElement proceedButton;
  
  private WebDriver driver;
  
  public EducationLoanPage(WebDriver driver)
  {
	  PageFactory.initElements( driver,this);
	  this.driver=driver;
  }
  
  public String getTopLabel()
  {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1500));
	  wait.until(ExpectedConditions.visibilityOf(TopLabel));
	  String msg= TopLabel.getText();
	  return msg;
  }
  public boolean IAgreeCheckBoxTest()
  {
	  boolean result=IAgreeCheckBox.isEnabled();
	  return result;
  }
  
  public boolean PANToggleButtonTest()
  {
	  boolean result=PANNumberToggleButton.isSelected();
	  return result;
  }
  
  public boolean NRIButtonTest()
  {
	  NRIButton.click();
	  NRIPopUpCloseButton.click();
	  boolean result=NRIButton.isEnabled();
	  return(result);
  }
  public void PANNumberTextBoxTest(String s) throws InterruptedException
  {
	  PanNumberTextbox.click();
	  PanNumberTextbox.sendKeys("DQPPs1109L");
	  Thread.sleep(1000);
  }
  public boolean PANNumberTextBoxInvalidDataTest(String s) 
  {
	  PanNumberTextbox.clear();
	  PanNumberTextbox.sendKeys("26547#");
	 boolean result=PanNumberTextboxValidityHiddenMessage.isDisplayed();
	 return result;
  }
  public boolean PANNumberNotNullTest () 
  {
	  PanNumberTextbox.clear();
	  PanNumberTextbox.sendKeys("");
	  boolean result=PanNumberTextboxNotNullHiddenMessage.isDisplayed();
	  return result;
	  
  }
   public void FirstNameTextboxTest(String s)
   {
	   FirstNameTextbox.click();
	   FirstNameTextbox.sendKeys(s);
   }
   public boolean FirstNameHiddenMessageTest()
   {
	   FirstNameTextbox.clear();
	   boolean result=FirstNameTextboxNotBlankHiddenMessage.isDisplayed();
	   return result;
   }
   public boolean FirstNameTextboxAlphabatesOnlyTest(String s)
   {
	   FirstNameTextbox.sendKeys(s);
	   boolean result=FirstNameTextboxHiddenMessageForAlphabatesOnly.isDisplayed();
	   return result;
   }
   public void MiddleNameTextboxTest(String s)
   {
	   MiddleNameTextbox.click();
	   MiddleNameTextbox.sendKeys(s);
   }
   public boolean MiddleNameTextboxInvalidDataTest(String s)
   {
	   MiddleNameTextbox.clear();
	   MiddleNameTextbox.sendKeys(s);
	   boolean result=MiddleNameTextBoxAlphabatesOnlyMessage.isDisplayed();
	   return result;
   }
   
   public void LastNameTextboxTest(String s)
   {
	   LastNameTextbox.click();
	   LastNameTextbox.sendKeys(s);
   }
   public boolean LastNameTextboxNotNullTest()
   {
	   LastNameTextbox.clear();
	   LastNameTextbox.sendKeys("");
	   boolean result=LastNameTextboxHiddenMessage.isDisplayed();
		return result;	   
   }
   public boolean LastNameTextboxAlphabatesOnlyTest(String s)
   {
	   LastNameTextbox.clear();
	   LastNameTextbox.sendKeys(s);
	   boolean result=LastNameTextboxAlphabatesOnlyHiddenMessage.isDisplayed();
		return result;	   
   }
   public void DOBTextboxTest(String s)
   {
	   DOB.click();
	   DOB.sendKeys(s);
   }
   public boolean VerifyValidityOfDOB(String s)
   {
	   DOB.clear();
	   DOB.sendKeys(s);
	   boolean result=Valid_DOB_HiddenMessage.isDisplayed();
	   return result;
   }
   public boolean VerifyValidityOfDOB_NotNull()
   {
	   DOB.clear();
	   DOB.sendKeys("");
	   boolean result=DOB_NotNullHiddenMessage.isDisplayed();
	   return result;
   }
	public void mobileTextBoxTest(String s)
	{
		mobile.sendKeys(s);
	}
   public boolean mobileTextboxNotNullTest()
   {
	  mobile.clear();
	  mobile.sendKeys("");
	  boolean result=mobileNotNull.isDisplayed();
	  return result;
   }
   public boolean mobileTextboxInvalidDataTest(String s)
   {
	  mobile.clear();
	  mobile.sendKeys(s);
	  boolean result=mobileValidity.isDisplayed();
	  return result;
	  
   }
   public void customerLocationTextboxTest()
   {
	   
	   JavascriptExecutor _javascriptExecutor=(JavascriptExecutor)driver;
	   _javascriptExecutor.executeScript("arguments[0].value='Ahmednagar'", customerLocation);
	   _javascriptExecutor.executeScript("window.scrollBy(0,500)");
   }
   public boolean customerLocationTextboxNotNullTest()
   {
	   
	   JavascriptExecutor _javascriptExecutor=(JavascriptExecutor)driver;
	   _javascriptExecutor.executeScript("arguments[0].value=''", customerLocation);
	   _javascriptExecutor.executeScript("window.scrollBy(0,500)");
	   boolean result=customerLocationNotNull.isDisplayed();
	   return result;
   }
   public boolean customerLocationTextboxInvalidDataTest()
   {
	   
	   JavascriptExecutor _javascriptExecutor=(JavascriptExecutor)driver;
	   _javascriptExecutor.executeScript("arguments[0].value='652314'", customerLocation);
	   _javascriptExecutor.executeScript("window.scrollBy(0,500)");
	   boolean result=customerLocationInvalidMessage.isDisplayed();
	   return result;
   }
   public void emailTextboxTest(String s)                                                      
   {                                                                                         
                                                                                               
	  email.click();
	  email.sendKeys(s);
   }
   public boolean emailTextboxNotNullTest()                                                     
   {                                                                                        
                                                                                               
	  email.clear();
	  email.sendKeys("");
	  boolean result=emailNotNull.isDisplayed();
	  return result;
   }
   public boolean emailTextboxInvalidDataTest(String s)                                                             
   {                                                                                         
                                                                                               
	  email.clear();
	  email.sendKeys("56874@34");
	  boolean result=emailInvalidData.isDisplayed();//incomplete
	  return result;
   }
    public void proceedButtonTest()
    {
    	proceedButton.click();
    }
   
}

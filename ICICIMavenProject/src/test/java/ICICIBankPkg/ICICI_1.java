package ICICIBankPkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICICI_1 
{

	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.chrome.driver", "\D:\\PLs_Velocity\\Automation scrnshots\\selenium-server-4.11.0.jar\");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.icicibank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

	}

}

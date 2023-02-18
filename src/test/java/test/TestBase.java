package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.homePage;

public class TestBase {
	
	homePage homePageObj;

public static WebDriver driver;
	
	@BeforeClass
	public void startDriver() 
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		
    }
	
	@AfterClass
	public void stopDriver()
	{
		driver.quit();
	}
}

package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.ThreadLocalRandom;

import pages.cartPage;
import pages.homePage;
import pages.registerationPage;
import pages.loginPage;

public class registeration  extends TestBase{

	registerationPage registerationPageObj;
	loginPage loginPageObj;
	homePage homepageObj;
	cartPage cartPageObj;

	String user = "test";
	String sufix = "@test.com";
	int randomNum = ThreadLocalRandom.current().nextInt(1, 100000);
	String email = user+randomNum+sufix;
	String pass = "test1234";
	String firtsName = "Ibrahim";
	String lastName = "Shahin";
	String dateOfBirth= "17";
	String monthOfBirth = "7";
	String yearOfBirth = "1991";
	
	@Test(priority = 1)
	public void Registeration() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		registerationPageObj = new registerationPage(driver);
		wait.until(ExpectedConditions.visibilityOf(registerationPageObj.gender));
		registerationPageObj.clickOnGenderRadioBtn();
		wait.until(ExpectedConditions.visibilityOf(registerationPageObj.firstName));
		registerationPageObj.setPersonalDetails(firtsName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, email); 
		registerationPageObj.setCompanyDetails("test"); 
		registerationPageObj.setPassword(pass); 
		registerationPageObj.setConfirmationPassword(pass);
		registerationPageObj.clickOnRegisterationBtn();
		Assert.assertTrue(registerationPageObj.registerationMessage.getText().equals("Your registration completed"));

	}
	
	@Test(priority = 2)
	public void login() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		loginPageObj = new loginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(loginPageObj.loginIcon));
		loginPageObj.openLoginPage();
		wait.until(ExpectedConditions.visibilityOf(loginPageObj.email));
		loginPageObj.setLoginData(email,pass);
		loginPageObj.clickOnLoginBtn();
		WebElement x=driver.findElement(By.linkText("Books"));

		if(x.isDisplayed() && x.isEnabled())
		{
			x.click();
		}


	}

	@Test(priority = 3)
	public void sortBy()  
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		homepageObj = new homePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homepageObj.pageBody));
		homepageObj.selectSortingType("10");
	}
	
	@Test(priority = 4)
	public void Add()  
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		homepageObj = new homePage(driver);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(homepageObj.itemGrid));
		homepageObj.addToCart();
	}
	
	@Test(priority = 5)
	public void openCartIcon()  
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		homepageObj = new homePage(driver);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(homepageObj.cartIcon));
		homepageObj.openCart();
	}
	
	@Test(priority = 6)
	public void checkout()  
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		cartPageObj = new cartPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(cartPageObj.checkoutBtn));
		cartPageObj.checkTermsBox();
		cartPageObj.pressCheckOut();
	}
}

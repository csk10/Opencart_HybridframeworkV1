package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
		
	public HomePage(WebDriver driver)
	{
		super(driver);    // Invoke the parent class constructor from class BasePage
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkMyRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
 public void clickMyAccount()
 {
	 lnkMyAccount.click();
 }
 
 public void clickMyRegister()
 {
	 lnkMyRegister.click();
 }
 
 public void clickLogin()
 {
	 Login.click();
 }
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);    // Invoke the parent class constructor from class BasePage
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;		
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;	
	
	 public void setEmail(String email)
	 {
		 txtemail.sendKeys(email);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 txtpassword.sendKeys(pwd);
	 }
	 
	 public void clickLogin()
	 {
		 btnLogin.click();
	 }
	
	
}

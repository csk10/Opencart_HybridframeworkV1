package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("*******Starting TC001_AccountRegistrationTest*******");
	try
	{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickMyRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistration rp= new AccountRegistration(driver);
		
		logger.info("Providing Customer details");
		rp.setFirstname("John");
		rp.setLastname("David");
		rp.setEmail(randomString()+"@gmail.com");  //randomly generate email
		rp.setTelephone("231123123");
		rp.setPassword("xyz123456");
		rp.setConfirmPassword("xyz123456");
		
		rp.setPrivacyPolicy();	
		rp.checkbutton();
		
		Thread.sleep(5000);
	  }
	  catch(Exception e)
	  {
		  logger.error("Test failed.....");
		  //logger.debug("Debug logs....");
		  Assert.fail();
	  }
	 
	logger.info("*******Finished TC001_AccountRegistrationTest*******");
	}
	
	
}

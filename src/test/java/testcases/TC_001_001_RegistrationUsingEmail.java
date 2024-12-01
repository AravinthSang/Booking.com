package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.CreatePassword;
import pageObjectModel.Homepage;
import pageObjectModel.SignInOrCreateAcc;
import testBase.TestBase;

public class TC_001_001_RegistrationUsingEmail extends TestBase {
	@Test(groups= {"master","functional"})

	public void validateRegistationWithEmail() {
		
		Homepage homepage=new Homepage(driver);
		SignInOrCreateAcc signInOrCreateAcc=new SignInOrCreateAcc(driver);
		CreatePassword createPassword=new CreatePassword(driver);
		
		homepage.ClickOnbtnRegister();
		signInOrCreateAcc.SendToTxtEmailInsert(properties.getProperty("email"));
		signInOrCreateAcc.ClickBtnContinueWIthEmail();
		createPassword.sendToTxtPasswordInsert(properties.getProperty("password"));
		createPassword.sendToTxtConfirmPasswordInsert(properties.getProperty("password"));
		createPassword.clickOnBtnCreateAccount();
		
		Assert.assertTrue(homepage.isYourAccountNotNull());//Expecting yourAccount button not to be null
	}
}

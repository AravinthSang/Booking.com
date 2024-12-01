package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.CreatePassword;
import pageObjectModel.Homepage;
import pageObjectModel.SignInOrCreateAcc;
import testBase.TestBase;

import utilities.DataProviders;

public class TC_001_001_RegistrationUsingEmailDDT extends TestBase {
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups= {"master","dataDriven"})
	public void validateRegistationWithEmail(String email,String password,String confirmPassword,String flag) {
		try {
		Homepage homepage = new Homepage(driver);
		SignInOrCreateAcc signInOrCreateAcc = new SignInOrCreateAcc(driver);
		CreatePassword createPassword = new CreatePassword(driver);
		
		homepage.ClickOnbtnRegister();
		signInOrCreateAcc.SendToTxtEmailInsert(email);
		
		signInOrCreateAcc.ClickBtnContinueWIthEmail();
		createPassword.sendToTxtPasswordInsert(password);
		createPassword.sendToTxtConfirmPasswordInsert(confirmPassword);
		createPassword.clickOnBtnCreateAccount();
		if(flag.equalsIgnoreCase("valid"))
			Assert.assertTrue(homepage.isYourAccountNotNull());// Expecting yourAccount button not to be null
		else
			Assert.assertFalse(homepage.isYourAccountNotNull());// Expecting yourAccount button to be null for invalid credentials
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		}

}

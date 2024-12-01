package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.SignInOrCreateAcc;
import testBase.TestBase;

public class TC_002_008_LoginFuntionality extends TestBase {

	@Test(groups= {"master","functional"})
	public void validLogin() {
		
		Homepage homepage=new Homepage(driver);
		SignInOrCreateAcc loginPage=new SignInOrCreateAcc(driver);
		
		homepage.ClickOnBtnSignin();
		loginPage.SendToTxtEmailInsert(properties.getProperty("validEmail"));
		loginPage.sendToTxtPassword(properties.getProperty("validPassword"));
		loginPage.clickBtnLogin();
		Assert.assertTrue(homepage.isYourAccountNotNull());//Expecting yourAccount button not to be null
		
	}
}

package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.Homepage;
import pageObjectModel.PersonalDetails;
import pageObjectModel.YourAccount;
import testBase.TestBase;

public class TC_003_013_AccountUpdationFunctionality extends TestBase {

	@Test(groups= {"master","functional"})
	public void validAccountUpdadation() {
		
		SoftAssert softAssert=new SoftAssert();
		Homepage homepage=new Homepage(driver);
		homepage.ClickOnbtnYourAccount();
		homepage.clickOnBtnMyAccount();
		
		YourAccount yourAcc=new YourAccount(driver);
		yourAcc.clickOnBtnPersonalDetails();
		//updating firstName and LastName
		PersonalDetails personalDetails=new PersonalDetails(driver);
		String firstName=properties.getProperty("firstName");
		String lastName=properties.getProperty("lastName");
		personalDetails.clickOnBtnEditName();
		personalDetails.sendTextToTxtFirstName(firstName);
		personalDetails.sendTextToTxtLastName(lastName);
		personalDetails.clickOnBtnSaveName();
		String expectedName=firstName+" "+lastName;
		String actualName=personalDetails.getName(expectedName);
		softAssert.assertEquals(actualName, expectedName);
		
		//updating display Name
		String displayName=properties.getProperty("displayName");
		personalDetails.clickOnBtnEditDisplayName();
		personalDetails.sendTextToTxtDisplayName(displayName);
		personalDetails.clickOnBtnSaveDisplay();
		softAssert.assertEquals(displayName, personalDetails.getDisplayName());
		
		//updating DOB
		String date=properties.getProperty("date");
		String month=properties.getProperty("month");
		String year=properties.getProperty("year");
		personalDetails.clickOnEditDOB();
		personalDetails.sendTextToDate(date);
		personalDetails.selectMonth(month);
		personalDetails.sendTextToYear(year);
		String expectedDate=date+"/"+month+"/"+year;
		String actualDate=personalDetails.getDob();
		softAssert.assertEquals(true, actualDate.contains(expectedDate));
		
		//updating nationality
		String nationality=properties.getProperty("nationality");
		personalDetails.clickOnBtnEditNationality();
		personalDetails.selectNationality(nationality);
		personalDetails.clickOnBtnSaveNationality();
		String actualNation=personalDetails.getNationality();
		softAssert.assertEquals(nationality,actualNation );
		
		
		
		
	}
}

package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccount extends BasePageModel{

	public YourAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//body/div[1]")WebElement btnPersonalDetails;

	public void clickOnBtnPersonalDetails() {
		btnPersonalDetails.click();
	}

}

package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePassword extends BasePageModel {

	public CreatePassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='new_password']")WebElement txtPassword;	
	@FindBy(xpath="//input[@id='new_password']")WebElement txtConfirmPassword;
	@FindBy(xpath="//button[@type='submit']")WebElement btnCreateAccount;
	
	public void sendToTxtPasswordInsert(String password) {
		txtPassword.sendKeys(password);
	}
	public void sendToTxtConfirmPasswordInsert(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	public void clickOnBtnCreateAccount() {
		btnCreateAccount.click();
	}
	
	
}

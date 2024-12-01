package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInOrCreateAcc extends BasePageModel{

	public SignInOrCreateAcc(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='username']")WebElement txtEmail;
	@FindBy(xpath="//button[@type='submit']")WebElement btnContinueWithEmail;
	@FindBy(xpath="//input[@id='password']")WebElement txtPassword;
	@FindBy(xpath="//input[@id='login']")WebElement btnLogin;
	public void SendToTxtEmailInsert(String email) {
		txtEmail.sendKeys(email);
	}
	public void ClickBtnContinueWIthEmail() {
		btnContinueWithEmail.click();
		
	}
	public void sendToTxtPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickBtnLogin() {
		btnLogin.click();
	}
	
}

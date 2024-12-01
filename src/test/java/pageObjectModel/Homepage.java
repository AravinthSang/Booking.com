package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage extends BasePageModel {
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[@aria-label='Create an account']")WebElement btnRegister;
	@FindBy(xpath="//span[normalize-space()='Sign in']")WebElement btnSignin;
	@FindBy(xpath="//div[@aria-label='Your account menu Account & info Genius Level 1']")WebElement btnYourAccount;
	@FindBy(xpath="//div[@id=':rf:']//li[1]//a[1]")WebElement btnMyAccount;
	
	public void ClickOnbtnRegister() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnRegister)).click();;
	}
	public void ClickOnBtnSignin() {
		btnSignin.click();
	}
	
	public void ClickOnbtnYourAccount() {
		btnYourAccount.click();
	}
	public boolean isYourAccountNotNull() {
		if(btnYourAccount != null)
			return true;
		else
			return false;
	}
	public void clickOnBtnMyAccount() {
		btnMyAccount.click();
	}
}

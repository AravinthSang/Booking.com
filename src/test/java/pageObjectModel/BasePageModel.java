package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageModel {

	public WebDriver driver;
	BasePageModel(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}

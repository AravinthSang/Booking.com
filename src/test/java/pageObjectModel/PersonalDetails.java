package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetails extends BasePageModel {

	private WebElement txtFirstName;
	private WebElement txtLastName;
	private WebElement btnSaveName;
	private WebElement name;

	// for display Name
	private WebElement txtDisplayName;
	private WebElement btnSaveDisplayName;
	private WebElement divDisplayName;

	// for dateOfBirth
	@FindBy(xpath = "//div[@data-test-id='mysettings-row-dateOfBirth']//span[@class='mVStVB15gUUbYLdUJFnM'][normalize-space()='Edit']")
	WebElement btnEditDOB;
	private WebElement txtDate;
	private WebElement dropdownMonth;
	private WebElement txtYear;
	private WebElement btnSaveDob;
	private WebElement divDob;

	// for Nationality
	@FindBy(xpath="//div[@data-test-id='mysettings-row-nationality']//span[@class='mVStVB15gUUbYLdUJFnM'][normalize-space()='Edit']")WebElement btnEditNationality;
	private WebElement dropdownNationality;
	private WebElement btnSaveNationality;
	private WebElement divNationality;
	
	// for Gender
	@FindBy(xpath="//div[@data-test-id='mysettings-row-gender']//span[@class='mVStVB15gUUbYLdUJFnM'][normalize-space()='Edit']")WebElement btnEditGender;
	private WebElement dropdownGender;
	private WebElement btnSaveGender;
	
	//for address
	@FindBy(xpath="//div[@data-test-id='mysettings-row-address']//span[@class='mVStVB15gUUbYLdUJFnM'][normalize-space()='Edit']")WebElement btnEditAddress;
	private WebElement dropdownRegion;
	private WebElement txtAddress;
	private WebElement txtCity;
	private WebElement txtPostalCode;
	private WebElement btnSaveAddress;
	
	public void clickonEditAddress() {
		btnEditAddress.click();
		dropdownRegion=driver.findElement(By.name("country"));
		txtAddress=driver.findElement(By.name("line1"));
		txtCity=driver.findElement(By.name("city"));
		txtPostalCode=driver.findElement(By.name("zip"));
		btnSaveAddress=driver.findElement(By.xpath("//span[normalize-space()='Save']"));
	}
	public void selectRegion(String region) {
		Select select=new Select(dropdownRegion);
		select.selectByValue(region);
	}
	public void sendTxtToAddress(String address) {
		txtAddress.sendKeys(address);
		
	}
	public void sendTxtToCity(String city) {
		txtCity.sendKeys(city);
	}
	public void sendTxtToPostalCode(String zip) {
		txtPostalCode.sendKeys(zip);
		
	}
	public void clickonBtnSaveAddress() {
		btnSaveAddress.click();
	}
	public void clickOnBtnEditGender() {
		btnEditGender.click();
		dropdownNationality=driver.findElement(By.name("gender"));
		btnSaveGender=driver.findElement(By.xpath("//button[@type='submit']"));
		
	}
	public void selectGender(String gender) {
		Select genderSelect=new Select(dropdownGender);
		genderSelect.selectByValue(gender);
		btnSaveGender.click();
		
	}
	public void clickOnBtnEditNationality() {
		btnEditNationality.click();
		dropdownNationality=driver.findElement(By.xpath("//select[@name='nationality']"));
		btnSaveNationality=driver.findElement(By.xpath("//span[normalize-space()='Save']"));
	}
	public void selectNationality(String nation) {
		Select nationSelect=new Select(dropdownNationality);
		nationSelect.selectByValue(nation);
	}
	public void clickOnBtnSaveNationality() {
		btnSaveNationality.click();
	}
	public String getNationality() {
		divNationality=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id=\"mysettings-row-nationality\"]/div/div[2]/div/div/div/div[2]/div/div/div/div")));
		return divNationality.getText();
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public PersonalDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@data-test-id='mysettings-row-name']//button[@type='button']")
	WebElement btnEditName;
	@FindBy(xpath = "//div[@data-test-id='mysettings-row-nickname']//button[@type='button']")
	WebElement btnEditDisplayName;

	
	public void clickOnBtnEditName() {
		btnEditName.click();

		txtFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first']")));
		txtLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='last']")));

		btnSaveName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@type='submit' and @data-ga-label='Save section: name']")));

	}

	public void sendTextToTxtFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void sendTextToTxtLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void clickOnBtnSaveName() {
		btnSaveName.click();
	}

	public String getName(String name) {
		this.name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='cd41c7f0-bde4-4f00-8b5d-3aba6909071b_content']//div[contains(text(),'" + name + "')]")));
		return this.name.getText();
	}

	public void clickOnBtnEditDisplayName() {
		btnEditDisplayName.click();
		txtDisplayName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@data-test-id='mysettings-row-nickname']//button[@type='button']")));
		btnSaveDisplayName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Save']")));
	}

	public void sendTextToTxtDisplayName(String name) {
		txtDisplayName.sendKeys(name);
	}

	public String getDisplayName() {
		divDisplayName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@data-test-id=\"mysettings-row-nickname\"]/div/div[2]/div/div/div/div[2]/div/div/div/div")));
		return divDisplayName.getText();
	}
	public void clickOnBtnSaveDisplay()
	{
		btnSaveDisplayName.click();
	}
	
	public void clickOnEditDOB() {
		btnEditDOB.click();
		txtDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("dateOfBirth__day")));
		dropdownMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("dateOfBirth__month")));
		txtYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("dateOfBirth__year")));
		btnSaveDob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Save']")));
		divDob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id=\"mysettings-row-dateOfBirth\"]/div/div[2]/div/div/div/div[2]/div/div/div")));
		
	}

	public void sendTextToDate(String date) {
		txtDate.sendKeys(date);

	}

	public void sendTextToYear(String year) {
		txtYear.sendKeys(year);
	}
	public void selectMonth(String month) {
		Select dob=new Select(dropdownMonth);
		dob.selectByVisibleText(month);
	}
	public void clickOnBtnSaveDob() {
		btnSaveDob.click();
	}
	public String getDob() {
		return divDob.getText();
	}
}

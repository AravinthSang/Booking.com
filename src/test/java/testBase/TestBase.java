package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;
	public Properties properties;
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(String browser) throws IOException {

		switch (browser.toLowerCase()) {
		case "edge":
			driver = new EdgeDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		}
		FileReader file=new FileReader("./src/test/resources/config.properties");
		properties=new Properties();
		properties.load(file);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public  String captureScreenshot(String testName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String screenshotName="";
		// Call method to capture screenshot
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		try {
			Date d = new Date();
			screenshotName =testName+d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\screenshots\\" + screenshotName));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return screenshotName;
	}
}

package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.TestBase;

public class ExtentReportUtility implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;
	String reportName;

	public void onStart(ITestContext context) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String timestamp = df.format(date);

		reportName = "TestReport-" + timestamp + ".html";
		sparkReporter = new ExtentSparkReporter("./reports/" + reportName);
		sparkReporter.config().setDocumentTitle("Booking.com");
		sparkReporter.config().setReportName("Booking.com Functional testing report");
		sparkReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Application", "Booking.com");
		report.setSystemInfo("User", System.getProperty("user.name"));
		report.setSystemInfo("Environment", "QA");

		// getting data from testxml
		report.setSystemInfo("os", context.getCurrentXmlTest().getParameter("os"));
		List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
		if (!groups.isEmpty())
			report.setSystemInfo("Group", groups.toString());
	}

	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + " successfully exexuted");
	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " failed");
		
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgPath = new TestBase().captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {

		report.flush();
	}

}

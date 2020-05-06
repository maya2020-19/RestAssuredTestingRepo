package com.user.utilities1;
	import org.testng.ITestContext;
	import org.testng.ITestResult;
	import org.testng.TestListenerAdapter;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class Listeners1 extends TestListenerAdapter {

		public ExtentHtmlReporter htmlreporter;
		public ExtentReports extent;
		public ExtentTest test;

		public void onStart(ITestContext testcontext) {
			htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/myReport.html");
			htmlreporter.config().setDocumentTitle("Automation Report");
			htmlreporter.config().setReportName("Automation Testing");
			htmlreporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("Host name", "localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User", "Admin");
		}

		public void onTestSuccess(ITestResult result) {

			test = extent.createTest(result.getName());
			test.log(Status.PASS, "Testcase passed is -- " + result.getName());

		}

		public void onTestFailure(ITestResult result) {
			test = extent.createTest(result.getName());
			test.log(Status.FAIL, "Testcase Failed is --" + result.getName());
			test.log(Status.FAIL, "Testcase Failed is --" + result.getThrowable());

		}

		public void onTestSkipped(ITestResult result) {
			test = extent.createTest(result.getName());
			test.log(Status.SKIP, "Testcase Skipped is --" + result.getName());
		}

		public void onFinish(ITestContext testcontext) {
			extent.flush();
		}
	}

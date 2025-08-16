package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtetReports implements ITestListener{
	
	WebDriver driver;
    ExtentReports reports;
    ExtentTest test;
    
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"Is Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"Is Failed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/fail.png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Is Skipped");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
	Date d=new Date();
    System.out.println(d);
    
    String date = d.toString().replace(" ", "-").replace("::", "-");
    
    ExtentSparkReporter htmlreport=new ExtentSparkReporter(new File("extentreport.html"));
    htmlreport.config().setDocumentTitle("Extent Report");
    htmlreport.config().setTheme(Theme.DARK);
    
    reports=new ExtentReports();
    reports.attachReporter(htmlreport);
    reports.setSystemInfo("OS", "WINDOWS 10");
    reports.setSystemInfo("Environment: ", "Testing Environment ");
    reports.setSystemInfo("URL ", "www.vtiger.com");
    reports.setSystemInfo("Repoeter Name", "Sameer");
	
	}

	public void onFinish(ITestContext context) {
	reports.flush();
	}

}

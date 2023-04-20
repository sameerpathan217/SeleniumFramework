package Generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import POM.LoginPage;
import POM.OrgHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	@BeforeSuite(groups= {"smoketest","regessiontest","sanitytest"})
	public void BS() {
		System.out.println("Database Connection");
	}
	@BeforeTest(groups= {"smoketest","regessiontest","sanitytest"})
	public void BT() {
		System.out.println("Parrelel Execution");
	}
	
	
	//@Parameters("BrowserName")
	@BeforeClass(groups= {"smoketest","regessiontest","sanitytest"})
	//public void BC(String BrowserName) throws IOException {
	public void BC() throws IOException {
		
		Prperty_Utility pu1=new Prperty_Utility();
		String BrowserName = pu1.getKeyValue("Browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		System.out.println("Lauuch The Browser");
		sdriver=driver;
	}
	
	
	@BeforeMethod(groups= {"smoketest","regessiontest","sanitytest"})
	public void BM() throws IOException {
		Prperty_Utility pu=new Prperty_Utility();
		String URL = pu.getKeyValue("url1");
	     String user = pu.getKeyValue("username1");
		String pass = pu.getKeyValue("passward1");

		driver.get(URL);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(user, pass);
		System.out.println("Log In Application");
	}
	
	
	@AfterMethod(groups= {"smoketest","regessiontest","sanitytest"})
	public void AM() {
		OrgHomePage homePage=new OrgHomePage(driver);
		homePage.SignOutLink(driver);
		System.out.println("Log Out Application");
	}
	
	
	@AfterClass(groups= {"smoketest","regessiontest","sanitytest"})
	public void AC() {
		driver.close();
		System.out.println("Close The Browser");
	}
	
	@AfterTest(groups= {"smoketest","regessiontest","sanitytest"})
	public void AT() {
		System.out.println("Parrelel Execution Close");
	}
	
	
	@AfterSuite(groups= {"smoketest","regessiontest","sanitytest"})
	public void AS() {
		System.out.println("Database Connection Close");
	}
}

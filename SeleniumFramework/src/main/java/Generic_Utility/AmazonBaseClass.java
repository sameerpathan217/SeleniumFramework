package Generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBaseClass {
	public WebDriver driver;
	
	@BeforeSuite
	public void BS() {
		System.out.println("Database Connection");
	}
	@BeforeClass
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
		
	}
    @BeforeMethod
    public void BM() throws IOException {
		Prperty_Utility pu=new Prperty_Utility();
		String URL = pu.getKeyValue("amzonUrl");
		driver.get(URL);
    }
}

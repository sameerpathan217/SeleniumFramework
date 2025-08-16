
package Campaigns;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BasClass;
import Generic_Utility.Exel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Prperty_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrgHomePage;
import POM.OrgnasationPageAction;
import POM.ProductPageAction;
import POM.ValidationAndVerification;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProdTest extends BasClass{
	
	@Test(groups= {"smoketest"})
	public void CreateCampWithProd()  throws IOException {
	//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	//WebDriver driver=new ChromeDriver();
		
		/*	Prperty_Utility pu1=new Prperty_Utility();
		String BrowserName = pu1.getKeyValue("Browser");
		
		WebDriver driver = null;
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
		*/
		
		
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Webdriver_Utility wu=new Webdriver_Utility();
	wu.implicitWait(driver);
	
	//Prperty_Utility pu=new Prperty_Utility();
	//String url = pu.getKeyValue("vTiger");
	//String username = pu.getKeyValue("user");
	//String password = pu.getKeyValue("pass");
	//driver.get(url);
	//driver.findElement(By.name("user_name")).sendKeys(username);
	//driver.findElement(By.name("user_password")).sendKeys(password);
	//driver.findElement(By.id("submitButton")).click();
	
	//LoginPage lp=new LoginPage(driver);
	//lp.LoginApp(username, password);
	
	OrgHomePage ohg=new OrgHomePage(driver);
	ohg.ClickOnProduct();
	
	//driver.findElement(By.xpath("//a[text()='Products']")).click();
	
	//OrgnasationPageAction opa=new OrgnasationPageAction(driver);
	ProductPageAction ppa=new ProductPageAction(driver);
	ppa.ClickOnPlusBtn();
	//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	Java_Utility ju=new Java_Utility();
	int ran = ju.getRanNum();
	
	Exel_Utility eu=new Exel_Utility();
	String Value = eu.ExcelDta("Product1", 0, 0)+ran;
	
	//driver.findElement(By.name("productname")).sendKeys(Value);
	ppa.SendExcelDta(Value);
	ppa.saveData();
	//driver.findElement(By.name("button")).click();
	//driver.findElement(By.xpath("//a[text()='More']")).click();
	//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
	//FindBy OrgHomePage
	ohg.ClickOnMore();
	ohg.ClickOnCampaign();
	
	//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	HomePage hp=new HomePage(driver);
	hp.campaigns();
	hp.campDta(Value);
    //driver.findElement(By.name("campaignname")).sendKeys(Value);
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	
	wu.switchToWindow(driver, "Products&action");
	/*Set<String> allId = driver.getWindowHandles();
	Iterator<String> it = allId.iterator();
	while(it.hasNext()) {
		String wid = it.next();
		driver.switchTo().window(wid);
		String title = driver.getTitle();
		if(title.contains("Products&action")) {
			break;
		}
	}*/
	driver.findElement(By.id("search_txt")).sendKeys(Value);
	driver.findElement(By.name("search")).click();
//	ppa.searchData(Value);
	
	driver.findElement(By.xpath("//a[text()='"+Value+"']")).click();
/*	Set<String> win = driver.getWindowHandles();
	Iterator<String> NO = win.iterator();
	if(NO.hasNext()) {
		String NO1 = NO.next();
		driver.switchTo().window(NO1);
		String title = driver.getTitle();
		System.out.println(title);
	
		if(title.contains("Products&action")) {
			break;
		}
	}*/
	wu.switchToWindow(driver, "Campaigns&action");
	
	OrgnasationPageAction campdatasave=new OrgnasationPageAction(driver);
	campdatasave.saveBtn();
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	/*String data = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	System.out.println(data);
	
	if(data.contains(Value)) {
		System.out.println(" Camp Data Pass");
	}else {
		System.out.println(" Camp Data Fail");
	}*/
	ValidationAndVerification vav=new ValidationAndVerification(driver);
	vav.CampaignDataValidation(driver, Value);
	
	/*String pdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	
	if(pdata.contains(Value)) {
		System.out.println("Pass Data");
	}else {
		System.out.println("Data Fail");
	}*/
	
	vav.ProductDataValidation(driver, Value);

   }
  }
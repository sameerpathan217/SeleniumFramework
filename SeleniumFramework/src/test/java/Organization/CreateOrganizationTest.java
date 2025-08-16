package Organization;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BasClass;
import Generic_Utility.Exel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.OrgHomePage;
import POM.OrgnasationPageAction;
import POM.ValidationAndVerification;
//@Listeners(Generic_Utility.ListnerClass.class)
public class CreateOrganizationTest extends BasClass{
	
	@Test(retryAnalyzer=Generic_Utility.RetryExample.class)
	//@Test(groups= {"smoketest","regessiontest"})
	public void CreateOrganization()  throws Throwable {
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.implicitWait(driver);
		
		
		                                               
		///Prperty_Utility pu=new Prperty_Utility();
		//String URL = pu.getKeyValue("url1");
	   //  String user = pu.getKeyValue("username1");
	//	String pass = pu.getKeyValue("passward1");
		
	//	driver.get(URL);
		
		
		//LoginPage lp=new LoginPage(driver);
	//	lp.LoginApp(user, pass);
		
		OrgHomePage homePage=new OrgHomePage(driver);
		homePage.ClickOgnasation();
		//Assert.assertEquals(false, true);
		
		
		OrgnasationPageAction opa=new OrgnasationPageAction(driver);
		opa.ClickOnPlusBtn();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Java_Utility ju=new Java_Utility();
		int genric = ju.getRanNum();
		
		Exel_Utility eu1=new Exel_Utility();
		String dataformat = eu1.getExcelDataFormatter("Sheet1", 0, 0)+genric;
		
		Exel_Utility eu=new Exel_Utility();
		String VALUE = eu.ExcelDta("Sheet1", 0, 0)+genric;
		
		
	//	driver.findElement(By.name("accountname")).sendKeys(dataformat);
		opa.SendExcelData(dataformat);
		opa.saveBtn();
		//driver.findElement(By.name("button")).click();
		
		//Validation 
	/*	String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains(VALUE)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}*/
		
		ValidationAndVerification validation=new ValidationAndVerification(driver);
		 String data = validation.OrgnasationDataValidation(driver, VALUE);
		Thread.sleep(4000);
	
		//homePage.SignOutLink(driver);
		AssertJUnit.assertEquals(data, VALUE);

	}

}

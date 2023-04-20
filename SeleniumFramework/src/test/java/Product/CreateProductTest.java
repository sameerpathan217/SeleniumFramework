package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import POM.OrgHomePage;
import POM.ProductPageAction;
import POM.ValidationAndVerification;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BasClass {

	@Test(groups= {"sanitytest"})
	public void CreateProduct()throws IOException, InterruptedException {
	
		Prperty_Utility pu=new Prperty_Utility();
	
		
		
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.implicitWait(driver);
		
	/*	FileInputStream f=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		
		Properties ps=new Properties();
		ps.load(f);
		
		String Url = ps.getProperty("vTiger");
		String user = ps.getProperty("user");
		String pass = ps.getProperty("pass");*/
		
		//Prperty_Utility pu=new Prperty_Utility();
	//	  String Url = pu.getKeyValue("vTiger");
	//	String user = pu.getKeyValue("user");
	//	String pass = pu.getKeyValue("pass");
		
	//	driver.get(Url);
	//	driver.findElement(By.name("user_name")).sendKeys(user);
	//	driver.findElement(By.name("user_password")).sendKeys(pass);
	//	driver.findElement(By.id("submitButton")).click();
		
		OrgHomePage ohp=new OrgHomePage(driver);
		ohp.ClickOnProduct();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		ProductPageAction ppa=new ProductPageAction(driver);
		ppa.ClickOnPlusBtn();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Random r=new Random();
		//int ran = r.nextInt(1000);
		Java_Utility ju=new Java_Utility();
		int genric = ju.getRanNum();
		
	
		Exel_Utility eu=new Exel_Utility();
		String value = eu.ExcelDta("ProductSheet", 0, 0)+genric;
		
	//driver.findElement(By.name("productname")).sendKeys(value);
	//driver.findElement(By.name("button")).click();
		ppa.SendExcelDta(value);
		ppa.saveData();
	
		
	
	//Validation 
	//String text = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	
	
	//driver.findElement(By.name("Delete")).click();
	
//	Alert al=driver.switchTo().alert();
	//al.accept();
	
	
//	if(text.contains(value)) {
//		System.out.println("Data Add Succesfully");
//	}else {
//	System.out.println("Not Deleted");
//	}
		ValidationAndVerification vav=new ValidationAndVerification(driver);
		vav.ProductDataVerify(driver, value);
	Thread.sleep(4000);
	
		

	}

}

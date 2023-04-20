package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BasClass;
import Generic_Utility.Exel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Prperty_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.OrgHomePage;
import POM.ProductPageAction;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndDeleteProducTestt extends BasClass {
	
	@Test(groups= {"sanitytest"})
public void CreateAndDeleteProduct()throws IOException {
	//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	//WebDriver driver=new ChromeDriver();
	Prperty_Utility pu=new Prperty_Utility();
/*	WebDriver driver = null;
	Prperty_Utility pu=new Prperty_Utility();
	String BrowserName = pu.getKeyValue("Browser");
	
	if(BrowserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BrowserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}else {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	*/
	
	
	
	
	/*FileInputStream fs=new FileInputStream("./src/test/resources/PropertyFileData.properties");
	Properties ps=new Properties();
	ps.load(fs);
	String URL = ps.getProperty("url1");
	String USER = ps.getProperty("username1");
	String PASS = ps.getProperty("passward1");
	
	String URL = pu.getKeyValue("url1");
	String USER = pu.getKeyValue("username1");
	String PASS = pu.getKeyValue("passward1");
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USER);
	driver.findElement(By.name("user_password")).sendKeys(PASS);
	driver.findElement(By.id("submitButton")).click();*/
	
	OrgHomePage home=new OrgHomePage(driver);
	home.ClickOnProduct();
	
	//driver.findElement(By.xpath("//a[text()='Products']")).click();
	ProductPageAction ppa=new ProductPageAction(driver);
	ppa.ClickOnPlusBtn();		   
	//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	//Random r=new Random();
	//int ran = r.nextInt();
	Java_Utility ju=new Java_Utility();
	int ran = ju.getRanNum();
	
	
/*	FileInputStream fis=new FileInputStream("./src/test/resources/vTiger.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheetName = book.getSheet("Product");
	    Row row = sheetName.getRow(2);
	    Cell cell = row.getCell(1);
	    String Value = cell.getStringCellValue()+ran;
	  */
			
			Exel_Utility eu=new Exel_Utility();
	String Value = eu.DataFormatter1("Product1", 0, 0)+ran;
	
	
	 // driver.findElement(By.name("productname")).sendKeys(Value);	 
	   ppa.SendExcelDta(Value);
	   ppa.saveData();
	   // driver.findElement(By.name("button")).click();
	    
	   // driver.findElement(By.linkText("Products")).click();
	   home.ClickOnProduct();
		 // driver.findElement(By.xpath("//a[text()='"+Value+ "']/../../td/a[text()='del']")).click();
	   driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>=1]")).click();
	    driver.findElement(By.xpath("//input[@value='Delete']")).click();
		  
		//  Alert al=driver.switchTo().alert();
		  //al.accept();
		  Webdriver_Utility wu=new Webdriver_Utility();
		  wu.alertAccept(driver);
		  
		  boolean flag=false;
		  OrgHomePage ohp=new OrgHomePage(driver);
		  ohp.ClickOnProduct();
			//driver.findElement(By.linkText("Products")).click();
			 List<WebElement> data = driver.findElements(By.xpath("//a[@title='Products']"));
			 
			for(WebElement we:data)
			{
				String prod_data = we.getText();
				if(prod_data.equals(Value))
				{
					flag=true;
					break;
				}
				
			}
			if(flag)
			{
				System.out.println("Product data not deleted");
			}
			else
			{
				System.out.println("Product data deleted successfully");
			}
			
		//	home.SignOutLink(driver);
	  //  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	  //  Actions act=new Actions(driver);
	  //  driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	   
	
	
}

}

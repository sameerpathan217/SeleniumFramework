package Campaigns;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BasClass;
import Generic_Utility.Exel_Utility;
import Generic_Utility.Prperty_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrgHomePage;
import POM.OrgnasationPageAction;

public class CreateCampaignsTest extends  BasClass  {
	@Test(groups= {"smoketest"})
	public void CreateCampaignsTest() throws IOException {
		
	
		HomePage hp=new HomePage(driver);
		hp.campaigns();
		OrgHomePage ohp=new OrgHomePage(driver);
		Exel_Utility eu=new Exel_Utility();
		String Value = eu.DataFormatter1("Sheet1", 0, 0);
		hp.campDta(Value);
		OrgnasationPageAction opa=new OrgnasationPageAction(driver);
		opa.saveBtn();
		
	}
	

}

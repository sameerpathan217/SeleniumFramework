package POM;

import java.util.List;

import org.apache.poi.util.IntList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification {
	
	public ValidationAndVerification(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement OrgnasationData;
	
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
     private WebElement datacompare;
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement prodDataCompare;
	
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement ProductData;
	
  

	


	public WebElement getDatacompare() {
		return datacompare;
	}


	public WebElement getOrgnasationData() {
		return OrgnasationData;
	} 
	public WebElement getProdDataCompare() {
		return prodDataCompare;
	}
	
	public WebElement getProductData() {
		return ProductData;
	}


	
	

	public String OrgnasationDataValidation(WebDriver driver, String data) {
		String actData=OrgnasationData.getText();
		if(actData.contains(data)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		return actData;
	}
	public void CampaignDataValidation(WebDriver driver, String data) {
		String name = datacompare.getText();
		if(data.contains(name)) {
			System.out.println(" Camp Data Pass");
		}else {
			System.out.println(" Camp Data Fail");
		}
		
	} 
	
	public void ProductDataValidation(WebDriver driver, String prodata) {
		String pdata = prodDataCompare.getText();
		
		if(prodata.contains(pdata)) {
			System.out.println("Pass Data");
		}else {
			System.out.println("Data Fail");
		}
	}
	

	public void ProductDataVerify(WebDriver driver, String prodata) {
		String text = ProductData.getText();
		if(text.contains(prodata)) {
			System.out.println("Data Add Succesfully");
		}else {
			System.out.println("Data Not Deleted");
		}
	}
	
	
}

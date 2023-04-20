package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnasationPageAction {

	public OrgnasationPageAction(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	//Declaration 
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusBtnClk;
	
	//send exel data
	@FindBy(name="accountname")
	private WebElement sendExcelData;

	@FindBy(name="button")
	private WebElement saveBtn;
	

	//getters
	public WebElement getPlusBtnClk() {
		return plusBtnClk;
	}
		
	
	public WebElement getSendExcelData() {
		return sendExcelData;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	


	//Business Logic Class
	public void ClickOnPlusBtn() {
		plusBtnClk.click();
	}
	public void SendExcelData(String data) {
		sendExcelData.sendKeys(data);
	}
	
	public void saveBtn() {
		saveBtn.click();	
	}
	
	
}

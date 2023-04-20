package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageAction {
	
	public ProductPageAction(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
   //Declaration 
	@FindBy(xpath="//img[@alt='Create Product...']")
	
	private WebElement productPlusBtn;
	
	@FindBy(name="productname")
	private WebElement sendExcelData;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	@FindBy(id="search_txt")
	private WebElement searchData;
	
	@FindBy(id="search")
	private WebElement clicktoSearchData;
	
	@FindBy(name="lastname")
	private WebElement addLastName;
	
	@FindBy(id="mobile")
	private WebElement AddContact;
	
	
	
	//Getter
	public WebElement getProductPlusBtn() {
		return productPlusBtn;
	}
	public WebElement getSendExcelData() {
		return sendExcelData;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	public WebElement getClicktoSearchData() {
		return clicktoSearchData;
	}
	public WebElement getSearchData() {
		return searchData;
	
	}
	public WebElement getAddLastName() {
		return addLastName;
	}
	public WebElement getAddContact() {
		return AddContact;
	}
	
	//Business Logic Class	

	public void ClickOnPlusBtn() {
		productPlusBtn.click();
	}
	
	public void SendExcelDta(String data) {
		sendExcelData.sendKeys(data);
	}
	
	public void saveData() {
		SaveBtn.click();
	}
	
	public void searchData() {
		clicktoSearchData.click();
		searchData.click();
	}
	
	public void AddLastName(String data) {
		addLastName.sendKeys(data);
	}
	public void AddContact(String num) {
		AddContact.sendKeys(num);
	}
	
}

package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Constructor Call
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	//Declaration
	
		@FindBy(xpath="//a[text()='More']")
	private WebElement clkBtn;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement clkBtnCamp;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement ClkPlusBtn;
	
	@FindBy(name="campaignname")
	private WebElement campTxt;
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement plusContact;

	

	//Initilizations
	public WebElement getClkBtn() {
		return clkBtn;
	}

	public WebElement getClkBtnCamp() {
		return clkBtnCamp;
	}

	public WebElement getClkPlusBtn() {
		return ClkPlusBtn;
	}


	public WebElement getCampTxt() {
		return campTxt;
	}

	public WebElement getPlusContact() {
		return plusContact;
	}
	

	public void campaigns() {
		clkBtn.click();
		clkBtnCamp.click();
		ClkPlusBtn.click();
  }
	
	public void campDta(String data) {
		campTxt.sendKeys(data);
	}

   public void clickContactPlus() {
	   plusContact.click(); 
   }
}

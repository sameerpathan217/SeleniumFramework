package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement usernameField;
	
	@FindBy(name="user_password")
	private WebElement passwardField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	
//getter methods
	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswardField() {
		return passwardField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void LoginApp(String Username, String Password) {
		usernameField.sendKeys(Username);
		passwardField.sendKeys(Password);
		submitButton.click();
		
	}
	

}

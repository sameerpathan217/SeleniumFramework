package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
	
	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
		private WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchBtn;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchIteam() {
		searchBox.sendKeys("iPhone");
	}
	
	public void searchButton() {
		searchBtn.click();
	}

}

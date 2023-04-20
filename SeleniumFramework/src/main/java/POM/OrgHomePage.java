package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgHomePage {
	//Constructor Call
		public OrgHomePage(WebDriver driver) {
			PageFactory.initElements( driver, this);
		}
		
		//Declaration 
		@FindBy(xpath="//a[text()='Products']")
		private WebElement productLInk;
		
		@FindBy(xpath="//a[text()='More']")
		private WebElement moreLink;
		
		@FindBy(xpath="//a[text()='Campaigns']")
		private WebElement campaignsLink;
		
		@FindBy(linkText="Organizations")
		private WebElement organizationsLink;
		
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement clickOnContact;
		
		
		
		

		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement signOutImg;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement sigOutBtn;
		
		//Getters
		public WebElement getProductLInk() {
			return productLInk;
		}

		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampaignsLink() {
			return campaignsLink;
		}

		public WebElement getOrganizationsLink() {
			return organizationsLink;
		}

		
		
	  public WebElement getSignOutImg() {
			return signOutImg;
		}

		

		public WebElement getSigOutBtn() {
			return sigOutBtn;
		}

		public WebElement getClickOnContact() {
			return clickOnContact;
		}
		
//Business Logic Class
	public void SignOutLink(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(signOutImg).build().perform();
		sigOutBtn.click();
	  }
	
	   public void ClickOgnasation() {
		   organizationsLink.click();
	   }
	   
	   public void ClickOnProduct() {
		   productLInk.click();
	   }
	   
	   public void ClickOnMore() {
		   moreLink.click();
	   }
	   
	   public void ClickOnCampaign() {
		   campaignsLink.click(); 
	   }
		
		
		public void ClickOnContacts() {
			clickOnContact.click();
		}

		

}

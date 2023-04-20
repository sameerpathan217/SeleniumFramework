package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic_Utility.BasClass;
import Generic_Utility.Exel_Utility;
import POM.HomePage;
import POM.OrgHomePage;
import POM.ProductPageAction;

public class CreateContacts extends BasClass {
	@Test(groups= {"sanitytest"})
	public  void ContactsClick() throws EncryptedDocumentException, IOException {
		
		OrgHomePage ohp=new OrgHomePage(driver);
		ohp.ClickOnContacts();
		
		HomePage hp=new HomePage(driver);
		hp.clickContactPlus();
		
		
		Exel_Utility eu=new Exel_Utility();
		String data = eu.AddContactInSheet("contact", 0, 0);
		String number = eu.AddContactInSheet("contact", 0, 1);
		
		ProductPageAction ppa=new ProductPageAction(driver);
		ppa.AddLastName(data);
		ppa.AddContact(number);
	}

}

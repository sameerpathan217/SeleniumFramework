package Practice;

import org.testng.annotations.Test;

import Generic_Utility.AmazonBaseClass;
import POM.AmazonHomePage;

public class AmazonPage extends AmazonBaseClass {
	
	@Test
	public void amazonPage() {
	AmazonHomePage ahp=new AmazonHomePage(driver);
	ahp.searchIteam();
	ahp.searchButton();
	
	}

}

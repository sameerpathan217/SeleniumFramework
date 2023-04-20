package Generic_Utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Webdriver_Utility {
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void alertAccept(WebDriver driver) {
		Alert al=driver.switchTo().alert();
		  al.accept();
	}
	public void switchToWindow(WebDriver driver,String windowName) {
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains(windowName)) {
				break;
			}
			
		}
		
	}

}

package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sikulitool {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		//Thread.sleep(6000);
		Screen s=new Screen();
		Pattern p1=new Pattern("C:\\Users\\SAMEER PATHAN\\git\\repository\\SeleniumFramework\\Gmail.png");
		s.click(p1);
	}

}

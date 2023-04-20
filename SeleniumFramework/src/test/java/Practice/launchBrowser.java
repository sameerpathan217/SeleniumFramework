package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchBrowser {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		FileInputStream f=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties p=new Properties();
		p.load(f);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("usename");
		String PASSWORD = p.getProperty("password");
		
		
		driver.get(URL);
		
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
		
		

	}

}

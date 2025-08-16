package Practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practic1 {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		driver.findElement(By.className("_3704LK")).sendKeys("Iphone");
		driver.findElement(By.className("L0Z3Pu")).click();
		String TITLE = driver.getTitle();
		System.out.println(TITLE);
		
		Thread.sleep(5000);
		List<WebElement> allIphone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		 List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		for(WebElement we: allIphone) {
		
			String all = we.getText();
	 
			System.out.println(all+" =========>  "+allprice);
			
			

			
		}
	
	}

}

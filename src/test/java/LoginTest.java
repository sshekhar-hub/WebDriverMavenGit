import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public WebDriver driver;
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void doLogin() {
		driver.get("https://www.facebook.com");
		System.out.println("The title is-->"+driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("shekhar.swarna@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("goodguy@6682");
		driver.findElement(By.name("login")).click();
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}

package bootcampdoubts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Selbootcamp@123");
		driver.findElement(By.id("Login")).click();
				driver.findElement(By.className("slds-icon-waffle")).click();
		
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		WebElement element = driver.findElement(By.xpath("//p[text()='Contacts']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", element);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 

	}

}

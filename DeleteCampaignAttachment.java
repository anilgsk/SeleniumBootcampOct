package bootcampdoubts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCampaignAttachment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait;
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("cypress@testleaf.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Bootcamp@123");
		WebElement loginButton = driver.findElement(By.id("Login"));
		loginButton.click();
		//driver.findElement(By.linkText("Switch to Lightning Experience")).click();
		wait=new WebDriverWait(driver,80);
		WebElement toggleMenuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-icon-waffle")));
		toggleMenuButton.click();
		System.out.println("toggle menu clicked");
		WebElement viewAllButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		viewAllButton.click();			 
		WebElement salesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']")));
		salesOption.click();
		WebElement Opportunities=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Opportunities']/following::lightning-icon)[1]")));
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Opportunities);
		System.out.println("Opportunities tab is clicked");
		WebElement AllOpportunities =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='All Opportunities'])[1]")));
		executor.executeScript("arguments[0].click();", AllOpportunities);
		Thread.sleep(5000);
		WebElement bootcampLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Bootcamp'])[1]")));
		bootcampLink.click();
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		try
		{
			WebElement viewAll = driver.findElement(By.xpath("//span[@class='assistiveText']/parent::span"));
			executor.executeScript("arguments[0].click();", viewAll);
			//viewAll.click();
			Thread.sleep(10000);
			WebElement findDeleteDD = driver.findElement(By.xpath("//div[@id='brandBand_2']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/span[1]/div[1]/a[1]/lightning-icon[1]/lightning-primitive-icon[1]"));
			executor.executeScript("arguments[0].click();", findDeleteDD);
			Thread.sleep(8000);
			WebElement deleteOption=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='branding-actions actionMenu']/ul/li[7]/a")));
			executor.executeScript("arguments[0].click();", deleteOption);
			driver.findElement(By.xpath("//span[text()='Delete']")).click();
			String text="Record was deleted.";
				Thread.sleep(9000);	
			WebElement actual =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-aura-class='forceActionsText']")));
			System.out.println(actual.getText());
			if(actual.getText().equalsIgnoreCase(text))
			{
				System.out.println("File was deleted successfully");
			}
			else
			{
				System.out.println("Testcase Failed!! Failed was not deleted as Expected");
			}
		
		}
		
	catch(Exception e)
		{
		System.out.println("No files present to perform delete...please check");
		System.out.println("Exception"+e);
		}
		
	}

}

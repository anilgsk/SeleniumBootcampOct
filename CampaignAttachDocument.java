package bootcampdoubts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignAttachDocument {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, AWTException {
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
		wait=new WebDriverWait(driver,Duration.ofSeconds(50));
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
		WebElement NotesAttachment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Notes & Attachments'])[1]")));
		executor.executeScript("arguments[0].click();", NotesAttachment);
		System.out.println("Notes Attachment clicked");
		WebElement uploadFiles=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Upload Files']")));
		uploadFiles.click();
		Thread.sleep(7000);
		StringSelection selection=new StringSelection("C:\\Users\\anilg\\OneDrive\\Desktop\\bbot camp\\Campaign attachment testcase verification.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null); 
		Robot robot=new Robot(); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V); 
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V); 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(15000);
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		System.out.println("Doc uploaded");	
		WebElement textAttachmentInfo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-aura-class='forceActionsText']")));
		boolean ActualInfo = textAttachmentInfo.getText().equalsIgnoreCase("1 file was added to the Opportunity.");
		String alertInfo=textAttachmentInfo.getText();
		System.out.println("alertInfo:::"+alertInfo);
		String FileName="Campaign attachment testcase verification";
		Boolean fileAttached=driver.findElement(By.xpath("(//div[@class='slds-truncate'])[1]")).getText().equals(FileName);
			
		if(fileAttached && ActualInfo )
		{
			System.out.println("Your File is Attached as Expected");
		}
		else
		{
			System.out.println("File is not attached...Please check");
		}
		//driver.close();


	}

}
package SeleniumA;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class B 
{
	public static WebDriver driver;
	@BeforeClass
	public static void Initialize()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\CA Portal\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
	}
	
	@Ignore
	@Test
	public void ConditionalWait()
	{
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a/span[text() = 'Register']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id, 'userNameId')]"))));
		driver.findElement(By.xpath("//input[contains(@id, 'userNameId')]")).sendKeys("Sriram");
	}
	
	@Ignore
	@Test
	public void PopupWindowA() throws InterruptedException
	{
		driver.get("https://www.citibank.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String varParentWindow = driver.getWindowHandle();
		System.out.println(varParentWindow);
		driver.findElement(By.xpath("(//img[contains(@src, 'login.png')])[1]")).click();;
		Thread.sleep(5000);
		Set<String> varAllWindows = driver.getWindowHandles();
		for(String varWID:varAllWindows)
		{
			if(driver.switchTo().window(varWID).getTitle().equalsIgnoreCase("Citibank India"))
			{
				driver.switchTo().window(varWID);
				driver.findElement(By.xpath("//input[@id = 'User_Id']")).sendKeys("srirammithra");
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(varParentWindow);
		System.out.println(driver.getTitle());
	}
	
	@Ignore
	@Test
	public void AlertMsgA() throws InterruptedException
	{
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id = 'loginbutton']")).click();
		Thread.sleep(3000);
		Alert objAlert = driver.switchTo().alert();
		System.out.println(objAlert.getText());
		objAlert.accept();
	}

}

package SeleniumA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class A 
{
	public static WebDriver driver;
	@BeforeClass
	public static void Initialize()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
	}
	
	
	@Test
	public void GetText()
	{
		driver.get("https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String varTitle = driver.findElement(By.xpath("//div[@class = 'flighttitle']")).getText();
		Assert.assertEquals(varTitle, "Flight Search");
	}
	
	@Ignore
	@Test
	public void GetAttribute()
	{
		driver.get("https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String varAttr = driver.findElement(By.xpath("//div[@class = 'searchbutton']/a/label")).getAttribute("class");
		Assert.assertEquals(varAttr, "buttonText");
	}
	
	@Ignore
	@Test
	public void CntrlKeyPress()
	{
		driver.get("https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions objAction = new Actions(driver);
		objAction.moveToElement(driver.findElement(By.xpath("//div[@class = 'producttab']/a/div[text() = 'Hotel']"))).build().perform();
		objAction.keyDown(Keys.CONTROL).build().perform();
		objAction.click(driver.findElement(By.xpath("//div[@class = 'producttab']/a/div[text() = 'Hotel']"))).build().perform();
	}
	
	@Ignore
	@Test
	public void DoubleClick() throws InterruptedException
	{
		driver.get("https://icgaspadsw01d.nam.nsroot.net:47007/AssetServicing/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name = 'sm_user']")).clear();
		driver.findElement(By.xpath("//input[@name = 'sm_user']")).sendKeys("super");
		driver.findElement(By.xpath("//input[@value = ' Login']")).click();
		driver.get("https://icgaspadsw01d.nam.nsroot.net:47007/AssetServicing/CorporateActions.html");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//img[contains(@src, 'refresh')]")).click();
		Thread.sleep(5000);
		Actions objAction = new Actions(driver);
		objAction.moveToElement(driver.findElement(By.xpath("//tr[td/div[text() = '32']]/td/div[text() = 'Accumulation']"))).build().perform();
		objAction.doubleClick(driver.findElement(By.xpath("//tr[td/div[text() = '32']]/td/div[text() = 'Accumulation']")));
		objAction.doubleClick(driver.findElement(By.xpath("//tr[td/div[text() = '32']]/td/div[text() = 'Accumulation']")));
		objAction.build().perform();
	}
	
	@Ignore
	@Test
	public void GetTitle()
	{
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String varTitle = (String) js.executeScript("return document.title");
		System.out.println(varTitle);
		driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("selenium");
		js.executeScript("arguments[0].click;", driver.findElement(By.xpath("//input[@value = 'Google Search']")));
		String varValue = (String) js.executeScript("return arguments[0].value;", driver.findElement(By.xpath("//input[@name = 'q']")));
		System.out.println(varValue);
	}
	
	@Ignore
	@Test
	public void AllLinks()
	{
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List <WebElement> AllLinks = driver.findElements(By.xpath("//a"));
		System.out.println(AllLinks.size());
		for(WebElement L:AllLinks)
		{
			System.out.println(L.getText());
		}
	}
	
	@Ignore
	@Test
	public void CaptureScreenshot() throws IOException
	{
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File varSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(varSrc, new File("C:\\Mithra\\Google.png"));
	}
	
	@Ignore
	@Test
	public void TestDropdowns()
	{
		driver.get("https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a/span[text() = 'Register']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select objCountry = new Select(driver.findElement(By.xpath("//select[contains(@id, 'countryId')]")));
		System.out.println(objCountry.isMultiple());
		System.out.println(objCountry.getOptions().size());
		List<WebElement> objOptions = objCountry.getOptions();
		for(WebElement O:objOptions)
		{
			System.out.println(O.getText());
		}
		objCountry.selectByValue("10099");
		objCountry.selectByVisibleText("Germany");
		System.out.println(objCountry.getFirstSelectedOption().getText());
		objCountry.deselectByVisibleText("Germany");
	}
	
	@Ignore
	@Test
	public void VerifyDropdownValues()
	{
		driver.get("https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a/span[text() = 'Register']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select objTitle = new Select(driver.findElement(By.xpath("//select[contains(@id, 'selectOptionForGender')]")));
		List<String> varExpected = new ArrayList();
		varExpected.add("Mr");
		varExpected.add("Mrs");
		varExpected.add("Ms");
		varExpected.add("Mstr");
		varExpected.add("Miss");
		varExpected.add("Inf");
		List<WebElement> objAllTitles = objTitle.getOptions();
		List<String> varActual = new ArrayList();
		for(WebElement T:objAllTitles)
		{
			varActual.add(T.getText());
		}
		for(String I:varExpected)
		{
			String varFlag = "N";
			for(String J:varActual)
			{
				if(I.equalsIgnoreCase(J))
				{
					System.out.println("Match Found");
					varFlag = "Y";
				}
				
			}
			if(varFlag.equalsIgnoreCase("N"))
			{
				System.out.println("Mismatch");
			}
		}
		
		/*String varExpected[] = new String[]{"Mr", "Mrs", "Ms", "Mstr","Miss", "Inf"};
		String varActual[] = new String[6];
		List<WebElement> objAllTitles = objTitle.getOptions();
		for(int i = 0; i<=objAllTitles.size()-1; i++)
		{
			varActual[i] = objAllTitles.get(i).getText();
		}
		Arrays.sort(varExpected);
		Arrays.sort(varActual);
		System.out.println(Arrays.equals(varExpected, varActual));*/
	}
	
	@Ignore
	@Test
	public void RadioButtons()
	{
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//input[@id = 'userRegistrationForm:gender:0']")).isSelected());
		driver.findElement(By.xpath("//input[@id = 'userRegistrationForm:gender:0']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id = 'userRegistrationForm:gender:0']")).isSelected());
	}
	
	@Ignore
	@Test
	public void Checkbox() throws InterruptedException
	{
		driver.get("https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a/span[text() = 'Register']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//input[@id = 'registration:searchPageBody:personal:checkbox2']")).isSelected());
		driver.findElement(By.xpath("//input[@id = 'registration:searchPageBody:personal:checkbox2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id = 'registration:searchPageBody:personal:checkbox2']")).isSelected());
		driver.findElement(By.xpath("//input[@id = 'registration:searchPageBody:personal:checkbox2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id = 'registration:searchPageBody:personal:checkbox2']")).isSelected());
	}
	
	@Ignore
	@Test
	public void KillProcessByName()
	{
		WindowsUtils.tryToKillByName("chrome.exe");
	}
	
	@Ignore
	@Test
	public void ReadRegistryValue()
	{
		System.out.println(WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\ProductName"));
	}

}

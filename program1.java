package amazonproject4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class program1 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
	
		ChromeOptions opt=new  ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opt);
    driver.get("https://www.amazon.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
}
	@Test
	public void verifytTitle() {
		String actulaTitle=driver.getTitle();
		String exceptedTitle="Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actulaTitle, exceptedTitle);
		
		
	}
	@Test
	public void verifyLogo()
	{
	boolean logo=driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]")).isDisplayed();
	Assert.assertTrue(logo);
		
		
		
	}
	@AfterMethod
	public void tearDown()
	{
	driver.quit();	
	}
}
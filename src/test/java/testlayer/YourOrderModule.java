package testlayer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class YourOrderModule {
	WebDriver driver;

	@BeforeSuite
	public void Signin() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("sidharath.sharma2@ymail.com");
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("9815968898");
		driver.findElement(By.cssSelector(".a-checkbox > label:nth-child(1) > input:nth-child(1)")).click();
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(1000);}
	
	
	@Test(priority=1)
	public void YourOrders() throws InterruptedException{
		Thread.sleep(1000);
		Actions actions=new Actions(driver);
actions.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > span:nth-child(2)"))).build()
.perform();	
Thread.sleep(1000);
driver.findElement(By.cssSelector("#nav_prefetch_yourorders > span:nth-child(1)")).click();

if(driver.findElement(By.cssSelector(".a-dropdown-prompt")) != null) {
	System.out.println("past 3 months present");
}else  {System.out.println("past 3 months not present");}
Thread.sleep(1000);
	
}
	@Test(priority=2)
	public void CancelledOrders() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li.page-tabs__tab:nth-child(4) > a:nth-child(1)")).click();
		if(driver.findElement(By.cssSelector(".num-orders-for-cancelled-orders")) != null) {
			System.out.println("cancelled order placed in the last 6 months ");
		}else  {System.out.println("Expected Result not same");
			}
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		}
	}

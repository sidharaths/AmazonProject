package testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class YourAddressModule {
	
	WebDriver driver;
	@BeforeSuite
	public void Signin() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("sidharath.sharma2@ymail.com");
		Thread.sleep(100);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("9815968898");
		driver.findElement(By.cssSelector(".a-checkbox > label:nth-child(1) > input:nth-child(1)")).click();
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(1000);
		
}
	@Test(priority=1)
	public void YourAddress() throws InterruptedException {
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("div.ya-card-row:nth-child(3) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
		Thread.sleep(100);
		driver.findElement(By.id("ya-myab-plus-address-icon")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector(".a-button-input")).click();
		if(driver.findElement(By.cssSelector("#address-ui-widgets-enterAddressFullName-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")) != null) {
			System.out.println("Full Name Must not be Empty");	}
		else  {System.out.println("Full Name can be Left Empty Test Fail");			}

		if(driver.findElement(By.id("address-ui-widgets-use-as-my-default")) != null) {
			System.out.println("Customer must have choice to make address as default Is Present");
		}else  {System.out.println("Default option not availbele");		}
		Thread.sleep(100);
		
		driver.findElement(By.cssSelector("div.a-expander-container:nth-child(5) > a:nth-child(1) > span:nth-child(2) > span:nth-child(1)")).click();
		driver.findElement(By.cssSelector("div.a-section:nth-child(21) > div:nth-child(4) > a:nth-child(1) > span:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")).click();
		if(driver.findElement(By.cssSelector("div.a-section:nth-child(21) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > textarea:nth-child(1)")) != null) {
			System.out.println("Customer can add additional delivery instructions Is Present ");
		}else  {System.out.println("Option toadd additional delivery instructions not present");		}
	}
	@Test  (priority=2)
	public void AddAddress() throws InterruptedException {
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("S");
		driver.findElement(By.cssSelector("#address-ui-widgets-enterAddressPhoneNumber")).sendKeys("6475301096");
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("10 Fairlight St.");
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
		
		driver.findElement(By.cssSelector("#address-ui-widgets-enterAddressStateOrRegion > span:nth-child(1) > span:nth-child(1)")).click();
		Thread.sleep(100);
		driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")).click();
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6Z 3W7");
		
		driver.findElement(By.cssSelector(".a-button-input")).click();
		Thread.sleep(100);
	if(driver.findElement(By.cssSelector("#ya-myab-set-default-shipping-btn-1")) != null) {
		System.out.println("Set As Default option Present ");}
	else {	System.out.println("Set Default not Present");}
		}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();	}
}

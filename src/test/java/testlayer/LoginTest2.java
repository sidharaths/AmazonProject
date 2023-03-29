package testlayer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest2 {
WebDriver driver;

@BeforeMethod
public void browser() {
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
driver=new FirefoxDriver();


}

@Test(priority=1)
public void Signin() throws InterruptedException {
	driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	driver.findElement(By.cssSelector("#ap_email")).sendKeys("sidharath.sharma2@ymail.com");
	driver.findElement(By.id("continue")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#ap_password")).sendKeys("9815968898");
	driver.findElement(By.cssSelector(".a-checkbox > label:nth-child(1) > input:nth-child(1)")).click();
	driver.findElement(By.id("signInSubmit")).click();
	Thread.sleep(1000);
	

	WebElement element=driver.findElement(By.cssSelector(".nav-line-1-container"));
	String a=element.getText();
	String b="Hello, Sidharath";
Assert.assertEquals(a, b);
driver.quit();}

@Test(priority=2)
public void KeepSignedin() throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver.get("https://www.amazon.ca/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_AccountFlyout_signout");
	Thread.sleep(1000);
	WebElement element=driver.findElement(By.cssSelector(".nav-line-1-container"));
	String a=element.getText();
	String b="Hello, Sidharath";
Assert.assertEquals(a, b);
System.out.println("Keep Signin Not working");
}
	
@AfterSuite
public void close() {
	driver.quit();}
}

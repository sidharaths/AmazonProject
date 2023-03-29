package testlayer;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
public class SortingFilterationPagination {
	WebDriver driver;

	private By by;
	
	@BeforeSuite
	public void Signin() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	@AfterSuite
	public void closeBrowser () {
		driver.quit();
	}
@Test(priority=1)
public void Search() throws InterruptedException {
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("red tsh");
	Thread.sleep(1000);
	if (driver.findElement(By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")) != null) {
		System.out.println("Able to Search by Keyword");	}
	else{System.out.println("unable to Search by Keyword");}
}
@Test(priority=2)
public void Relevant() throws InterruptedException {

	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
if(driver.findElement(By.cssSelector("span.a-color-state:nth-child(3)")) != null) {
	System.out.println("Relevant Product Shown");}
else {System.out.println("Relevant Product Not Shown");}


}
@Test(priority=3)
public void ProductInformation() {
	WebElement image=driver.findElement(By.cssSelector(".widgetId\\=search-results_5 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > a:nth-child(1) > div:nth-child(1) > img:nth-child(1)"));
	if(image.isDisplayed()) { System.out.println("Image is displayed on the website");}
	else {System.out.println("Image is not displayed on the website");}}

@Test(priority=4)
public void numofproductperpage() {
	WebElement element=driver.findElement(By.cssSelector(".sg-col-14-of-20 > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)"));
String text= element.getText();
System.out.println(text);
String actual=text;
Assert.assertEquals(actual, "60");}

@Test (priority=5)
public void sorting() throws InterruptedException {
	driver.findElement(by.cssSelector(".a-dropdown-label")).click();
	Thread.sleep(1000);
	driver.findElement(by.id("s-result-sort-select_4")).click();
WebElement element =driver.findElement(by.id("a-autoid-2-announce"));
String text=element.getText();
System.out.println(text);
Assert.assertEquals(text, "Sort by:Newest arrivals");

}

@Test(priority=6)

public void filternationcustomerratting() throws InterruptedException {
	Thread.sleep(1000);
	 WebElement ratingFilter = driver.findElement(By.cssSelector(".a-star-medium-1"));
	 ratingFilter.click();
 }

@Test(priority=7)
public void searchresultcount() {
	List<WebElement> searchResults = driver.findElements(By.cssSelector(".s-result-item"));
	int itemCount = searchResults.size();
	System.out.println("Number of items displayed on search page: " + itemCount);
	
    }
@Test(priority=8)
public void filterationsortingpagination() {

List<WebElement> searchResults = driver.findElements(By.cssSelector(".s-result-item .a-text-normal"));
Set<String> searchResultTitles = new HashSet<String>();
for (WebElement searchResult : searchResults) {
    searchResultTitles.add(searchResult.getText());
}

// check for duplicates
if (searchResultTitles.size() == searchResults.size()) {
    System.out.println("No duplicates found in search results");
} else {
    System.out.println("Duplicates found in search results");
}
}}
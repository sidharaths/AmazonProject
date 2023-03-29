package BasePackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseAmazonClass {
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	public BaseAmazonClass () {
try {		
	FileInputStream file =new FileInputStream("C:\\Users\\vinil\\Downloads\\Roicians\\Software\\Program x86\\New folder\\Amazon1.0\\src\\test\\java\\enviromentvariables\\Config.properties");
	prop.load(file); }
catch(FileNotFoundException e ) {
	e.printStackTrace();}
catch(IOException a) {
	a.printStackTrace();}}
	
public static void initiate() {
 String browser=prop.getProperty("browser");
 
 if(browser.equals("Firefox")) {
	 System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); 
	 driver=new FirefoxDriver();}
 else if(browser.equals("chrome")) {
	 System.setProperty("webdriver.chromedriver","chromedriver.exe");
	 driver=new ChromeDriver();}
 
 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 driver.get(prop.getProperty("url"));
}

}

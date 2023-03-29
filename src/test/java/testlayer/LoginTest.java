package testlayer;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import BasePackage.BaseAmazonClass;
import pompackage.PomLogin;

public class LoginTest extends BaseAmazonClass {
	PomLogin Log;
	WebDriver driver;
	
	public LoginTest() {
		super();}
	
@BeforeMethod
public void initsetup() {
	initiate();
	Log=new PomLogin();
	}


@Test
public void SucessSignin(String name, String Password) {
	Log.typeEMail(name);
	Log.clickContinue();
	
	Log.typePassword(Password);
	Log.clickSignin();
	
	String actual=Log.verify();
	Assert.assertEquals(actual, "Hello Sidharath");
	
	

}
}

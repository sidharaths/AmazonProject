package pompackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseAmazonClass;

public class PomLogin extends BaseAmazonClass{
	@FindBy(css="#ap_email")	WebElement EMail;
	@FindBy(id="continue")      WebElement Continue;
	@FindBy(css="#ap_password")	WebElement Password;
	@FindBy(id="signInSubmit")  WebElement SiginButton;
	
 public PomLogin() {
	 PageFactory.initElements(driver, this); 
 }
 public void typeEMail (String name) {
	
	 EMail.sendKeys(name);
 }
 public void clickContinue() {
	 Continue.click();
 }
 public void typePassword (String password) {
	 Password.sendKeys(password);
 }
 
 public void clickSignin() {
	 SiginButton.click();
 }
 public String verify() {
		return driver.getTitle();
}}

package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomYourAddress {
	@FindBy(css="#address-ui-widgets-enterAddressFullName")	WebElement Name;
	@FindBy(css="#address-ui-widgets-enterAddressPhoneNumber")      WebElement PhoneNumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1")	WebElement Address;
	@FindBy(id="address-ui-widgets-enterAddressCity")  WebElement City;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_12") WebElement Province;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8") WebElement ON ;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement PostalCode;
	
	public void Typename(String S) {

		 Name.sendKeys(S);
	}
}

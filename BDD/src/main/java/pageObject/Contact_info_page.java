package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_info_page {
	@FindBy(id="mouseArea_First Name")
	private WebElement firstName;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastName;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrganizationName;
	
	public Contact_info_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}
	
	

}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creating_New_Contact {
	@FindBy(name="firstname")
	private WebElement firstNameTextBox;

	@FindBy(name="lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement organizationLookUpPage;
	
	public Creating_New_Contact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}
	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}
	public WebElement getOrganizationLookUpPage() {
		return organizationLookUpPage;
	}
	

}

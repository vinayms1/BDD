package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creating_New_Organization {
	@FindBy(name="accountname")
	private WebElement organizationTextBox;

	@FindBy(name="industry")
	private WebElement accountTypeListBox;

	@FindBy(name="website")
	private WebElement websiteTextField;
	
	@FindBy(name="phone")
	private WebElement phoneTextField;
	
	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}
	public WebElement getPhoneTextField() {
		return phoneTextField;
	}
	public WebElement getEmployeeTextField() {
		return employeeTextField;
	}
	@FindBy(name="employees")
	private WebElement employeeTextField;

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;;

	public Creating_New_Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganizationTextBox() {
		return organizationTextBox;
	}
	public WebElement getAccountTypeListBox() {
		return accountTypeListBox;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void organizationName(String Data) {
		organizationTextBox.sendKeys(Data);
	}
	
	public void savebutton() {
		saveButton.click();
	}
}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[contains(text(),\"Organizations\")]")
	private WebElement organizationLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement signoutBar;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutButtton;
	
	@FindBy(xpath="//a[contains(text(),\"Contacts\")]")
	private WebElement ContactsLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getSignoutbar() {
		return signoutBar;
	}
	

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getSignoutButtton() {
		return signoutButtton;
	}

	public void clickOnOrganizationLink() {
		getOrganizationLink().click();
	}
	public void clickOnContactLink() {
		getContactsLink().click();
	}
	
	public void signout() {
		signoutBar.click();
		signoutButtton.click();
		
	}

}

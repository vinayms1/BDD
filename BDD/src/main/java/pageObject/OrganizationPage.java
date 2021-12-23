package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createNewOrganization;
	
	@FindBy(id="search_txt")
	private WebElement searchTextBox;

	@FindBy(xpath="//input[@class=\"crmbutton small create\"]")
	private WebElement searchNowbutton;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewOrganization() {
		return createNewOrganization;
	}
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchNowbutton() {
		return searchNowbutton;
	}

	public void createorganizationTest() {
		createNewOrganization.click();
	}
}

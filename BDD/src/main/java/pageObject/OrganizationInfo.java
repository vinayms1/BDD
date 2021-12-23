package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	@FindBy(className="dvHeaderText")
	private WebElement OrganizationTitle;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement organizationNametex;
	
	@FindBy(id="mouseArea_Type")
	private WebElement accountTypeSelect;
	
	@FindBy(xpath="//span[@id=\"dtlview_Website\"]/a")
	private WebElement webSiteText;
	
	@FindBy(xpath="//span[@id=\"dtlview_Employees\"]")
	private WebElement employessText;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneText;
	
	
	public WebElement getWebSiteText() {
		return webSiteText;
	}

	public WebElement getEmployessText() {
		return employessText;
	}

	public WebElement getPhoneText() {
		return phoneText;
	}


	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationTitle() {
		return OrganizationTitle;
	}
	
	

	public WebElement getOrganizationNametex() {
		return organizationNametex;
	}

	public WebElement getAccountTypeSelect() {
		return accountTypeSelect;
	}
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	



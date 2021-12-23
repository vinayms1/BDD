package utilityManager;

import org.openqa.selenium.WebDriver;

import pageObject.Creating_New_Organization;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.OrganizationInfo;
import pageObject.OrganizationPage;

public class PageFactoryManager {
	private LoginPage loginPage;
	private HomePage homePage;
	private OrganizationInfo orgInfoPage;
	private OrganizationPage orgPage;
	private Creating_New_Organization createNewOrg;
	
	public LoginPage initLoginPage(WebDriver driver) {
		return (loginPage==null)?new LoginPage(driver):loginPage;
	}
	public HomePage initHomePage(WebDriver driver) {
		return (homePage==null)? new HomePage(driver):homePage;
		
	}
	public OrganizationInfo initOrganisationInfo(WebDriver driver) {
		return (orgInfoPage==null)?new OrganizationInfo(driver):orgInfoPage;
	}
	public OrganizationPage initOrganizationPage(WebDriver driver) {
		return (orgPage==null)?new OrganizationPage(driver):orgPage;
		
	}
	public Creating_New_Organization initCreatingNewOrganization(WebDriver driver) {
		return(createNewOrg==null)?new Creating_New_Organization(driver):createNewOrg;
		
	}
	
	

}

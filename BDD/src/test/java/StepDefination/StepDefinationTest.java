package StepDefination;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Base;

public class StepDefinationTest {
	Base base;

	public StepDefinationTest(Base base) {
		this.base = base;

	}

	@Given("i will launch browser")
	public void i_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
		base.driver = new ChromeDriver();
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Given("enter the url")
	public void enter_the_url() {
		base.driver.get("http://localhost:8888/");
	}

	@When("Login page is displayed and i will enter username and password")
	public void login_page_is_displayed_and_i_will_enter_username_and_password() {
//		base.driver.findElement(By.name("user_name")).sendKeys("admin");
//		base.driver.findElement(By.name("user_password")).sendKeys("admin");
		
		base.pagemanger.initLoginPage(base.driver).getUsernametextbox().sendKeys("admin");
		base.pagemanger.initLoginPage(base.driver).getPasswordtextbox().sendKeys("admin");
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		//base.driver.findElement(By.id("submitButton")).click();
		base.pagemanger.initLoginPage(base.driver).getLoginbutton().click();
	}

	@Then("i will navigate it will navigating to home page or not")
	public void i_will_navigate_it_will_navigating_to_home_page_or_not() {
//	 String text = driver.findElement(By.linkText("Test Yantra")).getText();
//	  Assert.assertTrue(text.contains("Test Yantra"));
		
	}

	@Given("enter the url {string}")
	public void enter_the_url(String url) {
		base.driver.get(url);
	}

	@When("Login page is displayed and i will enter username {string} and password {string}")
	public void login_page_is_displayed_and_i_will_enter_username_and_password(String userName, String password) {
//		base.driver.findElement(By.name("user_name")).sendKeys(userName);
//		base.driver.findElement(By.name("user_password")).sendKeys(password);
		base.pagemanger.initLoginPage(base.driver).getUsernametextbox().sendKeys(userName);
		base.pagemanger.initLoginPage(base.driver).getPasswordtextbox().sendKeys(password);
	}

	@When("home page is displayed")
	public void home_page_is_displayed() {
//	String text = driver.findElement(By.linkText("Test Yantra")).getText();
//	  Assert.assertTrue(text.contains("Test Yantra"));

	}

	@When("click on organisation")
	public void click_on_organisation() throws Throwable {
		Thread.sleep(3000);
//		base.driver.findElement(By.linkText("Organizations")).click();
		base.pagemanger.initHomePage(base.driver).getOrganizationLink().click();
	}

	@When("click on create organization")
	public void click_on_create_organization() {
		//base.driver.findElement(By.xpath("//*[@title=\"Create Organization...\"]")).click();
		base.pagemanger.initOrganizationPage(base.driver).getCreateNewOrganization().click();
	}

	@Then("i will check whether i getting error msg or not")
	public void i_will_check_whether_i_getting_error_msg_or_not() {
		String actualErrorMsg = "You must specify a valid username and password";
		//String expectedErrorMsg = base.driver.findElement(By.xpath("//*[@class=\"errorMessage\"]")).getText();
		String expectedErrorMsg = base.pagemanger.initLoginPage(base.driver).getErrorMsg();
		Assert.assertEquals(actualErrorMsg.contains(expectedErrorMsg), true);
	}

	@When("enter organisation name {string} and click on save button")
	public void enter_organisation_name_and_click_on_save_button(String orgName) {

		int ram = new Random().nextInt(1000);
//		base.driver.findElement(By.xpath("//*[@name=\"accountname\"]")).sendKeys(orgName + ram);
//		base.driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		 base.pagemanger.initCreatingNewOrganization(base.driver).organizationName(orgName+ram);
	}

	@Then("verify organization {string} is created or not")
	public void verify_organization_is_created_or_not(String orgName) {
//		String text = base.driver.findElement(By.className("dvHeaderText")).getText();
		String text = base.pagemanger.initOrganisationInfo(base.driver).getOrganizationTitle().getText();
		if (text.contains(orgName)) {
			System.out.println("organisation is created");
			base.driver.close();
		}
	}

	String orgName;
	String phoneNum;
	String webSiteId;
	String employee;

	@When("Enter organisation name, phone, website and employees")
	public void enter_organisation_name_phone_website_and_employees(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		List<Map<Object, Object>> data = dataTable.asMaps(String.class, Object.class);
		int ram = new Random().nextInt(1000);
		orgName = (String) data.get(0).get("organisation name") + ram;
		phoneNum = (String) data.get(0).get("phone");
		webSiteId = (String) data.get(0).get("website");
		employee = (String) data.get(0).get("employees");

//		base.driver.findElement(By.xpath("//*[@name=\"accountname\"]")).sendKeys(orgName);
//		base.driver.findElement(By.xpath("//*[@name=\"website\"]")).sendKeys(webSiteId);
//		base.driver.findElement(By.xpath("//*[@name=\"phone\"]")).sendKeys(phoneNum);
//		base.driver.findElement(By.xpath("//*[@name=\"employees\"]")).sendKeys(employee);
		base.pagemanger.initCreatingNewOrganization(base.driver).getOrganizationTextBox().sendKeys(orgName);
		base.pagemanger.initCreatingNewOrganization(base.driver).getPhoneTextField().sendKeys(phoneNum);
		base.pagemanger.initCreatingNewOrganization(base.driver).getEmployeeTextField().sendKeys(employee);
		base.pagemanger.initCreatingNewOrganization(base.driver).getWebsiteTextField().sendKeys(webSiteId);
		Thread.sleep(3000);
	}

	@When("click on save button")
	public void click_on_save_button() {
		//base.driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		base.pagemanger.initCreatingNewOrganization(base.driver).getSaveButton().click();
	}

	@Then("verify organisation name, phone, website, employees is created or not")
	public void verify_organisation_name_phone_website_employees_is_created_or_not() {
//		String actOrgName = base.driver.findElement(By.xpath("//td[.=\"Organization Name\"]/following-sibling::td[@id=\"mouseArea_Organization Name\"]/span")).getText();
//		String ActualWebSite = base.driver.findElement(By.xpath("//td[.=\"Website\"]/following-sibling::td[@id=\"mouseArea_Website\"]/span")).getText();		
//		String ActualPhoneNum = base.driver.findElement(By.xpath("//td[.=\"Phone\"]/following-sibling::td[@id=\"mouseArea_Phone\"]/span")).getText();
//		String ActualEmployeeNum = base.driver.findElement(By.xpath("//td[.=\"Employees\"]/following-sibling::td[@id=\"mouseArea_Employees\"]/span")).getText();

		String actOrgName =base.pagemanger.initOrganisationInfo(base.driver).getOrganizationNametex().getText();
		String ActualWebSite = base.pagemanger.initOrganisationInfo(base.driver).getWebSiteText().getText();
		String ActualPhoneNum = base.pagemanger.initOrganisationInfo(base.driver).getPhoneText().getText();
		String ActualEmployeeNum = base.pagemanger.initOrganisationInfo(base.driver).getEmployessText().getText();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(orgName.contains(actOrgName), true);
		sa.assertEquals(ActualWebSite.contains(webSiteId), true);
		sa.assertEquals(ActualPhoneNum.contains(phoneNum), true);
		sa.assertEquals(ActualEmployeeNum.contains(employee), true);
		sa.assertAll();
	}

	@Then("Click on Contact module")
	public void click_on_contact_module() throws Throwable {
		Thread.sleep(3000);
		//base.driver.findElement(By.linkText("Contacts")).click();
		
	}

	@Then("Click on create contact")
	public void click_on_create_contact() {
		base.driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	}

	String FirstName;
	String LastName;
	String MobileNumber;
	String EmailId;

	@Then("enter frirstName, LastName, phoneNumber and emailId")
	public void enter_frirst_name_last_name_phone_number_and_email_id(io.cucumber.datatable.DataTable dataTable) {
		int ram = new Random().nextInt(1000);
		List<Map<Object, Object>> data = dataTable.asMaps(String.class, Object.class);
		FirstName = (String) data.get(0).get("frirstName");
		LastName = (String) data.get(0).get("LastName");
		MobileNumber = (String) data.get(0).get("phoneNumber");
		EmailId = (String) data.get(0).get("emailId");
		base.driver.findElement(By.name("firstname")).sendKeys(FirstName);
		base.driver.findElement(By.name("lastname")).sendKeys(LastName + ram);
		base.driver.findElement(By.name("mobile")).sendKeys(MobileNumber);
		base.driver.findElement(By.name("email")).sendKeys(EmailId);
	}

	@Then("click on save button in contact module")
	public void click_on_save_button_in_contact_module() throws InterruptedException {
		Thread.sleep(3000);
		base.driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	}

	@Then("Verify frirstName, LastName, phoneNumber and emailId created or not")
	public void verify_frirst_name_last_name_phone_number_and_email_id_created_or_not() {
		String actualFirstName = base.driver
				.findElement(
						By.xpath("//td[text()=\"First Name\"]/following-sibling::td[@id=\"mouseArea_First Name\"]"))
				.getText();
		String ActualLastName = base.driver
				.findElement(By.xpath("//td[text()=\"Last Name\"]/following-sibling::td[@id=\"mouseArea_Last Name\"]"))
				.getText();
		String ActualMobileNumber = base.driver
				.findElement(By.xpath("//td[text()=\"Mobile\"]/following-sibling::td[@id=\"mouseArea_Mobile\"]"))
				.getText();
		String ActualEmailId = base.driver
				.findElement(By.xpath("//td[text()=\"Email\"]/following-sibling::td[@id=\"mouseArea_Email\"]"))
				.getText();
		SoftAssert as = new SoftAssert();
		as.assertEquals(FirstName.contains(actualFirstName), true);
		as.assertEquals(ActualLastName.contains(LastName), true);
		as.assertEquals(ActualMobileNumber.contains(MobileNumber), true);
		as.assertEquals(ActualEmailId.contains(EmailId), true);
		base.driver.close();
	}

	@Then("click on Organization look up page")
	public void click_on_organization_look_up_page() {
		base.driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();

	}

	@Then("select Organization from lookUp Page")
	public void select_organization_from_look_up_page() {
		String parentid = base.driver.getWindowHandle();
		Set<String> allwid = base.driver.getWindowHandles();
		Iterator<String> itr = allwid.iterator();

		while (itr.hasNext()) {
			base.driver.switchTo().window(itr.next());
			String title = base.driver.getTitle();
			if (title.contains("Accounts&action")) {
				break;
			}
		}
		base.driver.findElement(By.id("search_txt")).sendKeys(orgName);
		base.driver.findElement(By.xpath("//input[@class=\"crmbutton small create\"]")).click();
		base.driver.findElement(By.xpath("//a[.='" + orgName + "']")).click();
		base.driver.switchTo().window(parentid);
	}

}



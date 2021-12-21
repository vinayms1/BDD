package StepDefination;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationTest {
	WebDriver driver;

	@Given("i will launch browser")
	public void i_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Given("enter the url")
	public void enter_the_url() {
		driver.get("http://localhost:8888/");
	}

	@When("Login page is displayed and i will enter username and password")
	public void login_page_is_displayed_and_i_will_enter_username_and_password() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.id("submitButton")).click();
	}

	@Then("i will navigate it will navigating to home page or not")
	public void i_will_navigate_it_will_navigating_to_home_page_or_not() {
//	 String text = driver.findElement(By.linkText("Test Yantra")).getText();
//	  Assert.assertTrue(text.contains("Test Yantra"));
		driver.close();
	}

	@Given("enter the url {string}")
	public void enter_the_url(String url) {
		driver.get(url);
	}

	@When("Login page is displayed and i will enter username {string} and password {string}")
	public void login_page_is_displayed_and_i_will_enter_username_and_password(String userName, String password) {
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
	}

	@When("home page is displayed")
	public void home_page_is_displayed() {
//	String text = driver.findElement(By.linkText("Test Yantra")).getText();
//	  Assert.assertTrue(text.contains("Test Yantra"));

	}

	@When("click on organisation")
	public void click_on_organisation() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
	}

	@When("click on create organization")
	public void click_on_create_organization() {
		driver.findElement(By.xpath("//*[@title=\"Create Organization...\"]")).click();
	}

	@Then("i will check whether i getting error msg or not")
	public void i_will_check_whether_i_getting_error_msg_or_not() {
		String actualErrorMsg = "You must specify a valid username and password";
		String expectedErrorMsg = driver.findElement(By.xpath("//*[@class=\"errorMessage\"]")).getText();
		Assert.assertEquals(actualErrorMsg.contains(expectedErrorMsg), true);
	}

	@When("enter organisation name {string} and click on save button")
	public void enter_organisation_name_and_click_on_save_button(String orgName) {

		int ram = new Random().nextInt(1000);
		driver.findElement(By.xpath("//*[@name=\"accountname\"]")).sendKeys(orgName + ram);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();

	}

	@Then("verify organization {string} is created or not")
	public void verify_organization_is_created_or_not(String orgName) {
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if (text.contains(orgName)) {
			System.out.println("organisation is created");
			driver.close();
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

		driver.findElement(By.xpath("//*[@name=\"accountname\"]")).sendKeys(orgName);
		driver.findElement(By.xpath("//*[@name=\"website\"]")).sendKeys(webSiteId);
		driver.findElement(By.xpath("//*[@name=\"phone\"]")).sendKeys(phoneNum);
		driver.findElement(By.xpath("//*[@name=\"employees\"]")).sendKeys(employee);
		Thread.sleep(3000);
	}

	@When("click on save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	}

	@Then("verify organisation name, phone, website, employees is created or not")
	public void verify_organisation_name_phone_website_employees_is_created_or_not() {
		String actOrgName = driver.findElement(By
				.xpath("//td[.=\"Organization Name\"]/following-sibling::td[@id=\"mouseArea_Organization Name\"]/span"))
				.getText();
		String ActualWebSite = driver
				.findElement(By.xpath("//td[.=\"Website\"]/following-sibling::td[@id=\"mouseArea_Website\"]/span"))
				.getText();
		String ActualPhoneNum = driver
				.findElement(By.xpath("//td[.=\"Phone\"]/following-sibling::td[@id=\"mouseArea_Phone\"]/span"))
				.getText();
		String ActualEmployeeNum = driver
				.findElement(By.xpath("//td[.=\"Employees\"]/following-sibling::td[@id=\"mouseArea_Employees\"]/span"))
				.getText();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(orgName.contains(actOrgName), true);
		sa.assertEquals(ActualWebSite.contains(webSiteId), true);
		sa.assertEquals(ActualPhoneNum.contains(phoneNum), true);
		sa.assertEquals(ActualEmployeeNum.contains(employee), true);
		driver.close();
		sa.assertAll();
	}

	@Then("Click on Contact module")
	public void click_on_contact_module() {
		driver.findElement(By.linkText("Contacts")).click();
	}

	@Then("Click on create contact")
	public void click_on_create_contact() {
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	}

	String FirstName;
	String LastName;
	String MobileNumber;
	String EmailId;

	@Then("enter frirstName, LastName, phoneNumber and emailId")
	public void enter_frirst_name_last_name_phone_number_and_email_id(io.cucumber.datatable.DataTable dataTable) {
		List<Map<Object, Object>> data = dataTable.asMaps(String.class, Object.class);
		FirstName = (String) data.get(0).get("frirstName");
		LastName = (String) data.get(0).get("LastName");
		MobileNumber = (String) data.get(0).get("phoneNumber");
		EmailId = (String) data.get(0).get("emailId");
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.name("mobile")).sendKeys(MobileNumber);
		driver.findElement(By.name("email")).sendKeys(EmailId);
	}

	@Then("click on save button in contact module")
	public void click_on_save_button_in_contact_module() {
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	}

	@Then("Verify frirstName, LastName, phoneNumber and emailId created or not")
	public void verify_frirst_name_last_name_phone_number_and_email_id_created_or_not() {
		String actualFirstName = driver
				.findElement(
						By.xpath("//td[text()=\"First Name\"]/following-sibling::td[@id=\"mouseArea_First Name\"]"))
				.getText();
		String ActualLastName = driver
				.findElement(By.xpath("//td[text()=\"Last Name\"]/following-sibling::td[@id=\"mouseArea_Last Name\"]"))
				.getText();
		String ActualMobileNumber = driver
				.findElement(By.xpath("//td[text()=\"Mobile\"]/following-sibling::td[@id=\"mouseArea_Mobile\"]"))
				.getText();
		String ActualEmailId = driver
				.findElement(By.xpath("//td[text()=\"Email\"]/following-sibling::td[@id=\"mouseArea_Email\"]"))
				.getText();
		SoftAssert as = new SoftAssert();
		as.assertEquals(FirstName.contains(actualFirstName), true);
		as.assertEquals(ActualLastName.contains(LastName), true);
		as.assertEquals(ActualMobileNumber.contains(MobileNumber), true);
		as.assertEquals(ActualEmailId.contains(EmailId), true);
		driver.close();
	}

}

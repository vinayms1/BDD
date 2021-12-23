package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernametextbox;

	@FindBy(name = "user_password")
	private WebElement passwordtextbox;

	@FindBy(id = "submitButton")
	private WebElement loginbutton;
	
	@FindBy(className="errorMessage")
	private WebElement errorMsgText;
	
	

	public WebElement getErrorMsgText() {
		return errorMsgText;
	}

	public WebElement getPasswordtextbox() {
		return passwordtextbox;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getUsernametextbox() {
		return usernametextbox;
	}
	
	public String getErrorMsg() {
		return errorMsgText.getText();
	}
	
	/**
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void login(String USERNAME, String PASSWORD) {
		usernametextbox.sendKeys(USERNAME);
		passwordtextbox.sendKeys(PASSWORD);
		loginbutton.click();
	}

}

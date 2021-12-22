package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Base;
import utility.FileUtility;

public class Hook {
	Base base;
	public Hook(Base base) {
		this.base=base;
	}
	
	@Before
	public void initBrowser() throws Throwable {
		String browserName=FileUtility.getValueFromPropertyFile("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		else {
			System.out.println("enter the valid browser name");
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
	
	@After
	public void quitBrowser() {
		base.driver.quit();
	}

}

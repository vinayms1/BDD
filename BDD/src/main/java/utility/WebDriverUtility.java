package utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/**
	 * it will provides the implicit wait
	 * 
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/**
	 * it will maximize the browser
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param element
	 * @param option
	 */
	public void Select(WebElement element, String option) {
		Select s = new Select(element);
		s.selectByVisibleText(option);
	}

	/**
	 * this method is used to switching the window
	 * 
	 * @param value
	 */

	public void switchToWindow(WebDriver driver, String value) {

		Set<String> allwid = driver.getWindowHandles();
		Iterator<String> itr = allwid.iterator();

		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String title = driver.getTitle();
			if (title.contains(value)) {
				break;
			}
		}
	}
}

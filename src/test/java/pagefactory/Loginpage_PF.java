package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage_PF {

	@FindBy(xpath = "//input[@id=\"userName\"]")
	WebElement txt_username;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement txt_password;

	@FindBy(xpath = "//button[@id=\"login\"]")
	WebElement btn_loginbutton;

	WebDriver driver;

	public Loginpage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_loginbutton.click();
	}

}

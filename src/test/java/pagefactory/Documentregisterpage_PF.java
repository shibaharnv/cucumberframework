package pagefactory;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Documentregisterpage_PF {

	StringBuffer randomString;

	String randomStringvalue;

	@FindBy(xpath = "//button[@data-automation-id='savedSearches-saveButton']")
	List<WebElement> btn_savesearchas;

	@FindBy(xpath = "//form[@id='create-saved-search-form']//input[contains(@class, 'auiField-input ng-pristine')]")
	WebElement txt_savesearchname;

	@FindBy(xpath = "//textarea[@class='auiField-input ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']")
	WebElement txt_savesearchdescription;

	@FindBy(xpath = "//input[@id='saveSearch-shareLevel-org']")
	WebElement btn_savesearchradiobutton;

	@FindBy(xpath = "//input[@title='Save']")
	WebElement btn_docregistersavebutton;

	@FindBy(xpath = "//div[@id='savedSearchButtonText']")
	WebElement btn_savedsearchbutton;

	@FindBy(xpath = "//div[@col-id='docno']")
	WebElement text_documentno;

	WebDriver driver;
	WebDriverWait wait;

	public Documentregisterpage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void savesearchas() throws InterruptedException {

		// wait.until(ExpectedConditions.visibilityOfAllElements(btn_savesearchas));
		btn_savesearchas.get(1).click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_savesearchname));
		randomstringgenration();

		txt_savesearchname.sendKeys(randomStringvalue);

		wait.until(ExpectedConditions.elementToBeClickable(txt_savesearchdescription));

		txt_savesearchdescription.sendKeys("savesearchdescription");

		wait.until(ExpectedConditions.elementToBeClickable(btn_savesearchradiobutton));

		btn_savesearchradiobutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_docregistersavebutton));

		btn_docregistersavebutton.click();

		wait.until(ExpectedConditions.elementToBeClickable(btn_savedsearchbutton));

		btn_savedsearchbutton.click();

		WebElement savedsearchnamelink = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(@class, 'ng-binding') and text() = '" + randomStringvalue + "']")));

		savedsearchnamelink.click();
		Thread.sleep(5000);

		System.out.println("Saved search name is " + randomStringvalue);

		wait.until(ExpectedConditions.elementToBeClickable(text_documentno));
		text_documentno.getText();

		String docunmentnumbertext = text_documentno.getText();

		System.out.println("saved search name " + randomString);

	}

	public StringBuffer randomstringgenration() {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();

		randomString = new StringBuffer();

		for (int i = 0; i < 5; i++) {

			int number = random.nextInt(base.length());
			randomString.append(base.charAt(number));
			System.out.println(randomString);

		}

		System.out.println("Random String " + randomString);

		randomStringvalue = randomString.toString();

		return randomString;
	}

}
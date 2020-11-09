package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aconexhomepage_PF {

	@FindBy(xpath = "//div[contains(@class, 'uiButton-label') and text() = 'Mail']")
	WebElement link_mailtab;

	@FindBy(xpath = "//div[@id=\"nav-bar-CORRESPONDENCE-CORRESPONDENCE-CREATEMAIL\"]")
	WebElement link_blankmail;

	@FindBy(xpath = "//div[contains(@class, 'uiButton-label') and text() = 'Documents']")
	WebElement documenttab;

	@FindBy(xpath = "//div[contains(@id, 'nav-bar-DOC-DOC-SEARCH') and text() = 'Document Register']")
	WebElement link_documentregister;

	@FindBy(xpath = "//div[@id='nav-bar-DOC-DOC-NEW']")
	WebElement uploadnewdoclink;

	WebDriver driver;
	WebDriverWait wait;

	public Aconexhomepage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void mailtabclick() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(link_mailtab));
		link_mailtab.click();
	}

	public void blankmailclick() {
		wait.until(ExpectedConditions.elementToBeClickable(link_blankmail));
		link_blankmail.click();
	}

	public void opennewdocumentuploadpage() {
		wait.until(ExpectedConditions.elementToBeClickable(documenttab));
		documenttab.click();
		wait.until(ExpectedConditions.elementToBeClickable(uploadnewdoclink));
		uploadnewdoclink.click();
	}

	public void opendocregisterpage() {
		wait.until(ExpectedConditions.elementToBeClickable(documenttab));
		documenttab.click();
		wait.until(ExpectedConditions.elementToBeClickable(link_documentregister));
		link_documentregister.click();
	}

}

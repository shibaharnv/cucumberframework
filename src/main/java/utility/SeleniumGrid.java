package utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) throws MalformedURLException {

		// Desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		// Chrome options:

		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		String huburl = "http://localhost:4444/wd/hub";

		WebDriver driver = new RemoteWebDriver(new URL(huburl), options);

		driver.get("https://qa122.aconex.com/Logon");

		driver.quit();
	}
}

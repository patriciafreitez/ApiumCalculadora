package resources;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Configuracion {
	
	public WebDriver driverConnection() throws Exception {
		DesiredCapabilities cap	= new DesiredCapabilities();
		cap.setCapability( "platformVersion", "10");
		cap.setCapability("UDID", "R9JN40XW82J");
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("noReset", true);
		WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
 }
}

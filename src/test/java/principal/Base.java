package principal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import report.DateManager;
import report.ReportManager;


public class Base {
	
	private ReportManager reportManager;
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		 this.driver = driver;
		reportManager = new ReportManager();
	 }
	 
	 public WebElement find(By locator) {
		 return driver.findElement(locator);
	 }
	 public List<WebElement> findList(By locator){
		 return driver.findElements(locator);
	 }
	 
	 public String getTextElement(WebElement element) {
		 return element.getText();
	 }
	 
	 public String getText (By locator) {
		String text = null;
		try {
			 text = driver.findElement(locator).getText();
			 reportManager.registerEvent("getText element " + locator.toString(), "ok");
		} catch (Exception e) {
			 reportManager.registerEventWithMessage("getText element " + locator.toString(), "error", e.getMessage());
	 	}
		return text;
	 }
	 public void sleep (int segundos) {
		  try {
			Thread.sleep(segundos * 1000);
			reportManager.registerEvent("sleep " + segundos, "ok");
		} catch (InterruptedException e) {
			e.printStackTrace();
			 reportManager.registerEventWithMessage("sleep " + segundos, "error", e.getMessage());
		}

	 }

	 public void type(String inputText, By locator) {
		 driver.findElement(locator).sendKeys(inputText);
	 }   
	 
	 public void typeEnter(String inputText, By locator) {
		 driver.findElement(locator).sendKeys(inputText + Keys.ENTER);
	 }
	 
	 public void enter(By locator) {
		 driver.findElement(locator).sendKeys(Keys.ENTER);
	 }

	 public void click(By locator) {
		 try {
			 driver.findElement(locator).click();
			 reportManager.registerEventWithScreenShot("click element " + locator.toString(), "ok", takeScreenShot());
		 } catch (Exception e) {
			 reportManager.registerEventWithMessage("click element " + locator.toString(), "error", e.getMessage());
		}		 
	 }
	 public Boolean isDisplayed(By locator) {
		 try {
			 return driver.findElement(locator).isDisplayed();
		 } catch (org.openqa.selenium.NoSuchElementException e) {
			 return false;
		 }
	 }
	 public void visit(String url) {
		 driver.get(url);
	 }
	 
	 @SuppressWarnings("deprecation")
	public void wait(final By locator) { 
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				 .withTimeout(10, TimeUnit.SECONDS)
				 .pollingEvery(2, TimeUnit.SECONDS)
				 .ignoring(NoSuchElementException.class);
		 
		fwait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
				 return driver.findElement(locator);
			 }
		});
	 }
	 
	 public String takeScreenShot() {
		DateManager dateManager = new DateManager();
		 String scrShotDir = ReportManager.TEST_PATH;
		 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 new File(scrShotDir + "/screenshots").mkdirs();
		 String destFile = "screenshots/" + dateManager.getDirDate() + ".png";
		 try {
			 FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 return destFile;
	 }
		    
}


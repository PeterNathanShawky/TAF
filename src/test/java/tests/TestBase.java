package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String downPath = System.getProperty("user.dir")+"\\Downloads";

	public static ChromeOptions setChrome()
	{
		ChromeOptions dd = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_setting.popups", 0);
		chromePrefs.put("download.default_directory", downPath);
		dd.setExperimentalOption("prefs", chromePrefs);
		dd.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return dd;
	}
	
	public static FirefoxOptions setFirefox()
	{
		FirefoxOptions dd = new FirefoxOptions();
		dd.addPreference("browser.download.folderList", 2);
		dd.addPreference("browser.download.dir", downPath);
		dd.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); //it may include many comma separated data types parameters
		dd.addPreference("browser.download.manager.showWhenStarting", false);
		dd.addPreference("pdfjs.disabled", true);
		return dd;
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
			driver= new ChromeDriver(setChrome());
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");
			driver= new FirefoxDriver(setFirefox());
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Resources\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir")+"/Resources/phantomjs.exe");
			String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomJsArgs);
			driver= new PhantomJSDriver(caps);
		}
		else if (browserName.equalsIgnoreCase("chrome-headless"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver= new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed !!!");
			System.out.println("Taking screenshot ...");
			try {
				Helper.takescreenShots(driver, result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
}
package OrangeHRM.DemoApplication.pages.Common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.Scenario;

public class OrangeHRM_DemoApplication_SharedResources {
	
	public static ThreadLocal<WebDriver> Tdriver = new ThreadLocal<WebDriver>();
	public static boolean performAppLaunch;
	
	@Before
	public void beforeTest(Scenario scenario) throws IOException
	{
		OrangeHRM_DemoApplication_Utility.ReadProperties();
		WebDriver driver;
		//System.out.println("Hold");
		try
		{
/*			if(!getDriver().toString().contains(null))
			{
				performAppLaunch = false;
				return;
			}*/
			if(getDriver().toString().equals(null))
			{
				performAppLaunch = true;
			}
			else
			{
				performAppLaunch = false;
				return;
			}
		}catch(Exception e)
		{
			driver=null;
			performAppLaunch = true;
			System.out.println("Driver set to null");
		}		
		String myBrowser = 	OrangeHRM_DemoApplication_Utility.pf.getProperty("Browser");
		String appURL = OrangeHRM_DemoApplication_Utility.pf.getProperty("testAppUrl");
		System.out.println("-----------*** BeforeTest Running ***--------------------------------------");
		System.out.println("-----------*** Running Scenario   ***"+scenario.getName()+"----------------");
		driver=null;
		if(myBrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to(appURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		else if(myBrowser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+" \\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.navigate().to(appURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver()
	{
		return Tdriver.get();
	}
	
	public void setWebDriver(WebDriver driver)
	{
		Tdriver.set(driver);
	}
	@After
	public void afterTest(Scenario scenario)
	{
		includeSnapshot(scenario);
		System.out.println("------------- After Test Running ---------------");
	}
	public void includeSnapshot(Scenario scenario)
	{
		scenario.write("scenario completed");
		if(scenario.isFailed())
		{
			scenario.embed(((TakesScreenshot) ((Object) getDriver())).getScreenshotAs(OutputType.BYTES), "image/png");
		}
	}
}



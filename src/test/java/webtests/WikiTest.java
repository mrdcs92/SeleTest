package webtests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.MainWiki;

public class WikiTest {

	public static MainWiki wiki;
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		wiki = new MainWiki(driver);
		//driver.get("https://www.wikipedia.org/");
	}
	
	@BeforeMethod
	public void goToMainPage() {
		driver.get("https://www.wikipedia.org/");
	}
	
	@Test(priority = 1)
	public void deutsch() {
		wiki.getDuestch().click();
		Assert.assertEquals(driver.getTitle(), "Wikipedia – Die freie Enzyklopädie");
	}
	
	@Test(priority = 2)
	public void italian() {
		wiki.getItalian().click();
		Assert.assertEquals(driver.getTitle(), "Wikipedia, l'enciclopedia libera");
	}
	
	@Test(priority = 3)
	public void espanol() {
		wiki.getEspanol().click();
		Assert.assertEquals(driver.getTitle(), "Wikipedia, la enciclopedia libre");
	}
	
	@Test(groups = "smoke")
	public void hello() {
		System.out.println("Hola from WikiLang");
	}
	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}

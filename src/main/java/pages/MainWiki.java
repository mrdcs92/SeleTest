package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainWiki {
	public static WebDriver driver;
	
	public MainWiki(WebDriver driver) {
		MainWiki.driver = driver;
	}
	
	public WebElement getSearchBar() {
		return driver.findElement(By.name("search"));
	}
	
	public WebElement getDuestch() {
		return driver.findElement(By.id("js-link-box-de"));
	}
	
	public WebElement getItalian() {
		return driver.findElement(By.xpath("//*[@id=\"js-link-box-it\"]"));
	}
	
	public WebElement getEspanol() {
		return driver.findElement(By.cssSelector("div[lang='es']"));
	}
}

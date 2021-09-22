import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.kiddopia.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		WebElement Accept = driver.findElement(By.xpath("//*[@id=\"iubenda-cs-banner\"]/div/div/div/div[2]/div[2]/button"));
		Accept.click();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0,0)");

		WebElement StartFreeTrail = driver.findElement(By.xpath("//*[@id=\"start-trial-bttn\"]"));
		ClickOn(driver, StartFreeTrail, 5);
		driver.navigate().back();

		WebElement RedeemGift = driver.findElement(By.xpath("//*[@id=\"navbarController\"]/ul/li[1]/a"));
		ClickOn(driver, RedeemGift, 5);
		driver.navigate().back();

		WebElement Blog = driver.findElement(By.xpath("//*[@id=\"navbarController\"]/ul/li[3]/a"));
		ClickOn(driver, Blog, 5);
		driver.navigate().back();

		WebElement SignIn = driver.findElement(By.xpath("//*[@id=\"navbarController\"]/ul/li[4]/a"));
		ClickOn(driver, SignIn, 5);
		driver.navigate().back();

		WebElement AboutUS = driver.findElement(By.xpath("//*[@id=\"navbarController\"]/ul/li[2]/a"));
		ClickOn(driver, AboutUS, 5);
		driver.navigate().back();

	}

	public static void ClickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

}

package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitialisation {
	WebDriver driver;
	public static Properties properties;

	public WebDriver driverInitialise() throws IOException {
		FileInputStream inputFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		properties = new Properties();
		properties.load(inputFile);
		String browser = properties.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-automation");
			if (browser.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe"));
			driver = new FirefoxDriver();
			driver.get(properties.getProperty("url"));
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}

}

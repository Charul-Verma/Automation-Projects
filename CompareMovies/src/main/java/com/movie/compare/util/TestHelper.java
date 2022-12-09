package com.movie.compare.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

public class TestHelper {

	protected static WebDriver driver;
	protected static Properties properties;
	protected static EventFiringWebDriver e_driver;
	protected static ChromeOptions chromeOptions;
	protected static Logger log;

	public TestHelper() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/movie/compare/config/config.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File does not exists");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}

	protected static void initializaton() {
		String browserName = properties.getProperty("browser");
		driver = getDriver(browserName);
		System.out.println(browserName + " is launching");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}

	protected static void openURL(String url) {
		driver.get(properties.getProperty(url));
		System.out.println("Opening URL : " + url);
	}

	private static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			return new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
	}

	public void tearDownMain() {
		driver.close();
	}
}

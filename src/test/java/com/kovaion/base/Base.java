package com.kovaion.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
WebDriver driver;
public Properties prop ;

public Base () {
	 
	  prop = new Properties();
		File propFile = new File (System.getProperty("user.dir")+"\\src\\main\\java\\com\\kovaion\\properties\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	}catch(Throwable e) {
		e.printStackTrace();
	}
		}


	public WebDriver initializeBrowserAndOpenApplicationURl(String browsername) {
		  
		 String BrowserName="chrome";
		 
		 if (BrowserName.equalsIgnoreCase("chrome"))
		 {
			driver = new ChromeDriver();
		 }
		 else if(BrowserName.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else if (BrowserName.equalsIgnoreCase("edge"))
		 {
			 driver = new EdgeDriver();
		 }
		 else if(BrowserName.equalsIgnoreCase("safari"))
		 {
			 driver = new SafariDriver();
		 }
			driver.get(prop.getProperty("URL"));
		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
	return driver;

}}

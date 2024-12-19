package com.kovaion.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kovaion.base.Base;

public class Login extends Base {	 			
	
	public Login () {
		super();
	}
	WebDriver driver;
 	
	@BeforeMethod
	public void Starting(){
		driver=initializeBrowserAndOpenApplicationURl(prop.getProperty("Browser"));
	}
	
	@AfterMethod
	public  void TearDown() 
	{
	 driver.quit();	
	 }
	
	@Test(priority=1)
	public void verify_login_with_valid_credentials()
	{
    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("ValidEmail"));
    driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login with OTP")));
    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("ValidPassword"));
    driver.findElement(By.xpath("(//span[contains(@class,'MuiButton-icon MuiButton-startIcon')])[2]")).click();
    
	String Actualtext = driver.findElement(By.xpath("//div[@class='text-part']//h6[1]")).getText();
	String Expectedtext ="Welcome user! Create your own application";
    Assert.assertTrue(Actualtext.contains(Expectedtext),"Nothing found ");  

}
	@Test(priority=2)
	public void Verify_login_with_InvalidEmail () {
		
	    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("InvalidEmail"));
	    driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]")).click();
	    
		String Actualtext = driver.findElement(By.xpath("//div[contains(@class,'SnackbarItem-message')]")).getText();
		String Expectedtext ="No User Found";
	    Assert.assertTrue(Actualtext.contains(Expectedtext),"Nothing found ");   
		
	}
	@Test(priority=3)
	public void Verify_login_with_validEmail_and_Invalid_password () {
		
	    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("ValidEmail"));
	    driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login with OTP")));
	    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("InvalidPassword"));
	    driver.findElement(By.xpath("(//span[contains(@class,'MuiButton-icon MuiButton-startIcon')])[2]")).click();
	    
		String Actualtext = driver.findElement(By.xpath("//div[contains(@class,'SnackbarItem-message')]")).getText();
		System.out.println(Actualtext);
		String Expectedtext ="Invalid Credentials!!!";
	    Assert.assertTrue(Actualtext.contains(Expectedtext),"Nothing found ");  

	}
	@Test(priority=3)
	public void Verify_login_with_validEmail_and_password_with_whitespaces () {
		
	    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("ValidEmail"));
	    driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login with OTP")));
	    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys("Kovaion@123  ");
	    driver.findElement(By.xpath("(//span[contains(@class,'MuiButton-icon MuiButton-startIcon')])[2]")).click();
	    
		String Actualtext = driver.findElement(By.xpath("//div[contains(@class,'SnackbarItem-message')]")).getText();
		String Expectedtext ="Invalid Credentials!!!";
	    Assert.assertTrue(Actualtext.contains(Expectedtext),"Nothing found ");  
	    
        }
	
	@Test(priority=4)
	public void Verify_login_with_mobile_number () {
		
	    driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys(prop.getProperty("phonenumber"));
	    driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]")).click();
	    
		String Actualtext = driver.findElement(By.xpath("//div[contains(@class,'SnackbarItem-message')]")).getText();
		String Expectedtext ="No User Found";
	    Assert.assertTrue(Actualtext.contains(Expectedtext),"Nothing found ");   
	    }

			
		//Verifying Empty field submissions and form validation.
		@Test(priority=5)
		public void Verify_login_by_empty_email () {
		    WebElement element = driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]"));
		    element.click();
			String Actualtext = driver.findElement(By.xpath("//div[contains(@class,'SnackbarItem-message')]")).getText();
			String Expectedtext ="Invalid Email";
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    Assert.assertTrue(Actualtext.contains(Expectedtext),"Nothing found ");   

		    }		
}

		




	
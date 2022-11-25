package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;


public class BaseHRMClass {
     
	  public static Properties prop = new Properties();
	  public static  WebDriver driver;     // Reference variable for browser
	  
	  //STEP 1 - CREATE CONSTRUCTOR 
	  public BaseHRMClass() {
	  
		  try {
	  FileInputStream file = new FileInputStream("C:\\Users\\14373\\Desktop\\Eclipse Workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.Properties");
	  prop.load(file);
			  
	  	     }
		  catch(FileNotFoundException e) {
			 e.printStackTrace();  
		     }
	      catch(IOException a) {
	    	  a.printStackTrace();
	      }}
	  
	  // STEP 2 - COMMON COMMANDS
		  public static void initiate() {
			  String browsername = prop.getProperty("browser");
			  
			  			  
		 if (browsername.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			 driver = new ChromeDriver();}
		 
		  else if (browsername.equals("Firefox")) {
			  System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		      driver = new FirefoxDriver();}
		 
	      driver.manage().window().maximize();
	      driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage,TimeUnit.SECONDS);
	      driver.get(prop.getProperty("url")); 
		  }
		  
		  public static void screenshots(String Filename) {
			 File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 try {
			 FileUtils.copyFile(file, new File ("C:\\Users\\14373\\Desktop\\Eclipse Workspace\\HRmanagement\\src\\test\\java\\Screenshots\\Screenshots"+Filename+".jpg"));
		  }
	      catch(IOException e) {
	    	  e.printStackTrace();
	      }
}}



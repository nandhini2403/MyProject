package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseHRMClass;
import pompackage.PomLogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMClass{
	
	PomLogin Log;
	public LoginTest () {
		
		//SUPER keyword is used to call the constructor of parent class and all its properties.
		super();
		
	}
	
	@BeforeMethod
	public void initsetup() {
		initiate();
	
			Log=new PomLogin(); 
	
		
	}
	
	@Test (priority=1)
	  public void TitleTestCase() {
	  String actual=Log.verify(); Assert.assertEquals(actual,"OrangeHRM");
	  
	  }
	 

	  @DataProvider 
	  public Object[][] Details()
	  { 
		  Object result[][]=Excelsheet.readdata("Sheet1");
	      return result;

	  	
	  }
	  
	  @Test (priority=2, dataProvider="Details")
	  public void Login(String name,String password) throws InterruptedException{ 
	      Thread.sleep(5000);
			screenshots("Login.jpg");
		  Log.typeusername(name);
	      Log.typepassword(password); //Log.clickbtn();


	  }
	  
		
		
		
		  @AfterMethod public void close() {
		  System.out.println("inside close  method"); driver.close();
		  System.out.println("completing close  method"); }
		 
		 
  
  
  }
 
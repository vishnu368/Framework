package com.mckesson.suite.QsymiaOutpatientPharmacy;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


import com.mckesson.util.ErrorUtil;
import com.mckesson.util.TestUtil;

public class QsymiaOutpatientPharmacyTest extends TestSuiteBase {
	String runmodes[]=null;
	static int count=-1;
	//static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private void acknowledgement(String firstname,String lastname) throws InterruptedException {
	
	
		driver.findElement(By.name("signatureFullName")).sendKeys(firstname+" "+lastname);
	
		/*driver.findElement(By.name("signatureFullName")).sendKeys("  ");
		Thread.sleep(3000);
	
		driver.findElement(By.name("signatureFullName")).sendKeys(dataTable.getData("RegisterUser_Data","LastName"));*/
	
		driver.findElement(By.id("JavaDateTextBox_0")).sendKeys("08/18/2017");
	
		Thread.sleep(2000);
	
	
	
		driver.findElement(By.name("attestation")).click();
	
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='submitAttestationDiv']/button")).click();
	}
	 
	// Runmode of test case in a suite
	
	@BeforeTest
	public void checkTestSkip(){
		
		if(!TestUtil.isTestCaseRunnable(suite_QsymiaOutpatientPharmacy_xls,this.getClass().getSimpleName())){
			APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
			throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
		}
		// load the runmodes off the tests
		runmodes=TestUtil.getDataSetRunmodes(suite_QsymiaOutpatientPharmacy_xls, this.getClass().getSimpleName());
	}
		
		
	@Test(dataProvider = "getTestData120")
	public void QsymiaOutpatientPharmacy(String First_Name9,String Last_Name9,String Email_Address9,
			String Username9,String Password9,String Confirm_Password9,String Outpatient_Phone_Number9,String Outpatient_Fax_Number9,
			String Outpatient_Pharmacy_Name9,String Outpatient_Pharmacy_Zip_Code9,String npi9,String ncpdp9,String dea9,
			String Outpatient_Pharmacy_Name10,String Outpatient_addressLine9,String Outpatient_City9,String Outpatient_stateCode9,
			String Outpatient_pharmacyPhoneNumber9,String Outpatient_dijit_form_ValidationTextBox_09,
			String Outpatient_JavaDateTextBox_09, String preferredContactMethodCode,String ChainID,String addressLine2) throws InterruptedException{
		
		//wait=new WebDriverWait(driver,10);
		APP_LOGS.debug("Starting the Qsymia Outpatient Pharmacy  test");		
		openBrowser();
	    driver.get(CONFIG.getProperty("testSiteName2"));
	    getObject("Create_My_Account").click();
	    //driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr/td/div/div[1]/button")).click();
	    //driver.findElement(By.cssSelector("small")).click();
	    APP_LOGS.debug("Entering the QsymiaOutpatientPharmacy parameters");
	    Thread.sleep(3000);
	    driver.findElement(By.id("firstName")).click();
	    getObject("First_Name").sendKeys(First_Name9);
		getObject("Last_Name").sendKeys(Last_Name9);
		getObject("Email_Address").sendKeys(Email_Address9);
		getObject("Username").sendKeys(Username9);
		getObject("Password").sendKeys(Password9);
		getObject("Confirm_Password").sendKeys(Confirm_Password9);
		driver.findElement(By.xpath(".//*[@id='createAccountDiv']/button")).click();
	
		
	driver.findElement(By.xpath("//*[@id='corporaterepresentative']")).click();
	
		driver.findElement(By.xpath("//*[@id='confirmDiv']/button")).click();
	
		Thread.sleep(20000);
	
       driver.findElement(By.xpath("//*[@id='chainPharmacyRole']/table/tbody/tr[5]/td/button[2]")).click();
       
   	
  
		driver.findElement(By.id("phoneNumber")).sendKeys(Outpatient_Phone_Number9);
	
		driver.findElement(By.id("faxNumber")).sendKeys(Outpatient_Fax_Number9);
	
		driver.findElement(By.id("preferredContactMethodCode")).sendKeys(preferredContactMethodCode);
	
		Thread.sleep(10000);
	
		driver.findElement(By.id("corporateRegistration.chainId")).sendKeys(ChainID);
	
	
		driver.findElement(By.id("addChainIdButton")).click();
	
		Thread.sleep(7000);
	
		

		driver.findElement(By.cssSelector("#sowNotSigned .enableButton")).click();
	       Thread.sleep(7000);
	       

	       driver.findElement(By.cssSelector("#registrationSubmitReminder .enableButton ")).click();                                               		
	                Thread.sleep(2000);  
	              
	             driver.findElement(By.xpath("//*[@id=\'addChainIdButton\']")).click();  
	          
	     
driver.findElement(By.xpath("//div[@id='submitRegistrationDiv']/button[@id='addChainIdButton']")).click();	
	
		Thread.sleep(7000);
		

	driver.findElement(By.id("addressLine2")).sendKeys(addressLine2);
	
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='enrollmentSubmitDiv']/button")).click();
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		try {
			if ( driver.findElement(By.id("responseMessage")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='enrollmentSubmitDiv']/button")).click(); 
			}
		}
		catch(Exception e) {
	
		}
	
	
		Thread.sleep(7000);

		driver.findElement(By.xpath("//*[@id='educationDiv']/button")).click();
		driver.findElement(By.xpath("//*[@id='submitButtonDiv']/button")).click();
	
		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
	
		Thread.sleep(10000);
	
		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
		Thread.sleep(7000);
	

	
		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
	
		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
		Thread.sleep(7000);
	
	
	
		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
		Thread.sleep(7000);
	

		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
	
		driver.findElement(By.xpath("//*[@id='continueButtonDiv']/button")).click();
		
		
		driver.findElement(By.id("kaButton")).click();
	


		Thread.sleep(10000);

		List<WebElement> Radio1 = driver.findElements(By.name("userAnswered"));
		Radio1.get(0).click();
		driver.findElement(By.id("renderer.nextButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


		Thread.sleep(10000);


		List<WebElement> Radio2 = driver.findElements(By.name("userAnswered"));
		Radio2.get(1).click();
		driver.findElement(By.id("renderer.nextButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


		Thread.sleep(10000);

		List<WebElement> Radio3 = driver.findElements(By.name("userAnswered"));
		Radio3.get(0).click();
		driver.findElement(By.id("renderer.nextButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();

		Thread.sleep(10000);

		List<WebElement> Radio4 = driver.findElements(By.name("userAnswered"));
		Radio4.get(1).click();
		driver.findElement(By.id("renderer.nextButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


		Thread.sleep(10000);



		List<WebElement> Radio5 = driver.findElements(By.name("userAnswered"));
		Radio5.get(0).click();
		driver.findElement(By.id("renderer.nextButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();

		
       List<WebElement> Radio6 = driver.findElements(By.name("userAnswered"));
		Radio6.get(1).click();
		driver.findElement(By.id("renderer.nextButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();

		Thread.sleep(10000);


		List<WebElement> Radio7 = driver.findElements(By.name("userAnswered"));
		Radio7.get(0).click();

		driver.findElement(By.id("renderer.submitButton")).click();

		driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();

		Thread.sleep(7000);
		boolean flag =false;
		try {
			if(driver.findElement(By.id("continueButton")).isDisplayed()) {
				/*wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("continueButton"))));*/
				driver.findElement(By.id("continueButton")).click();
				flag=true;
			}
		}
		catch (Exception e) {

		}
		
		if(flag){
			acknowledgement(First_Name9,Last_Name9);
		}

		else {
			Thread.sleep(7000);
			driver.findElement(By.xpath("//*[@id='pageBodyContent']/fieldset/table/tbody/tr[10]/td[5]/a")).click();



			Thread.sleep(10000);

			List<WebElement> Radio8 = driver.findElements(By.name("userAnswered"));
			Radio1.get(0).click();
			driver.findElement(By.id("renderer.nextButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


			Thread.sleep(10000);


			List<WebElement> Radio9 = driver.findElements(By.name("userAnswered"));
			Radio2.get(1).click();
			driver.findElement(By.id("renderer.nextButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


			Thread.sleep(10000);

			List<WebElement> Radio10 = driver.findElements(By.name("userAnswered"));
			Radio3.get(0).click();
			driver.findElement(By.id("renderer.nextButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();

			Thread.sleep(10000);

			List<WebElement> Radio11 = driver.findElements(By.name("userAnswered"));
			Radio4.get(1).click();
			driver.findElement(By.id("renderer.nextButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


			Thread.sleep(10000);



			List<WebElement> Radio12 = driver.findElements(By.name("userAnswered"));
			Radio5.get(0).click();
			driver.findElement(By.id("renderer.nextButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();



			List<WebElement> Radio13 = driver.findElements(By.name("userAnswered"));
			Radio6.get(1).click();
			driver.findElement(By.id("renderer.nextButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();


			Thread.sleep(10000);


			List<WebElement> Radio14 = driver.findElements(By.name("userAnswered"));
			Radio7.get(0).click();

			driver.findElement(By.id("renderer.submitButton")).click();

			driver.findElement(By.xpath("//*[@id='dijit_form_Button_0_label']")).click();



		
			driver.findElement(By.id("continueButton")).click();

			Thread.sleep(7000);
			
			driver.findElement(By.id("continueButton")).click();
			acknowledgement(First_Name9,Last_Name9);
			
		}




		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='sowNotSignedEnrollmentComplete']/table/tbody/tr[7]/td/button")).click();


	
	
		
	//closeBrowser();*/
	}
	
	
	@AfterMethod 
	private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }

	@DataProvider
	public Object[][] getTestData120(){

		return TestUtil.getData(suite_QsymiaOutpatientPharmacy_xls, this.getClass().getSimpleName());
	}

	@AfterMethod
	public void reportDataSetResult(){
		if(skip)
			TestUtil.reportDataSetResult(suite_QsymiaOutpatientPharmacy_xls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if(fail){
			isTestPass=false;
			TestUtil.reportDataSetResult(suite_QsymiaOutpatientPharmacy_xls, this.getClass().getSimpleName(), count+2, "FAIL");
		}
		else
			TestUtil.reportDataSetResult(suite_QsymiaOutpatientPharmacy_xls, this.getClass().getSimpleName(), count+2, "PASS");
		
		skip=false;
		fail=false;
		

	}
	
	@AfterTest
	public void reportTestResult(){
		if(isTestPass)
			TestUtil.reportDataSetResult(suite_QsymiaOutpatientPharmacy_xls, "Test Cases", TestUtil.getRowNum(suite_QsymiaOutpatientPharmacy_xls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suite_QsymiaOutpatientPharmacy_xls, "Test Cases", TestUtil.getRowNum(suite_QsymiaOutpatientPharmacy_xls,this.getClass().getSimpleName()), "FAIL");
	
	}
	

}


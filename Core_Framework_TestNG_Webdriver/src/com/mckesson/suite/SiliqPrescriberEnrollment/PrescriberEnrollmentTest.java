package com.mckesson.suite.SiliqPrescriberEnrollment;


import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
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

public class PrescriberEnrollmentTest extends TestSuiteBase {
	String runmodes[]=null;
	static int count=-1;
	//static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	// Runmode of test case in a suite
	
	@BeforeTest
	public void checkTestSkip(){
		
		if(!TestUtil.isTestCaseRunnable(suite_PrescriberEnrollment__xls,this.getClass().getSimpleName())){
			APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
			throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
		}
		// load the runmodes off the tests
		runmodes=TestUtil.getDataSetRunmodes(suite_PrescriberEnrollment__xls, this.getClass().getSimpleName());
	}
	
	
	@Test(dataProvider = "getTestDatasiliq")
	public void testRegistration(String NPI,String FirstName,String LastName,String EmailAddress,String UserID,String Password,
			String VerifyPassword,String FaxNumber,String NationalProviderIdentifier,String DEARegistrationNumber,
			String StateLicenseNumber,String TestCenter,String Number1,String Address,String State,String Zip,
			String Prescriber_Signature5,String Prescriber_Date5,String Signature,String NameofInstitution ) throws IOException, InterruptedException{
		APP_LOGS.debug("Starting the Prescriber Registration  test");
		openBrowser();
	    driver.get(CONFIG.getProperty("testSiteName"));
	 
	    driver.manage().window().maximize();
		getObject("siliq_start_pres_cert").click();
	   
		APP_LOGS.debug("Entering the registration parameters");
		getObject("siliq_pres_enroll_NPI").sendKeys(NPI);
		getObject("siliq_pres_enroll_fisrtname").sendKeys(FirstName);
		getObject("siliq_pres_enroll_lastname").sendKeys(LastName);
		getObject("siliq_pres_enroll_searchbutton").click();
		Thread.sleep(5000);
		getObject("siliq_pres_enroll_Newuserbutton").click();
		getObject("siliq_pres_enroll_Create_firstname").sendKeys(FirstName);
	    getObject("siliq_pres_enroll_Create_lastname").sendKeys(LastName);
		getObject("siliq_pres_enroll_Create_Email").sendKeys(EmailAddress);
		getObject("siliq_pres_enroll_Create_ConfirmEmail").sendKeys(EmailAddress);
		getObject("siliq_pres_enroll_Create_Phonenumber").sendKeys(Number1);
		getObject("siliq_pres_enroll_Create_Username_asEmailID").click();
		getObject("siliq_pres_enroll_Create_Password").sendKeys(Password);
		getObject("siliq_pres_enroll_Create_ConfirmPassword").sendKeys(VerifyPassword);
		//getObject("siliq_pres_enroll_Create_Recapcha").click();
		Thread.sleep(30000);
		getObject("siliq_pres_enroll_Create_submitbutton").click();
		
	    Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='hcp.professionalCredentialCode']")));
		dropdown.selectByIndex(2);
		
		Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id='hcp.specialtyCode']")));
		dropdown1.selectByIndex(2);
		 getObject("siliq_pres_enroll_Intake_NamofInstitution").sendKeys(NameofInstitution);
		 getObject("siliq_pres_enroll_Intake_StreetAddress").sendKeys(Address);
		 
		 getObject("siliq_pres_enroll_Intake_OfficeFaxNumber").sendKeys("7894567896");
		 Select dropdown2 = new Select(getObject("siliq_pres_enroll_Intake_PreferredMethodofCommunication"));
		 dropdown2.selectByIndex(2);
		 getObject("siliq_pres_enroll_Intake_Zipcode").sendKeys("85032");
		 getObject("siliq_pres_enroll_Intake_NPINumber").sendKeys(NPI);
		 Thread.sleep(5000);
		 getObject("siliq_pres_enroll_Intake_Nextbutton").click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/button[2]/span")).click();
		 getObject("siliq_pres_enroll_Attestation_Checkbox").click();
		 getObject("siliq_pres_enroll_Attestation_Signature").sendKeys(Signature);
		 getObject("siliq_pres_enroll_Attestation_SignatureDate").click();
		 Thread.sleep(3000);
		 getObject("siliq_pres_enroll_Attestation_SignatureDate_CurrentDate").click();
		 getObject("siliq_pres_enroll_Attestation_NextButton").click();
		/*getObject("Email_Address").sendKeys(EmailAddress);
		getObject("Already_enrolled").click();
		getObject("User_ID").sendKeys(UserID);
		getObject("Password").sendKeys(Password);
		getObject("Verify_Password").sendKeys(VerifyPassword);
		getObject("Create_My_Account").click();
		getObject("Prescriber_Option").click();
		getObject("Continue_Button").click();
		getObject("Fax_Number").sendKeys(FaxNumber);
		getObject("Preferred_Method_Of_Communication").click();
		getObject("Email_Selection").click();
	    getObject("National_Provider_Identifier").sendKeys(NationalProviderIdentifier);
		getObject("ADD1_Button").click();
	    getObject("DEA_Registration_Number").sendKeys(DEARegistrationNumber);
		getObject("ADD2_Button").click();
		getObject("State_License_Number").sendKeys(StateLicenseNumber);
		getObject("State_Issued").click();
		getObject("Dropdown_Option_Selected3").click();
		
	    getObject("ADD3_Button").click();
	    driver.findElement(By.cssSelector("td > button.pinkButtonFinger")).click();
	    driver.findElement(By.cssSelector("button.pinkButtonFinger")).click();
	   
		
		
		getObject("TextBox1").sendKeys(TestCenter);
		getObject("TextBox2").sendKeys(Number1);
		getObject("TextBox3").sendKeys(Address);
		getObject("TextBox4").sendKeys(State);
		getObject("DROPDOWN10").click();
		getObject("SELECTSTATE").click();
		getObject("TextBox5").sendKeys(Zip);
		 driver.findElement(By.id("addButton")).click();
		    driver.findElement(By.cssSelector("#enrollmentSubmitDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueButtonDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.id("kaButton")).click();
		    driver.findElement(By.id("renderer.answer66601")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66606")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66612")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66614")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66619")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66623")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66626")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66631")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66636")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66640")).click();
		    driver.findElement(By.id("renderer.nextButton")).click();
		    driver.findElement(By.id("renderer.answer66642")).click();
		    driver.findElement(By.id("renderer.submitButton")).click();
		    driver.findElement(By.id("continueButton")).click();
		    getObject("Prescriber_Signature5").sendKeys(Prescriber_Signature5);
		    getObject("Prescriber_Date5").sendKeys(Prescriber_Date5);
		    driver.findElement(By.cssSelector("#submitAttestationDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.xpath("//button[@onclick='dijit.byId(cpId).closeDialog();']")).click();
		    driver.findElement(By.id("attestation")).click();
		    driver.findElement(By.cssSelector("#submitAttestationDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.cssSelector("#continueDiv > button.pinkButtonFinger")).click();
		    driver.findElement(By.id("enrollmentLink")).click();*/
		    closeBrowser();
	}
	
	@AfterMethod 
	/*private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }*/

		 /* private boolean isAlertPresent() {
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
		  }*/

	@DataProvider
	public Object[][] getTestDatasiliq(){

		return TestUtil.getData(suite_PrescriberEnrollment__xls, this.getClass().getSimpleName());
	}

	@AfterMethod
	public void reportDataSetResult(){
		if(skip)
			TestUtil.reportDataSetResult(suite_PrescriberRegistration_xls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if(fail){
			isTestPass=false;
			TestUtil.reportDataSetResult(suite_PrescriberRegistration_xls, this.getClass().getSimpleName(), count+2, "FAIL");
		}
		else
			TestUtil.reportDataSetResult(suite_PrescriberRegistration_xls, this.getClass().getSimpleName(), count+2, "PASS");
		
		skip=false;
		fail=false;
		

	}
	
	@AfterTest
	public void reportTestResult(){
		if(isTestPass)
			TestUtil.reportDataSetResult(suite_PrescriberRegistration_xls, "Test Cases", TestUtil.getRowNum(suite_PrescriberRegistration_xls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suite_PrescriberRegistration_xls, "Test Cases", TestUtil.getRowNum(suite_PrescriberRegistration_xls,this.getClass().getSimpleName()), "FAIL");
	
	}
	
	
}
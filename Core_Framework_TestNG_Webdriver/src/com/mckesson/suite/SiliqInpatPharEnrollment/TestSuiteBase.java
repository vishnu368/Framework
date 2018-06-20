package com.mckesson.suite.SiliqInpatPharEnrollment;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.mckesson.base.TestBase;
import com.mckesson.util.TestUtil;

public class TestSuiteBase extends TestBase{
    // check if the suite ex has to be skiped
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		initialize();
		APP_LOGS.debug("Checking Runmode of SiliqInpatPharmacyEnrollment Suite");
		if(!TestUtil.isSuiteRunnable(suiteXls, "SiliqInpatPharmacyEnrollment Suite")){
			APP_LOGS.debug("Skipped SiliqInpatPharmacyEnrollment Suite as the runmode was set to NO");
			throw new SkipException("Runmode of SiliqInpatPharmacyEnrollment Suite set to no. So Skipping all tests in SiliqInpatPharmacyEnrollment Suite");
		}
		
	}
}

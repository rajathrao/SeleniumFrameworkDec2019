package com.ebay.dataDrivenFramework.VerifyLogin;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
// importing testbase and sigonpage class from other packages 
import com.ebay.dataDrivenFramework.Pages.SignOnPage;
import com.ebay.dataDrivenFramework.TestBase.TestBase;

public class TC001_VerifyValidLogin extends TestBase {
	
	
	
	@Test
	public void validLogin() {
		SignOnPage sp = PageFactory.initElements(driver, SignOnPage.class);
		sp.userNameTextBox.sendKeys("rajathrao");
		sp.passwordTextBox.sendKeys("Iguruji123!");
		sp.loginButton.click();
		Assert.assertTrue(driver.getTitle().contains("Fa Flight: Mercury Tours:"));
		
		
	}

}

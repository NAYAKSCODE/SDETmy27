package com.crm.autodesk.contact;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateContactsTest extends BaseClass {
   @Test(groups= {"smokeTest", "regressioTest"})
	public void CreateContactTest() throws Throwable {
		//get random data
		int randomNum = jLib.getRanDomNumber();

		//get the test script data
		String lastname = eLib.getDataFromExcel("Sheet1",1,2)+randomNum;

		// navigate to contacts page
		HomePage hp= new HomePage(driver);
		hp.clickOnContactsLink();
		//click on create contact lookup
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreatecontact();
		//enter all the details and create new contacts
		CreateContactPage cop= new CreateContactPage(driver);
		cop.createContact(lastname);
		//verify contacts 
		ContactInfoPage cip =new ContactInfoPage(driver);
		String actual_msg = cip.getContactInfo();
		if(actual_msg.contains(lastname))
		{
			System.out.println("pass--contact is created");
		}
		else
		{
			System.out.println("fail--contact not created");
		}
	}

}

package OrangeHRM.DemoApplication.pages.Steps;

import java.util.Map;

import OrangeHRM.DemoApplication.pages.Common.OrangeHRM_DemoApplication_SharedResources;
import OrangeHRM.DemoApplication.pages.Common.OrangeHRM_DemoApplication_Utility;
import OrangeHRM.DemoApplication.pages.Selectors.OrangeHRM_HomePage_Selectors;

public class OrangeHRM_HomePage_Steps {
	
	private OrangeHRM_DemoApplication_Utility utils;
	private OrangeHRM_DemoApplication_SharedResources sharedResources;
	@SuppressWarnings("unused")
	private OrangeHRM_HomePage_Selectors OarngeHRMHomePageSelectors;
	
	
	public OrangeHRM_HomePage_Steps(OrangeHRM_DemoApplication_Utility utils,OrangeHRM_DemoApplication_SharedResources sharedResources)
	
	{
		this.utils = utils;
		this.sharedResources = sharedResources;
		init();
	}

	public void init()
	{
		OarngeHRMHomePageSelectors = new OrangeHRM_HomePage_Selectors(utils,sharedResources); 
	}
	public void performInputInto_edit_UserName(Map<String,String>userName) throws Throwable
	{
		String username = userName.get("LoginName");
		OarngeHRMHomePageSelectors.enterText_into_edit_username(username);
	}
	public void performInputInto_edit_Password(Map<String,String>passWord) throws Throwable
	{
		String password = passWord.get("password");
		OarngeHRMHomePageSelectors.enterText_into_edit_password(password);
	}
	public void performClickon_button_SignIn() throws Throwable
	{
		OarngeHRMHomePageSelectors.clickOn_Button_SignIn();
	}
	
	public void perform_OrangeHRMImage_Verification()
	{
		OarngeHRMHomePageSelectors.verifyNewToursImageDisplayedOrNot();
	}

	public void perform_SignOnImageVerification()
	{
		OarngeHRMHomePageSelectors.verifySignOnImageDisplayedOrNot();
	}
	
	/*
	public void perform_textVerificationOperation()
	{
        try
        { 
        	Assert.assertTrue(OarngeHRMHomePageSelectors.getThetextForDestinations().equalsIgnoreCase("Desinations"));
        }
		catch(Exception e)
        {
			e.printStackTrace();
        }
	
	*/
	
        //SoftAssert softAssertion= new SoftAssert();
        //softAssertion.assertEquals(true, newTourshomepageSelector.getThetextForDestinations().equalsIgnoreCase("Destinations"));
        //softAssertion.assertAll();
        //sharedResources.getDriver().close();
        //sharedResources.getDriver().quit();
        
	}



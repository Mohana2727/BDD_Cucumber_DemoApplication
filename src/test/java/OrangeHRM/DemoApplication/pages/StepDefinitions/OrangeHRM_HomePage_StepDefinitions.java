package OrangeHRM.DemoApplication.pages.StepDefinitions;

import java.util.Map;

import OrangeHRM.DemoApplication.pages.Common.OrangeHRM_DemoApplication_SharedResources;
import OrangeHRM.DemoApplication.pages.Common.OrangeHRM_DemoApplication_Utility;
import OrangeHRM.DemoApplication.pages.Selectors.OrangeHRM_HomePage_Selectors;
import OrangeHRM.DemoApplication.pages.Steps.OrangeHRM_HomePage_Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;





public class OrangeHRM_HomePage_StepDefinitions {
	
	
	private OrangeHRM_HomePage_Steps OarngeHRMHomePageSteps;
	
	private OrangeHRM_HomePage_Selectors OarngeHRMHomePageSelectors;
	
	private OrangeHRM_DemoApplication_Utility utils;
	private OrangeHRM_DemoApplication_SharedResources sharedResources;
	/*return type for following method added*/
	public OrangeHRM_HomePage_StepDefinitions(OrangeHRM_DemoApplication_Utility utils,OrangeHRM_DemoApplication_SharedResources sharedResources)
	{
		this.utils = utils;
		this.sharedResources = sharedResources;
		init();
	}

	/*
	 * public void
	 * OrangeHRM_DemoApplication_Utility(OrangeHRM_DemoApplication_Utility
	 * utils,OrangeHRM_DemoApplication_SharedResources sharedResources) { this.utils
	 * = utils; this.sharedResources = sharedResources; init(); }
	 */
	public void init()
	{
		OarngeHRMHomePageSteps = new OrangeHRM_HomePage_Steps(utils,sharedResources);				
	}
	
	//@When("^User Launch the required OrangeHRM URL$")
	@When("^User launch the")
	public void User_Launch_the_required_OrangeHRM_URL()
	{
		if(OrangeHRM_DemoApplication_SharedResources.performAppLaunch)
		{
			//return;
			System.out.println("OrangeHRM URL Launched");
		}
	}
		
	@Given("^The user is in OrangeHRM application$")
	public void The_user_is_in_OrangeHRM_application() throws Exception{
		
		OarngeHRMHomePageSteps.perform_OrangeHRMImage_Verification();
	}

	@When("^He input the LoginName into Login Name field$")
	public void He_input_the_LoginName_into_Login_Name_field(Map<String,String>Login_Name) throws Throwable{
				OarngeHRMHomePageSteps.performInputInto_edit_UserName(Login_Name);
	}
	
	@And("^He input required password into Password field$")
	public void He_input_required_password_into_Password_field(Map<String,String>PASSWORD) throws Throwable{
		OarngeHRMHomePageSteps.performInputInto_edit_Password(PASSWORD); // password
	}

	@Then("^Click on Login button$")
	public void Click_on_Login_button() throws Throwable{
		OarngeHRMHomePageSteps.performClickon_button_SignIn();
	}

	@Then("^Application Navigates to Employee Information Page$")
	public void Application_Navigates_to_Employee_Information_Page() throws Exception{
		OarngeHRMHomePageSteps.perform_SignOnImageVerification();
	}
	
	

}

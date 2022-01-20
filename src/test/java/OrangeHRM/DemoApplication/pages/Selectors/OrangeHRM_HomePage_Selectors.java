package OrangeHRM.DemoApplication.pages.Selectors;

import org.openqa.selenium.By;

import OrangeHRM.DemoApplication.pages.Common.OrangeHRM_DemoApplication_SharedResources;
import OrangeHRM.DemoApplication.pages.Common.OrangeHRM_DemoApplication_Utility;

public class OrangeHRM_HomePage_Selectors {
	
	private By edit_LoginName;
	private By edit_Password;
	private By button_Login;
	private By image_OrangeHRM;
	private By image_SignON;
	private By HOMELINK;
	private By image_DESTINATIONS;
	
	private OrangeHRM_DemoApplication_Utility utils;
	private OrangeHRM_DemoApplication_SharedResources sharedResources;

	public OrangeHRM_HomePage_Selectors(OrangeHRM_DemoApplication_Utility utils,OrangeHRM_DemoApplication_SharedResources sharedResources) {
		this.utils = utils;
		this.sharedResources = sharedResources;
		OrangeHRM_HomePage_Selectors_Objects();
	}

	public void OrangeHRM_HomePage_Selectors_Objects() {
	
		edit_LoginName = By.name("txtUserName") ;
		edit_Password =By.name("txtPassword");
		button_Login = By.name("Submit");
		image_OrangeHRM = By.xpath("//*[@id=\"Table_01\"]/tbody/tr/td[1]/img");
		/*image_SignON =
		HOMELINK = 
		image_DESTINATIONS = */
	}
	
	public void enterText_into_edit_username(String uName) throws Throwable 
	{
		utils.setTextOnEdit(edit_LoginName, uName);
		Thread.sleep(1000);
	}
	public void enterText_into_edit_password(String uPassword) throws Throwable
	{
		utils.setTextOnEdit(edit_Password, uPassword);
		Thread.sleep(1000);
	}
	public void clickOn_Button_SignIn() throws Throwable
	{
		utils.clickOnButton(button_Login);
	}
	
	public void verifyNewToursImageDisplayedOrNot()
	{
		utils.VerifyWebElementExist(image_OrangeHRM);
		System.out.println("New Tours Image Imgae is displayed");
	}
	
	public void verifySignOnImageDisplayedOrNot()
	{
		utils.VerifyWebElementExist(image_SignON);
		System.out.println("Sign On Imgae is displayed");
		//sharedResources.getDriver().close();
		//sharedResources.getDriver().quit();
		utils.clickonLink(HOMELINK);
	}
		
	public String getThetextForDestinations()
	{
		return utils.getTheImageElementText(image_DESTINATIONS);
	}
	
}

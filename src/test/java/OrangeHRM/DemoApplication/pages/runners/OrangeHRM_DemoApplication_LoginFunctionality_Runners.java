package OrangeHRM.DemoApplication.pages.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@SuppressWarnings("deprecation")
@CucumberOptions(
		features = {"classpath:features/OrangeHRMFeature/OrangeHRM_Login.feature"},
		tags= {"@Functional"},
		glue = {"classpath:OrangeHRM.DemoApplication.pages.Selectors",
			   "classpath:OrangeHRM.DemoApplication.pages.Steps",
			   "classpath:OrangeHRM.DemoApplication.StepDefinitions",
			   "classpath:OrangeHRM.DemoApplication.pages.Common",
			   "classpath:OrangeHRM.DemoApplication.pages.runners"},
		plugin= {"pretty","html:target/Cucumber-html-report","json:target/cucumber-reports/Login.json","rerun:src/test/resources/rerun.txt"},
		strict=true
		)

public class OrangeHRM_DemoApplication_LoginFunctionality_Runners extends AbstractTestNGCucumberTests {

	
	
}

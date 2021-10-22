package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\mabde\\Imene_BDD_Cucumber\\cucumber_Imene\\src\\main\\java\\Features",//the path of the feature file
		glue= {"stepDefinitions"},//the path of the step definition files
		format={"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},//to generate different types of reporting
		monochrome = true, // display the console output in a proper readable format
		strict = true, //it will check if any step definition is not defined in step definition file
		dryRun= false// to check the mapping is proper between feature file and step definition file
		)




public class TestRunner {
	
	
	
	

}

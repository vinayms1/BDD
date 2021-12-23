package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { ".\\src\\test\\java\\features\\Login.feature" }, 
glue = { "StepDefination" }, 
dryRun = true, //check to step definition 
plugin = {"pretty","html:cucumberreport.html", "json:cucumberjsonreport.json"},
//tags = "@SmokeTest", //if we want to execute only particular test scripts
monochrome = true //to remove special character
)

public class Runner extends AbstractTestNGCucumberTests {

}
//instead use excluding, in BDD we use [tags="not @SmokeTest"]
//[tags="@SmokeTest or @RegressionTest"] ==> 
//[tags="@SmokeTest and @RegressionTest"] ==> 
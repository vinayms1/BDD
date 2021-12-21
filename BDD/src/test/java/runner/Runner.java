package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { ".\\src\\test\\java\\features\\Contact.feature" }, 
glue = { "StepDefination" }, 
dryRun = false, //check to step definition 
plugin = {"pretty"},
tags = "@run",
monochrome = true //to remove special character
)

public class Runner extends AbstractTestNGCucumberTests {

}

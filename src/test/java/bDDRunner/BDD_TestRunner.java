package bDDRunner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src\\test\\java\\bDDFeatures\\UserRegistration.feature", glue = {"bDDSteps"}, 
plugin = {"pretty","html:target/cucumber-html-report"})

public class BDD_TestRunner extends TestBase {

}

package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/aconexapplication.feature", plugin = "json:target/jsonReports/cucumber-report.json", dryRun = false, tags = {
		"@Aconexuploaddoctest" }, glue = { "stepdefinitions" }, monochrome = true)

//@Aconexuploaddoctest

//@Aconexemailtest or @Aconexuploaddoctest"
public class TestRunner {

}

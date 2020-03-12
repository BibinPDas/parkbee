package com.parkbee.test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/cucumber-report/cucumber.json",
		"rerun:target/failure/rerun.txt" }, features = "src/test/features", glue = { "com.parkbee.test.steps" })

public class RunCucumberIT {

}

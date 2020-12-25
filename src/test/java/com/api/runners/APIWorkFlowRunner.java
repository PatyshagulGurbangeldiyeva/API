package com.api.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions (
		features = "src/test/resources/features/", //specify which feature file to run
					//in our case we do say to run all features inside features package
		glue="com/api/steps", //where we can find implementation (codes) for gherkin steps
					//we specify just package
		dryRun=false, //if set to true it will quickly scan that all gherkin steps if they have implementation code
					// if set to true no actual execution will happen, just unimplemented steps will be checked
					// if you set false all the steps will run and executed
		monochrome = true
		,strict=true
		,tags= "@workflow"
		,plugin= {
				"pretty",//prints gherkin steps in console
				"html:target/cucumber-default-report"//create basic html report in specified location
				,"json:target/cucumber.json"
				}
		)



public class APIWorkFlowRunner {

}

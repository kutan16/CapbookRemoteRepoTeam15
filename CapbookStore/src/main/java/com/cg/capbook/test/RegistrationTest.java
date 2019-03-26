package com.cg.capbook.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class RegistrationTest {
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features= {"features"},
			glue= {"com.cg.project.stepDefinitions"}
			)

	public class TestRunner {

	}
}

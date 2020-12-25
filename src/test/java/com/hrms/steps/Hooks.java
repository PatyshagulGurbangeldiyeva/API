package com.hrms.steps;


import com.api.testbase.BaseClass;
import com.api.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	@Before
	public void start() {
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario) {
	
		byte[] pic;
		if (scenario.isFailed()) {
			
			pic=CommonMethods.takeScreenshot("failed/"+scenario.getName());// it returna array of bytes as screenshot
		}else {
			pic=CommonMethods.takeScreenshot("passed/"+scenario.getName());
		}
		
		scenario.attach(pic, "image/png", scenario.getName());
		BaseClass.tearDown();
	}

}

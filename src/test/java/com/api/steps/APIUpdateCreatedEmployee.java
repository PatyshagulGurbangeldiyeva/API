package com.api.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;

import com.hrmsAPI.utils.APIConstants;
import com.hrmsAPI.utils.PayloadConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUpdateCreatedEmployee {
	
	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	RequestSpecification request;

	Response response;

	
	
	
	//PUT update Created employee
	@Given("a request is prepared to update the created employee")
	public void a_request_is_prepared_to_update_the_created_employee() {
	   request= given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token).queryParam("employee_id", APIWorkFlowAllSteps.employeeID)
			   .body(PayloadConstants.updateCreatedEmpPayload());
	}
	@When("a PUT call is made to update the created employee")
	public void a_PUT_call_is_made_to_update_the_created_employee() {
	response=request.when().put(APIConstants.UPDATE_EMPLOYEE_ENDPOINT);
	response.prettyPrint();	
	}
	@Then("the status code for updateing the created employee is {int}")
	public void the_status_code_for_updateing_the_created_employee_is(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
		
	}
	@Then("the employee is updated and response contains key {string} and value {string}")
	public void the_employee_is_updated_and_response_contains_key_and_value(String Message, String value) {
		response.then().assertThat().body(Message, equalTo(value));
	}
	@Then("the retrieved data at {string} matches the data used to update created employee with employee ID {string}")
	public void the_retrieved_data_at_matches_the_data_used_to_update_created_employee_with_employee_ID(String employee, String employeeid, DataTable requestbody) {
		List<Map<String , String>> expectedbody=requestbody.asMaps();
		
		List<Map<String , String>> actualbody=response.jsonPath().get(employee);
		
		int index = 0;
		for (Map<String, String> map : expectedbody) {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				String expectedValue = map.get(key);
				String actualValue = actualbody.get(index).get(key);
				Assert.assertEquals(expectedValue, actualValue);
			}
			index++;
		}
		
		String empID = response.body().jsonPath().getString("employee[0].employee_id");
		Assert.assertTrue(empID.contentEquals(APIWorkFlowAllSteps.employeeID));
		}
		
		
		
		
		
	}



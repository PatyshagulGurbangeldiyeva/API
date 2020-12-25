package com.api.steps;

import static io.restassured.RestAssured.given;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import com.hrmsAPI.utils.APIConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIGetEmpStatus {
	
	//storing as instance varable	// specifying the base URL to restFul web Services
	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	RequestSpecification request;

	Response response;

	static String employeeID;
	
	
	
	
	@Given("a request is prepared to retrieve the Emp Status")
	public void a_request_is_prepared_to_retrieve_the_Emp_Status() {
	    request= given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token);
	}

	@When("a Get call is made to retrieve the Emp Status")
	public void a_Get_call_is_made_to_retrieve_the_Emp_Status() {
	 response=request.when().get(APIConstants.GET_JOB_STATUS_ENDPOINT); 
	 System.out.println("method with endPoint");
	}

	@Then("the status code for retrieving the Emp Status is {int}")
	public void the_status_code_for_retrieving_the_Emp_Status_is(int statusCode) {
	response.then().assertThat().statusCode(statusCode).toString();
	
	
	}

	@Then("the retrieved data at {string} matches the data used to get Emp Status")
	public void the_retrieved_data_at_matches_the_data_used_to_get_Emp_Status(String empStatusList, DataTable dataTable) {

		List <String> expected=dataTable.asList();
		List <String>actual=response.jsonPath().getList(empStatusList);
		
		for (int i=0; i<=expected.size();i++) {
			String expectedValue=expected.get(i);
			String actualValue=actual.get(i);
			Assert.assertEquals(expectedValue, actualValue);
		}
	
		
//		JSONObject json = new JSONObject(response.prettyPrint());
//		JSONArray array = json.getJSONArray(empStatusList);
//		for (int i = 0; i < array.length(); i++) {
////	Asserting JObTitle from response body toward feature file values
//			AssertJUnit.assertEquals(expected.get(i), array.get(i));
//	
//	
		
	}




}

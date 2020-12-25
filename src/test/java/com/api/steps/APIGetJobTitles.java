package com.api.steps;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.AssertJUnit;

import com.hrmsAPI.utils.APIConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIGetJobTitles {
	
	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	RequestSpecification request;

	Response response;

	static String employeeID;
	

	@Given("a request is prepared to retrieve the Job Titles")
	public void a_request_is_prepared_to_retrieve_the_Job_Titles() {
	
		  request= given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token);
	}
	@When("a GET call is made to retrieve the Job Titles")
	public void a_GET_call_is_made_to_retrieve_the_Job_Titles() {
	   response=request.when().get(APIConstants.GET_JOB_TITLES_ENDPOINT);
		System.out.println(response);
		
	}
	@Then("the status code for retrieving the Job Titles is {int}")
	public void the_status_code_for_retrieving_the_Job_Titles_is(Integer statusCode) {
		response.then().assertThat().statusCode(statusCode);
		
		
	}
	@Then("the retrieved data at {string} matches the data used to get Job Titles")
	public void the_retrieved_data_at_matches_the_data_used_to_get_Job_Titles(String JobTitles, DataTable dataTable) {
	  
		List<String> expectedJobTitle=dataTable.asList();
		
		JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray(JobTitles);
		for (int i = 0; i < array.length(); i++) {
//	Asserting employee status from response body toward feature file values
			AssertJUnit.assertEquals(expectedJobTitle.get(i), array.get(i));
	}		
}

}

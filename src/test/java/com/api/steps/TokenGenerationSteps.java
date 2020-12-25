package com.api.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import com.api.utils.CommonMethods;

public class TokenGenerationSteps {
	
	public static String token;
	String BaseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	
	
	
	
	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		// import static io.restassured.RestAssured.*;----> we need to import this in order to make given() worked
//		RequestSpecification generatetokenRequest=given().header("Content-Type","application/json").body("{\n" + 
//				"  \"email\": \"paty@gmail.com\",\n" + 
//				"  \"password\": \"Paty123\"\n" + 
//				"}");
		
		RequestSpecification generateTokenRequest=given().header("Content-Type","application/json").body("{\n" + 
				"  \"email\": \"paty@gmail.com\",\n" + 
				"  \"password\": \"Paty123\"\n" + 
				"}");
		
		
		 
		//import io.restassured.response.Response;----> ipmort this write manually
		Response generateTokenResponse=generateTokenRequest.when().post("/generateToken.php");
		
	//	generateTokenResponse.prettyPrint();
		
		token="Bearer "+ generateTokenResponse.body().jsonPath().getString("token");
		System.out.println(token);
	}
	
	
	

}

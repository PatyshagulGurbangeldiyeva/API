package com.api.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; //-----> we need to import this import package in order to get method body("Message", equalTo("Entry Created"));--> line 92

// sometimes we need to import packages manually as eclipse will not to do it. 
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.hrmsAPI.utils.PayloadConstants;

//import org.apache.hc.core5.http.ContentType;


/**
 * This method will execute @Test annotation in assending order (alphabetical order)
 * @author vepagurbangeldiyev
 *import org.junit.runners.MethodSorters; ---> you need to import
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class HardcodedExamples {

	/**
	 * Rest Assert given- where we prepare our request when- where we are making the
	 * call to the endpoint then- where we are validating
	 * 
	 * @param args
	 */

	// stoting as instance variable (global variable)
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU3MzQzODQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTc3NzU4NCwidXNlcklkIjoiNjQ2In0.kzJImcZIp_uiyxc-sIFTwAK3gMhycwMtZN4wtVee_DY";
	public static String employeeID;

	// @Test //-->> if you will not put @Test this method will not have printed in
	// console as it is not main method
	public void sampleTestNotes() {
		/**
		 * BaseURI for all calls
		 */

		// here we are copied the baseURI from postman from QA environment but add
		// "http://"
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api"; // URI is a url+endPoint ---> BaseURI=BaseURL

		/**
		 * JWT required for all calls- expires every 12 hours
		 */
		// copy token and past it here
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjk2NDIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjg0MiwidXNlcklkIjoiNjQ2In0.CtgRIW3hEzwqxJPcNiHh-BGitCrupYmsK-cx0n4jcVw";

		// for this method we need to import : import static
		// io.restassured.RestAssured.*;
		// getting employee from Postman // if you will add ath the end .log... it will
		// --> print extra info
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16817A").log().all();
												// from this method we can understand it is RequestSpecification

		// make a call to API
		// import io.restassured.response.Response;
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php"); // this path from
																									// postmann global
																									// initialValue

		// printing our date.
		// there are two ways to do
		// first one printing automatically (pretty print) and second one you converting
		// to string
		getOneEmployeeResponse.prettyPrint();   //-----> converting JSon into String
		// String response =getOneEmployeeResponse.body().asString();
		// System.out.println(response); //-----> printing our data that we receive it

		getOneEmployeeResponse.then().assertThat().statusCode(200); // when you will run if there is no assertion fail
																	// you code is working

	}

	// if you want to print (execute)the code in the method that is not a main
	// method you
	// need to put annotation @Test (jUnit)
	@Test
	public void aPostCreateEmployee() {
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.headers("Authorization", token)
				.body("{\n" + "  \"emp_firstname\": \"Alp\",\n" + "  \"emp_lastname\": \"Ngu\",\n"
						+ "  \"emp_middle_name\": \"Tony\",\n" + "  \"emp_gender\": \"M\",\n"
						+ "  \"emp_birthday\": \"1990-07-11\",\n" + "  \"emp_status\": \"Internee\",\n"
						+ "  \"emp_job_title\": \"QA Tester\"\n" + "}");

		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		createEmployeeResponse.prettyPrint();

		// by calling this method we get the empId
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		System.out.println("employee id is " + employeeID);

		// veryfing code status
		createEmployeeResponse.then().assertThat().statusCode(201); // in order to see if this code past or fail you
																	// need to open jUnit

		// veryfining message from response body
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created")); // equalTo will not work
																								// as we need to
																								// manually import
																								// package (import
																								// static
																								// org.hamcrest.Matchers.*;)

		// veryfining firstName
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Alp"));

		// getting headers and varyfing them ( we are not using assertThat it may not
		// work, but i tried it worked)
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		createEmployeeResponse.then().assertThat().header("X-Powered-By", "PHP/7.2.18");

//		createEmployeeResponse.then().assertThat().header("Date", "Sun, 19 Jul 2020 15:17:07 GMT"); // this method is not workong
	}

	@Test
	public void bGetCreatedEmployee() {
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		
		// make a call in order to retrive an employee
		Response getCreatedEmployeeResponse=getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		
		String response=getCreatedEmployeeResponse.prettyPrint();
	
		String empID=getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		System.out.println(empID);
		
		boolean verifyingEmployeeIDsMatch= empID.equalsIgnoreCase(employeeID);
		
		Assert.assertTrue(verifyingEmployeeIDsMatch); // this will give you true or false in order to get assertion. but even it is false not matching the test wont be failed
		System.out.println("employee id is matching:"+verifyingEmployeeIDsMatch); // printing true or false of assertion
		

		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
		// creating obj of jSonPath
		JsonPath js= new JsonPath(response); //----> we got this response from PrettyPrint. we converted pretty print to string and then put here
		String id=js.get("employee[0].employee_id");
		String fName= js.get("employee[0].emp_firstname");
		String mName=js.get("employee[0].emp_middle_name");
		String lname=js.get("employee[0].emp_lastname");
		String bday=js.get("employee[0].emp_birthday");
		String gender=js.get("employee[0].emp_gender");
		String jTitle=js.get("employee[0].emp_job_title");
		String status=js.get("employee[0].emp_status");
		
		System.out.println("json obj id is:"+id);
		System.out.println("json obj id is:"+fName);
		
		//making assertion
		// 1 way to print on console boolean
		boolean idMatching=id.contentEquals(employeeID);
		Assert.assertTrue(idMatching);
		System.out.println("id is matching:"+idMatching);
		
		// 2 way ---> it will not print in console
		Assert.assertTrue(id.contentEquals(employeeID));
		
		// 3 way
		Assert.assertEquals(employeeID,id);
		
		//fName
		boolean fNameMatching=fName.contentEquals("Alp");
		Assert.assertTrue(fNameMatching);
		System.out.println("fName is matching:"+fNameMatching);
		
		
		//mName
		Assert.assertTrue(mName.contentEquals("Tony"));
		
		//lName
		Assert.assertEquals("Ngu",lname);
		
		//bday
		boolean bDayMatching=bday.contentEquals("1990-07-11");
		Assert.assertTrue(bDayMatching);
		System.out.println("bDay is matching:"+bDayMatching);
		
		//gender
		Assert.assertTrue(gender.contentEquals("Male"));
		
		//jTitle
		Assert.assertEquals("QA Tester",jTitle);
		
		//status
		boolean statusMatching=status.contentEquals("Internee"); //-----> this is not assertion. we just want to print true or false
		Assert.assertTrue(statusMatching);
		System.out.println("status is matching:"+statusMatching);
		
	}

	//@Test
	public void cGetAllEmployees() {
		RequestSpecification getAllEmployeesRequest=given().header("Content-Type","application/json").header("Authorization",token);
		Response getAllEmployeesResponse= getAllEmployeesRequest.when().get("/getAllEmployees.php");
		
		// printing requested info in console
	//	getAllEmployeesResponse.prettyPrint(); //-----> we made it comment as there are too many employees
	
		// getting all emp and converting to string
		String allEmployees=getAllEmployeesResponse.body().asString();
		
	//	allEmployees.contains(employeeID); //----> here we are not using it as even one of them will contain it will pass.
	//	allEmployees.matches(employeeID);  //---> need to search will it work for all employees
		
		// getting the size of the array Employee:[{obj1,obj2,...}]
	
		JsonPath js=new JsonPath(allEmployees); // creating an obj of JsonPath class
		int sizeOfList=js.getInt("Employees.size()");
		System.out.println(sizeOfList);
		
		
		// printing all employees IDs
		
		for (int i=0;i<sizeOfList;i++) {
		String allEmployeesIDs=js.getString("Employees["+i+"].employee_id");
	//	System.out.println(allEmployeesIDs);
	
	// finding id that we need and break the loop as we don't want to loop rest ids we don't need it
		if (allEmployeesIDs.contentEquals(employeeID)) {
			System.out.println("employee id:"+employeeID+" is present");
			String firstName=js.getString("Employees["+i+"].emp_firstname");
			System.out.println("employee first name is "+firstName);
			break; //---> as we do not want to loop the rest ids
			
		}
		
		}	
	
	}
	
	
	@Test
	public void dPutUpdateEcreatedEmployee() {
		// {{empId}} we deleted it and add--> "+employeeID+
//		RequestSpecification udatedCreatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token).body("{\n" + 
//				"  \"employee_id\": \""+employeeID+"\",\n" + 
//				"  \"emp_firstname\": \"Ethan\",\n" + 
//				"  \"emp_lastname\": \"Ngu\",\n" + 
//				"  \"emp_middle_name\": \"Tony\",\n" + 
//				"  \"emp_gender\": \"M\",\n" + 
//				"  \"emp_birthday\": \"2020-07-11\",\n" + 
//				"  \"emp_status\": \"Internee\",\n" + 
//				"  \"emp_job_title\": \"API Tester\"\n" + 
//				"\n" + 
//				"\n" + 
//				" \n" + 
//				"}");
		
		RequestSpecification udatedCreatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token).body(PayloadConstants.updateEcreatedEmpBody());
		
		Response udatedCreatedEmployeeResponse= udatedCreatedEmployeeRequest.when().put("/updateEmployee.php");
		
		String response=udatedCreatedEmployeeResponse.prettyPrint();
		
		System.out.println("---------------------------");
		
		
		udatedCreatedEmployeeResponse.then().assertThat().body("Message",equalTo("Entry updated"));
		String empID=udatedCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		Assert.assertTrue(empID.contentEquals(employeeID));
	}
	
	
	
	@Test
	public void eGetUpdatedEmployee() {
		
		// preparing request to get updatedEmployee
		RequestSpecification getUpdatedEmployee=given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
		//Stoting response
		Response getUpdatedEmployeeResponse=getUpdatedEmployee.when().get("/getOneEmployee.php");
		
		//printing response in string format
		getUpdatedEmployeeResponse.prettyPrint();
		
		
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname",equalTo("Ethan"));
		
	
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id",equalTo(employeeID));
	}
	
	@Test
	public void fPartialUpdatedEmployee() {
		RequestSpecification partiallyUpdatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization", token).body("{\n" + 
				"  \"employee_id\": \""+employeeID+"\",\n" + 
				"  \"emp_job_title\": \"Developer\"\n" + 
				"\n" + 
				"}");
		
		Response partiallyUpdatedEmployeeResponse= partiallyUpdatedEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
		
		partiallyUpdatedEmployeeResponse.prettyPrint();
		
		partiallyUpdatedEmployeeResponse.then().assertThat().statusCode(201);
		
		partiallyUpdatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		
	}

	
	@Test
	public void gGetPartiallyUpdatedEmployee() {
		System.out.println(".......................... ..........  j GET Partially Updated Employeee ................................");
		// 1- given - prepare our request
		RequestSpecification  getPartiallyUpdatedEmployeeRequest=given().header("Content-Type", "application/json").header("Authorization",token).queryParam("employee_id", employeeID);
		
		// 2- when - we are making the call to the endpoint
		Response getPartiallyUpdatedEmployeeResponse = getPartiallyUpdatedEmployeeRequest.when().log().all().get("/getOneEmployee.php");
		getPartiallyUpdatedEmployeeResponse.prettyPrint();
		
		
	//3  Then validating
	
	
	}
	@Test
	public void hDeleteEmployee() {
		
		RequestSpecification deletedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
		Response deletedEmployeeResponse=deletedEmployeeRequest.when().delete("/deleteEmployee.php");
		
		deletedEmployeeResponse.prettyPrint();
		
		deletedEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
		
	}
}

package com.hrmsAPI.utils;



import org.json.JSONObject;

import com.api.steps.APIWorkFlowAllSteps;
import com.api.steps.HardcodedExamples;


public class PayloadConstants {
	
	public static String createEmployeeBody() {
		String createEmployeeBody="{\n" + 
				"  \"emp_firstname\": \"Alp\",\n" + 
				"  \"emp_lastname\": \"Ngu\",\n" + 
				"  \"emp_middle_name\": \"Tony\",\n" + 
				"  \"emp_gender\": \"M\",\n" + 
				"  \"emp_birthday\": \"1990-07-11\",\n" + 
				"  \"emp_status\": \"Internee\",\n" + 
				"  \"emp_job_title\": \"QA Tester\"\n" + 
				"}";
		
		return createEmployeeBody;
	}
	
	
	public static String creatEmployeePayload() {
		
		JSONObject obj= new JSONObject();
		obj.put("emp_firstname","Ethan");
		obj.put("emp_middle_name","Tony");
		obj.put("emp_lastname","Ngu");
		obj.put("emp_birthday","1990-07-11");
		obj.put("emp_gender","M");
		obj.put("emp_job_title","QA Tester");
		obj.put("emp_status","Internee");
		
		return obj.toString();
		
	}
	
	
	
	
	public static String updateEcreatedEmpBody() {
		
		String updateBody=("{\n" + 
				"  \"employee_id\": \""+HardcodedExamples.employeeID+"\",\n" + 
				"  \"emp_firstname\": \"Ethan\",\n" + 
				"  \"emp_lastname\": \"Ngu\",\n" + 
				"  \"emp_middle_name\": \"Tony\",\n" + 
				"  \"emp_gender\": \"M\",\n" + 
				"  \"emp_birthday\": \"2020-07-11\",\n" + 
				"  \"emp_status\": \"Internee\",\n" + 
				"  \"emp_job_title\": \"API Tester\"\n" + 
				"\n" + 
				"\n" + 
				" \n" + 
				"}");
		
		return updateBody;
		
		
	}
	
	
public static String  updateCreatedEmpPayload() {// this method is recommended
		
		JSONObject obj=new JSONObject();
		obj.put("employee_id", APIWorkFlowAllSteps.employeeID);
		obj.put("emp_firstname", "Ethan");  // string key object method we choosed
		obj.put("emp_lastname", "Ngu");
		obj.put("emp_middle_name", "Tony");
		obj.put("emp_gender", "M");
		obj.put("emp_birthday", "2020-07-11");
		obj.put("emp_status", "Internee");
		obj.put("emp_job_title", "API Tester");
		
		return obj.toString();// it wiil return to String
		
		
		
	}
	
	
	
	
	
	

}

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/APIWorkFlow.feature");
formatter.feature({
  "name": "Syntax Hrms Api End to End Workflow",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@workflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.api.steps.TokenGenerationSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@workflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.api.steps.APIWorkFlowAllSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a POST call is made to create an employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.api.steps.APIWorkFlowAllSteps.a_POST_call_is_made_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.api.steps.APIWorkFlowAllSteps.the_status_code_for_creating_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created and response contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.api.steps.APIWorkFlowAllSteps.the_employee_is_created_and_response_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee ID \"Employee[0].employee_id\" is stored as a global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.api.steps.APIWorkFlowAllSteps.the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.api.steps.TokenGenerationSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@workflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to update the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.api.steps.APIUpdateCreatedEmployee.a_request_is_prepared_to_update_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a PUT call is made to update the created employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.api.steps.APIUpdateCreatedEmployee.a_PUT_call_is_made_to_update_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for updateing the created employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.api.steps.APIUpdateCreatedEmployee.the_status_code_for_updateing_the_created_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is updated and response contains key \"Message\" and value \"Entry updated\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.api.steps.APIUpdateCreatedEmployee.the_employee_is_updated_and_response_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved employee ID at \"employee[0].employee_id\" matches the globally stored employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.api.steps.APIWorkFlowAllSteps.the_retrieved_employee_ID_at_matches_the_globally_stored_employee_ID(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat com.api.steps.APIWorkFlowAllSteps.the_retrieved_employee_ID_at_matches_the_globally_stored_employee_ID(APIWorkFlowAllSteps.java:91)\n\tat ✽.the retrieved employee ID at \"employee[0].employee_id\" matches the globally stored employee ID(file:///Users/vepagurbangeldiyev/eclipse-workspace/API/src/test/resources/features/APIWorkFlow.feature:67)\n",
  "status": "failed"
});
formatter.step({
  "name": "the retrieved data at \"employee\" matches the data used to update created employee with employee ID \"employee[0].employee_id\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.api.steps.APIUpdateCreatedEmployee.the_retrieved_data_at_matches_the_data_used_to_update_created_employee_with_employee_ID(java.lang.String,java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "skipped"
});
});
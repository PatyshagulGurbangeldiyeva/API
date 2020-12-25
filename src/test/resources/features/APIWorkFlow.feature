@workflow
Feature: Syntax Hrms Api End to End Workflow

  Background: 
    Given a JWT is generated

  Scenario: Creating an employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating employee is 201
    And the employee is created and response contains key "Message" and value "Entry Created"
    And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls

  #Scenario: 
    #Given a request is prepared to retrieve the created employee
    #When a Get call is made to retrieve the created employee
    #Then the status code for retrieving the created employee is 200
    #And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    #Then the retrieved data at "employee" matches the data used to create an employee with employee ID "employee[0].employee_id"
      #| emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      #| Ethan         | Tony            | Ngu          | 1990-07-11   | Male       | QA Tester     | Internee   |
#
  #Scenario: 
    #Given a request is prepared to retrieve the Emp Status
    #When a Get call is made to retrieve the Emp Status
    #Then the status code for retrieving the Emp Status is 200
    #And the retrieved data at "Employee Status List" matches the data used to get Emp Status
      #| Employee | Worker | Self-Employee | Independent contractor | Freelance | Zero hours contract | Gig economy | Super Contractor | Internee | Part Time Employee | Seasonal Employee | Summer Time Employee |
#
  #Scenario: Retreving Job Titles
    #Given a request is prepared to retrieve the Job Titles
    #When a GET call is made to retrieve the Job Titles
    #Then the status code for retrieving the Job Titles is 200
    #And the retrieved data at "Job Title List" matches the data used to get Job Titles
      #| Cloud Architect                   |
      #| Cloud Consultant                  |
      #| Cloud Product and Project Manager |
      #| IT Analyst                        |
      #| Network Administrator             |
      #| IT Support Manager                |
      #| Data Quality Manager              |
      #| Database Administrator            |
      #| Application Developer             |
      #| Developer                         |
      #| Accountant                        |
      #| Chief Financial Officer           |
      #| Controller                        |
      #| Production Manager                |
      #| Jr Production Manager             |
      #| Sales&Marketing Manager           |
      #| Jr Sales Manager                  |
      #| Graphic Designer                  |
      #| CEO                               |
      #| Automation Engineer               |
      #| API Tester                        |
      #| Instructor                        |
      #| CTO                               |
      #| QA Tester                         |
      #| Sr Production Manager             |
      #| Sales&Marketing Manager           |

  Scenario: Update created employee
    Given a request is prepared to update the created employee
    When a PUT call is made to update the created employee
    Then the status code for updateing the created employee is 201
    And the employee is updated and response contains key "Message" and value "Entry updated"
    And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    Then the retrieved data at "employee" matches the data used to update created employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status       | emp_job_title   |
      | Alexsandra    | White        | Alex            | F          | 2001-07-03   | Super Contractor | Cloud Architect |

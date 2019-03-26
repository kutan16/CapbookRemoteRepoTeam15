Feature: Registartion Feature for CapBook
  this feature helps user to register

  Scenario: user is trying to register using invalid set of details
    Given User is accessing CapBook Regsitrtion Page on Borwser
    When user is trying submit data without entring 'emailId'
    Then 'User Id should not be empty / length be between 5 to 12' alert message should display
    When User is trying to submit request without entering 'Password'
    Then 'Password should not be empty / length be between 7 to 12' alert message should display
    When User is trying to submit request without entering 'firstName'
    Then 'First name should not be Empty' alert message should display
    When User is trying to submit request without entering 'lastName'
    Then 'Last name should not be Empty' alert message should display
    When User is trying to submit request without entering  valid 'gender'
    Then 'Please Select gender' alert message should display
    When User is trying to submit request without entering 'mobileNo'
    Then 'Mobile Number should not be Empty' alert message should display
    When User is trying to submit request without entering 'dateOfBirth'
    Then 'Date of Birth should not be Empty' alert message should display

  Scenario: user is trying to register using valid set of details
    Given User is accessing CapBook Regsitration Page on Borwser
    When User is trying to submit request after entering valid set of information
    Then 'Your Registration with CapBook has been successfully done ' alert message should display

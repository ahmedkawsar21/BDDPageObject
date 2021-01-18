Feature: Qa click Login Page
  @LandingPage
  Scenario: Landing page default login
    Given User already on landing page
    When User click on login Button
    Then User navigate to login page
    And welcome message displayed
  @LoginPage
  Scenario Outline: Login page check with different user
    Given User already on login page
    When User enters "<username>" and "<password>"
    Then User click on login bar
    Then User click on forgot password button
    Then User enters "<username>"
    And click on send instructions button
    Examples:
      |username  |password |
      |qa123     |12345    |
      |qa456     |45678    |
Feature: Users who pay for their own care can register
  As a user who pays for their own care I should be able
  to provide my details and register for the scheme


  Scenario: User with a UK address can register for the scheme
    Given I am on the Social Care Compliance homepage
    When I choose the "Someone who pays for care directly" option
    And I enter my name as "name"
    And My address is in the UK
    And I enter my address as
      | Field         | Value      |
      | addressLine1  | line 1     |
      | addressLine2  | line 2     |
      | postcode      | NE98 1ZZ   |
    And I enter my phone number as 12345
    And I don't have an e-mail address
    And I don't have a UTR number
    And I don't have a PAYE reference number
    And I will be shown my answers


      | Label                                       | Answer                             |
      | Which option best describes you             | Someone who pays for care directly |
      | Your name                                   | Name                               |

#    Then I will receive a confirmation that form has been submitted









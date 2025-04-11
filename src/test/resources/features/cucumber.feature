Feature: API Automation using REST Assured

#  Scenario: Verify GET API request
#    Given I perform GET request on "/users/1"
#    Then I should get response code 200
#


  Scenario: Verify POST API request
    Given I perform POST request on "/users"

    And I send request payload from payload

    Then I should get response code 201
    And response should contain "job" as "Senior Engineer"



#    Scenario: Verify POST API request
#    Given I perform POST request on "agWalletAPI/v3/encrypt"
#
#    And I send request body
#         """
#  {
#    "payload": {
#      "transaction": {
#        "requestType": "WTW",
#        "requestSubType": "PWTB"
#      },
#      "payOutBean": {
#        "mobileNo": "8888271643",
#        "txnAmount": "3",
#        "accountNo": "53824563229",
#        "ifscCode": "yesb0000546",
#        "accountHolderName": "pravin test API",
#        "txnType": "IMPS",
#        "orderRefNo": "Pra051229943200375",
#        "emailId": "pravinc@safexpay.com"
#      }
#    },
#    "key": "y766MSk+wf77BktmsyBxK4obALcfO1fj1qg82KQgqKI="
#  }
#  """
#    Then I should get response code 500
#    And response should contain "status" as "SUCCESS"
@parkbee
Feature: Check the parking prices are updated when the parking time changed

Scenario: Check Parking price updation
	Given I am on the parkbee home page
	Then I maximize browser window
	Then I wait for "2" seconds
	Then I take screenshot
	Then I scroll to the element having "Reserveer_label"
	Then I wait for "2" seconds
	When I enter "Nassaukade" into "Waar_wil_je_parkeren" input field
	Then I wait for "2" seconds
	Then I click on element having "select"
	Then I wait for "2" seconds
	Then I take screenshot
	Then I click on element having "calendar"
	Then I wait for "2" seconds
	Then I take screenshot
	Then I click on element having "selecteer"
	Then I wait for "2" seconds
	Then I click on element having "zoeken"
	Then I wait for "20" seconds
	Then I take screenshot 
	Then I check the "parking_rate"
	Then I click on element having "date_end"
	Then I wait for "5" seconds
	Then I click on element having "date_end_time"
	Then I wait for "5" seconds
	Then I click on element having "selecteer_end_date"
	Then I wait for "20" seconds
	Then I take screenshot
	Then I check the "parking_rate"
	Then I take screenshot
	
	  
	
Feature: Login page

	Scenario: Login to the Swaglabs page
	
	Given Open the login page
	When User enter the Username and Password
	And User click on the Login
	Then Swaglabs Homepage should be loaded

	Scenario Outline: Change the Sort option and Open the first product

		Given Open the login page
		When User enter the Username and Password
		And User click on the Login
		When User changed sort option to <sortOption>
		Then User click on first product

		Examples:
			| sortOption          |
			| Price (low to high) |
			| Price (high to low) |
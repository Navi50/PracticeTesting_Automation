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

Scenario: Add one product to Cart and Checkout
	Given Open the login page
	When User enter the Username and Password
	And User click on the Login
	Then User click on first product
	And User Verify the Item name
	When User click on Add to Cart
	Then User Verify Item added in Cart
	When User click on Checkout
	Then User fills checkout details
	When User click on Continue
	Then User Verify Item name in checkout page
	When User click on finish
	Then User verify the confirmation page

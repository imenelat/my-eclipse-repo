Feature: Free CRM Create a new contact 

Scenario Outline: Free CRM Create a new contact scenario 

	Given User is already on Login Page 
	When Title of login page is Free CRM 
	Then User enters "<username>" and "<password>" 
	Then User clicks on login button 
	Then User is on Home Page 
	Then User moves to new contact page 
	Then user enters contact details "<firstname>" and "<lastname>" and "<position>" 
	Then Close the browser 
	
	
	Examples: 
		|username				|password    |firstname|lastname|position |
		|imene.manlat@gmail.com |Corporatio10|imene    |lat		|mother   |
		|imene.manlat@gmail.com |Corporatio10|houssem  |manaa   |son	  |
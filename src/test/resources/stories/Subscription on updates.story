Meta: @smoke

Scenario: Subscription on updates
Given I open main page and go to insights
When Fill form <email> and choose language <language> and sibscribe
Then My subscription is success

Examples:
|email|language|
|geinish@gmail.com|Czech Republic|
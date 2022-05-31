Feature: Translation word

Meta: @smoke
Scenario:  Navigation
Given Open Browser Chrome and consent settings
When I click [navigation]
Then I see [section]
Examples:
|navigation|section|
|en|yes|
|cz|no|
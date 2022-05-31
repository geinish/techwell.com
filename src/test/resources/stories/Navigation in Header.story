Feature: Navigation

Meta: @smoke
Scenario:  Navigation in Header
Given Open Browser Chrome and consent settings
When I click <navigation>
Then I redirected to <url>
Examples:
|navigation|url|
|Conferences|https://www.techwell.com/software-conferences|
|Communities|https://www.techwell.com/software-communities|
|Insights|https://www.techwell.com/techwell-insights|
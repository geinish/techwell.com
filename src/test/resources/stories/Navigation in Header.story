Meta: @smoke
Narrative:
As a user
I want to navigate on site

Scenario:  Navigation in Header
Given I open main page
When I click <parentItem> <navigationItem>
Then I redirected to <url>

Examples:
|parentItem|navigationItem|url|
||Conferences|/software-conferences|
||Communities|/software-communities|
||Insights|/techwell-insights|
|Conferences|STAR Testing Conferences|/software-conferences/star-software-testing-conferences|
|Conferences|Agile + DevOps Conferences|/software-conferences/agile-devops-conferences|
|Communities|Stickyminds|/software-communities/stickyminds|
|Communities|AgileConnection|/software-communities/agileconnection|
|Communities|Podcasts|/software-communities/podcasts|
|Communities|Women Who Test|/software-communities/womenwhotest|
|Communities|Cre8ive Spaces|/cre8ive-spaces|
|Communities|TechWell Hub|/software-communities/techwell-hub|
|More|Web Seminars/Workshops|/web-seminars|
|More|White Papers & Downloads|/white-paper-downloads|
|More|Speak at a Conference|/software-conferences/be-a-speaker|
This application was built with Kotlin programing language using springBoot framework and gradle to manage dependencies 
and build and deploy the application.
The AutoCompleteRestController deploys the "autocomplete" endpoint using springboot web api, this endpoint is mapped on 
a single GET HTTP operation that receives a partial string value and returns a list with up to 10 suggestions from a text
file.

Since the file is load on memory at application initialization a large file would impact more on application startup.

To develop this application I consult the spring boot documentation:
https://spring.io/guides/gs/rest-service/
I also searched developer forums using google search engine.

The libraries used was spring spring-boot-starter-web and jackson.
The tools was Spring Initializr, gradle, intellij and postman.

I spent more or less a half hour to setup the environment, hour and half researching and developing, a half hour to documenting and packaging.

If I had more time available I would write unit tests and also developing use TDD technique, and also would prioritize
faster and concurrent search. 

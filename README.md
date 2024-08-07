This is a basic Spring Boot 3 project to show my issues with the mapstruct-spring-extension.

The application has a single Controller, a Service and two Mappers, built in the conversionService integration fashion. So we have three levels of objects to be mapped, an Entity, a DTO and a Bean (in this example, they all have the same structure) which represents a "Car" object. This Car only has three attributes, a plate, a model name and a year of production. 
When we run the application, we can retry a Car object at the url **localhost:8080/car**. The application maps a CarEntity object into a CarDto one, and then returns a Car bean object. 

My issue is, as in the original project, with the unit tests. Using, as suggested, the generated @ConverterScan annotation and naming the conversionService bean "mvcConversionService", my Controller test runs fine, but my Service test fails.

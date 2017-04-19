 Developed on  Ubuntu 16 LTS and build with maven 3.3.9
 
 == Project build ==

FIRST: Change persistence.xml properties in pom.xml for current environment !
In log4j2.xml set preferred log level.
Single log4j2.xml is both, for test stages and for deployed application.

To activate unit and integration test use configured profiles:
1. 'it-test' for integration tests
2. 'u-test' for unit tests


 == packaging ==
 
Persistence.xml	- with properties for database
input-data.xsd	- schema 
log4j2.xml		- log4j2 configuration file

Dependencies are downloaded into 'target/lib' directory and referred to as class path from archive MANIFEST.MF



 == run application ==
 
In directory where is jar file must be 'lib' directory with all dependencies.
Jar archive contains 'input-data.xsd' file for schema validation so input xml file should conform to it.

Run command:
Add first argument - location of data xml file

	java -jar demo-project-0.0.1-SNAPSHOT.jar <relative or absolute path to data xml file>
	

 == project design ==

For this demo project I choose not to use dependency injection frameworks (Guice, Spring, Weld) or similar advanced tool.
Main service is ShoppingCartService. XmlToJavaService and FileNameValidator are support services.
For this standalone project main class is ShoppingCartItemsImporter which connects all services.


 == Unit tests ==

In test/resources directory are persistence.xml, xml file examples for different scenarios and xsd file for xml file validation during tests.
JAXB tests test if conversion method properly works with valid xsd file , valid xml file, with not properly formatted xml file and wrong structure of xml file.
JPA tests test DAO classes, fetch and persist of entities.
Test for File read is implicit within jaxb conversion tests.


 == development time line ==

1. Extract obvious requirements from documentation.
2. create project skeleton with maven.
3. Create basic file reader.
4. Create service prototype for conversion of XML file to Java objects.
5. Create DAO layer for important entities.
6. Combine peaces into application.
7. Set unit tests for DAO classes and XML conversion service.

Iterative procedure for improvement:
- Acceptance testing - Run jar archive and inspect results
- Upgrade service, method or algorithm.
- Upgrade tests to cover new feature.
- Check documentation for missed or misinterpreted details.
- Code refactoring and formatting.
- Added integration test for ShoppingCartService.
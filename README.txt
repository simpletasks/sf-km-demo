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
	

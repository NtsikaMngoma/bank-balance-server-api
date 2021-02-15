# Discovery Bank Server #

A simple application to get started with backend data processing and banking in general.

### What is this repository for? ###

* This is an API application meant to allow for transactional bankings
* Version 0.0.1
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### Tools used: ###

* Spring Data JPA
* Hibernate
* Technical project summary:
	- DTO and interface projection for all get requests and select statements.
	- The heavy lifting is done on the DB side, with assistance from Hibernate.
	- The use case for this is performance more than anything else.
	- Just a personal preference to optimize SQL queries for GET requests.
	- Some unit testing in JUnit.
	- I have avoided any annotation processor such as Lombok or Mapstruct, 
	so I can leverage off what I can with JPA and Hibernate.
* I have tried to keep things very simple without adding too many dependencies either.
* To run on the cli, run ./gradlew, didn't add Jasypt as well, so there shouldn't be any decryption issues with properties, I have kept it very simple.

### DB
* Open bash and run commands:
- sudo yum install @mysql (RHEL) or other commands for your PC distribution.
- create user schemaManager@'%' identified by 's3cretP@$$w0rd';
- create discovery_bank_schema;
- grant all privileges on discovery_bank_schema.* to schemaManager@'%';
- flush privileges;
- open up mysql cli: mysql -uschemaManager -ps3cretP@$$w0rd
- run script:
	1) use discovery_bank_schema;
	2) run source /{path-to-script}/discoverySchema.sql
* Make sure that the connection string matches the one in the project.

### Getting Started ###

* Import gradle project in your IDE of choice.
* Make sure you have the correct runtimes configured.
* Boot up the spring project.
* Enjoy
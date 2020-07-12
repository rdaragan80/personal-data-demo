## Simple application with database access;
Based on an input from the user provide the following functionality;
Provide help

**1. Add Person (id, firstName, lastName)**

**2. Edit Person (firstName, lastName)**

**3. Delete Person (id)**

**4. Add Address to person [multiple required] (id, street, city, state,postalCode)**

**5. Edit Address (street, city, state, postalCode)**

**6. Delete Address (id)**

**7. Count Number of Persons**

**8. List Persons**


## Steps to Setup

**1. Clone the repository**

```bash
git clone https://github.com/rdaragan80/personal-data-demo.git
```

**2. Configure PostgreSQL**

First, create a database named `personData`. Then, open `src/main/resources/application.properties` file 
and change the spring datasource username and password as per your PostgreSQL installation.



**3. Run the app**

Type the following command from the root directory of the project to run it -

```bash
mvn spring-boot:run
```

Alternatively, you can package the application in the form of a JAR file and then run it like so -

```bash
mvn clean package
java -jar target/personal-data-demo-0.0.1-SNAPSHOT.jar
```

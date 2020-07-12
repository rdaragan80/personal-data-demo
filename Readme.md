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

<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-ycyt{background-color:#67fd9a;border-color:inherit;font-weight:bold;text-align:center;vertical-align:top}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
.tg .tg-0lax{text-align:left;vertical-align:top}
</style>
<table class="tg">
<thead>
  <tr>
    <th class="tg-ycyt">Base URI </th>
    <th class="tg-ycyt">Function</th>
    <th class="tg-ycyt">URI</th>
    <th class="tg-ycyt">HTTP Methods</th>
    <th class="tg-ycyt">Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-0pky">/api/v1</td>
    <td class="tg-0pky">findAll</td>
    <td class="tg-0pky">/persons</td>
    <td class="tg-0pky">GET</td>
    <td class="tg-0pky">Find all Persons object that found - returns List&lt;Person&gt;</td>
  </tr>
  <tr>
    <td class="tg-0pky">/api/v1</td>
    <td class="tg-0pky">countAllPersons<br></td>
    <td class="tg-0pky">/persons/count</td>
    <td class="tg-0pky">GET</td>
    <td class="tg-0pky">Count Number of Persons - returns Long</td>
  </tr>
  <tr>
    <td class="tg-0pky">/api/v1</td>
    <td class="tg-0pky">getPersonById</td>
    <td class="tg-0pky">/persons/{id}</td>
    <td class="tg-0pky">GET</td>
    <td class="tg-0pky">Get Person by id - returns ResponseEntity&lt;Person&gt;</td>
  </tr>
  <tr>
    <td class="tg-0lax">/api/v1</td>
    <td class="tg-0lax">createPerson</td>
    <td class="tg-0lax">/persons</td>
    <td class="tg-0lax">POST</td>
    <td class="tg-0lax">Create new Person - returns ResponseEntity&lt;Person&gt;</td>
  </tr>
  <tr>
    <td class="tg-0lax">/api/v1</td>
    <td class="tg-0lax">updatePerson</td>
    <td class="tg-0lax">/persons/{id}</td>
    <td class="tg-0lax">PUT</td>
    <td class="tg-0lax">Update existing Person by id - returns ResponseEntity&lt;Person&gt;</td>
  </tr>
  <tr>
    <td class="tg-0lax">/api/v1</td>
    <td class="tg-0lax">deletePerson</td>
    <td class="tg-0lax">/persons/{id}</td>
    <td class="tg-0lax">DELETE</td>
    <td class="tg-0lax">Delete existing Person, return true if Person deleted</td>
  </tr>
  <tr>
    <td class="tg-0lax">/api/v1</td>
    <td class="tg-0lax">createAddress</td>
    <td class="tg-0lax">/address/person/{id}</td>
    <td class="tg-0lax">POST<br></td>
    <td class="tg-0lax">Create Address for Person with id, return ResponseEntity&lt;Address&gt;</td>
  </tr>
  <tr>
    <td class="tg-0lax">/api/v1</td>
    <td class="tg-0lax">updateAddress</td>
    <td class="tg-0lax">/persons/{id}/address/{id}</td>
    <td class="tg-0lax">PUT</td>
    <td class="tg-0lax">Update Address, return ResponseEntity&lt;Address&gt;</td>
  </tr>
  <tr>
    <td class="tg-0lax">/api/v1</td>
    <td class="tg-0lax">deleteAddress</td>
    <td class="tg-0lax">/persons/{id}/address/{id}</td>
    <td class="tg-0lax">DELETE</td>
    <td class="tg-0lax">Delete address that is associated with person, returns true if deleted</td>
  </tr>
</tbody>
</table>

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

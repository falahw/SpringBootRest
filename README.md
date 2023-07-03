# SpringBootRest
This project contain Rest-API that is generated with Java Spring Boot, Hibernate, and JPA. Also tested with Postman

## How-to-Use
- pull or download file 'SpringBootRest-0.0.1-SNAPSHOT.jar' and 'alien_rest3' (this is csv file)
- use postgresql or pgAdmin to import file 'alien_rest3', database table will be extracted from the file
- run file 'SpringBootRest-0.0.1-SNAPSHOT.jar' by typing 'java -jar SpringBootRest-0.0.1-SNAPSHOT.jar'
- GET request can be done in browser by typing http://localhost:8080/aliens or http://localhost:8080/aliens/[put user id here]
- for other API requests must be done in API client like Postman app


# API Documentation
- GET --> get all users in database
    http://localhost:8080/aliens

- GET by user id --> get user from database by id
    http://localhost:8080/aliens/[put user id here]

- POST --> insert new data to database table
    http://localhost:8080/alien

    write this in body of API tool (assume that we are using Postman) in JSON format:
    {
        alId: (write new id manually),
        alName: "(write new name here)",
        alPoints: (write new score)
    }

- DELETE --> remove data row from database table
    http://localhost:8080/alien/[put user id here]

- PUT --> update data in particular column
    http://localhost:8080/alien

    do this in body of API tool. Change/alter/replace any data in particular column by writing the new one in JSON format:
    { //you can change one of these or all of them
        alId: (write alter id here),
        alName: "(write alter name here)",
        alPoints: (write alter score here)
    }
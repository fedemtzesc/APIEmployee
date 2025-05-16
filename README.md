
# Employee's CRUD Project

REST API to manage a CRUD of company employees


## API Contract

### 1.0 Retrieves the list of all registered Employees
###### If no employees are registered into DB, an empty list is returned. Using the GET method

```http
  GET /api/v1/employee
```

No parameter needed, just call end-point using GET Method.

### 2.0 Query an Employee by their ID in the endpoint's path
###### If employee not found into DB, a message and status will be returned. Using the GET method

```http
  GET /api/v1/employee/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of Employee to fetch |

#### getById(@PathVariable Long id)
    Takes the Id and look for corresponding Employee into DB.

### 3.0 Create a new Employee
###### Create a new employee using the POST method
```http
  POST /api/v1/employee
```

| Parameter         | Type        | Description                                                                                                                                            |
|:------------------|:------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `firstName`       | `String`    | **Required**.                                                                                                                                          |
| `middleName`      | `String`    | **Required**.                                                                                                                                          |
| `paternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `maternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `age`             | `String`    | **Required**.                                                                                                                                          |
| `sex`             | `Enum`      | **Required**. Posible values:FEMALE\|MALE                                                                                                              |
| `birthDate`       | `LocalDate` | **Required**. Format: yyyy-MM-dd<br/>example: "1973-07-13"                                                                                             |
| `jobPosition`     | `Enum`      | **Required**. Posible values:TELLER\|SECRETARY\|SECRETARY\|<br/>EXECUTIVE\|MANAGER\|SUPERVISOR\|<br/>GENERAL_MANAGER\|STAFF\|<br/>DEVELOPPER\|SECURITY |

    Request Example (creating only one new Employee):
    {
        "firstName": "Jhony",
        "middleName": "Taylor",
        "paternalSurname": "Deep",
        "maternalSurname": "Juarez",
        "age": "45",
        "sex": "MALE",
        "birthDate": "1970-05-15",
        "jobPosition": "DEVELOPPER"
    }

#### createNew(@RequestBody EmployeeEntity newEmployee)
    Takes the new Employee data, save's into DB, and returns the new Employe with 
    his asigned Id after has being created.

### 4.0 Update an Employee
###### Update an employee specifing it's Id, and all the rest of fields. using the PUT method
```http
  PUT /api/v1/employee
```

| Parameter         | Type        | Description                                                                                                                                            |
|:------------------|:------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Id`              | `Long`      | **Required**.                                                                                                                                          |
| `firstName`       | `String`    | **Required**.                                                                                                                                          |
| `middleName`      | `String`    | **Required**.                                                                                                                                          |
| `paternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `maternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `age`             | `String`    | **Required**.                                                                                                                                          |
| `sex`             | `Enum`      | **Required**. Posible values:FEMALE\|MALE                                                                                                              |
| `birthDate`       | `LocalDate` | **Required**. Format: yyyy-MM-dd<br/>example: "1973-07-13"                                                                                             |
| `jobPosition`     | `Enum`      | **Required**. Posible values:TELLER\|SECRETARY\|SECRETARY\|<br/>EXECUTIVE\|MANAGER\|SUPERVISOR\|<br/>GENERAL_MANAGER\|STAFF\|<br/>DEVELOPPER\|SECURITY |

    Request Example (updating an Employee unsing it's Id):
    {
        "id":"1",
        "firstName": "Jhony",
        "middleName": "Taylor",
        "paternalSurname": "Deep",
        "maternalSurname": "Juarez",
        "age": "45",
        "sex": "MALE",
        "birthDate": "1970-05-15",
        "jobPosition": "DEVELOPPER"
    }

#### update(@RequestBody EmployeeEntity updEmployee)
    Takes the new Employee data with it's Id, save's into DB, and returns the updated Employe

### 5.0 Delete an Employee
###### Delete an employee specifing it's Id in the end-point's path. Using the DELETE method

```http
  GET /api/v1/employee/${id}
```

| Parameter | Type     | Description                               |
| :-------- | :------- |:------------------------------------------|
| `id`      | `Long` | **Required**. Id of Employee for deletion |

#### delete(@PathVariable Long id)
    Takes the Id from path and proceeds to delete it's correspondign Employee register into DB

### 6.0 Create one or many Employees
###### Save one or a Employees list into DB. Using the POST method
```http
  POST /api/v1/employee
```

| Parameter         | Type        | Description                                                                                                                                            |
|:------------------|:------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `firstName`       | `String`    | **Required**.                                                                                                                                          |
| `middleName`      | `String`    | **Required**.                                                                                                                                          |
| `paternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `maternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `age`             | `String`    | **Required**.                                                                                                                                          |
| `sex`             | `Enum`      | **Required**. Posible values:FEMALE\|MALE                                                                                                              |
| `birthDate`       | `LocalDate` | **Required**. Format: yyyy-MM-dd<br/>example: "1973-07-13"                                                                                             |
| `jobPosition`     | `Enum`      | **Required**. Posible values:TELLER\|SECRETARY\|SECRETARY\|<br/>EXECUTIVE\|MANAGER\|SUPERVISOR\|<br/>GENERAL_MANAGER\|STAFF\|<br/>DEVELOPPER\|SECURITY |

    Request Example (creating 2 new Employees):
    [
        {
            "firstName": "Jhony",
            "middleName": "Taylor",
            "paternalSurname": "Deep",
            "maternalSurname": "Juarez",
            "age": "45",
            "sex": "MALE",
            "birthDate": "1970-05-15",
            "jobPosition": "DEVELOPPER"
        },
        {
            "firstName": "Alejandra",
            "middleName": "",
            "paternalSurname": "Guzman",
            "maternalSurname": "Pinal",
            "age": "60",
            "sex": "FEMALE",
            "birthDate": "1964-07-21",
            "jobPosition": "TELLER"
        }
    ]

#### createEmployeeBatch(@RequestBody List<EmployeeEntity> employees)
    Takes the Employee List data , save them into DB, and returns the created new Employe List.

### 7.0 Create one or many Employees
###### Save one or a Employees list into DB. Using the POST method
```http
  POST /api/v1/employee
```

| Parameter         | Type        | Description                                                                                                                                            |
|:------------------|:------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `firstName`       | `String`    | **Required**.                                                                                                                                          |
| `middleName`      | `String`    | **Required**.                                                                                                                                          |
| `paternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `maternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `age`             | `String`    | **Required**.                                                                                                                                          |
| `sex`             | `Enum`      | **Required**. Posible values:FEMALE\|MALE                                                                                                              |
| `birthDate`       | `LocalDate` | **Required**. Format: yyyy-MM-dd<br/>example: "1973-07-13"                                                                                             |
| `jobPosition`     | `Enum`      | **Required**. Posible values:TELLER\|SECRETARY\|SECRETARY\|<br/>EXECUTIVE\|MANAGER\|SUPERVISOR\|<br/>GENERAL_MANAGER\|STAFF\|<br/>DEVELOPPER\|SECURITY |

    Request Example (creating 2 new Employees):
    [
        {
            "firstName": "Jhony",
            "middleName": "Taylor",
            "paternalSurname": "Deep",
            "maternalSurname": "Juarez",
            "age": "45",
            "sex": "MALE",
            "birthDate": "1970-05-15",
            "jobPosition": "DEVELOPPER"
        },
        {
            "firstName": "Alejandra",
            "middleName": "",
            "paternalSurname": "Guzman",
            "maternalSurname": "Pinal",
            "age": "60",
            "sex": "FEMALE",
            "birthDate": "1964-07-21",
            "jobPosition": "TELLER"
        }
    ]

#### createEmployeeBatchFunctional(@RequestBody List<EmployeeEntity> employees)
    Takes the Employee List data , save them into DB, and returns the created new Employe List.

### 8.0 Partial Update an Employee
###### Update an employee specifing it's Id, and only field that you need to update. using the PATCH method
```http
  PATCH /api/v1/employee
```

| Parameter         | Type        | Description                                                                                                                                            |
|:------------------|:------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Id`              | `Long`      | **Required**.                                                                                                                                          |
| `firstName`       | `String`    | **Required**.                                                                                                                                          |
| `middleName`      | `String`    | **Required**.                                                                                                                                          |
| `paternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `maternalSurname` | `String`    | **Required**.                                                                                                                                          |
| `age`             | `String`    | **Required**.                                                                                                                                          |
| `sex`             | `Enum`      | **Required**. Posible values:FEMALE\|MALE                                                                                                              |
| `birthDate`       | `LocalDate` | **Required**. Format: yyyy-MM-dd<br/>example: "1973-07-13"                                                                                             |
| `jobPosition`     | `Enum`      | **Required**. Posible values:TELLER\|SECRETARY\|SECRETARY\|<br/>EXECUTIVE\|MANAGER\|SUPERVISOR\|<br/>GENERAL_MANAGER\|STAFF\|<br/>DEVELOPPER\|SECURITY |

    Request Example (updating an Employee using it's Id):
        In this example, we just updating the following 
        fields excluding the Id field...
    {
        "id":"1",
        "middleName": "",
        "paternalSurname": "Deep",
        "maternalSurname": "Juarez",
        "jobPosition": "EXECUTIVE"
    }

#### partialUpdateEmployee(@PathVariable Long id,@RequestBody EmployeePatchDTO patchDTO)
    Takes the new Employee data with it's Id, update's into DB, only requiered fields, and 
    returns the updated Employee

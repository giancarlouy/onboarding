# Onboarding Application

This is a simple Spring boot application developed as part of [TRNSCT-130](https://fccjira.atlassian.net/browse/TRNSCT-130).

<br />

In order to configure this application properly, you must create the following schemas created in your local database:

| Schema       | URL                                      |
| ------------ | ---------------------------------------- |
| onboarding   | jdbc:mysql://localhost:3306/onboarding   |
| australia    | jdbc:mysql://localhost:3306/australia    |
| unitedstates | jdbc:mysql://localhost:3306/unitedstates |

<br />

> Note: These configurations can be found under `src` > `main` > `resources` > `application-*.properties` files

<br />

These are the following endpoints that reside within the application:

| API         | Description                                | Endpoint                             | HTTP Request Method |
|-------------|--------------------------------------------|--------------------------------------|---------------------|
| CompanyAPI  | Create a company                           | `/companies/employee`                | `POST`              |
| CompanyAPI  | Find a company by company name and country | `/companies/{copmanyName}/{country}` | `GET`               |
| EmployeeAPI | Create an employee                         | `/employees/employee`                | `POST`              |
| EmployeeAPI | Find an employee by tax payer id           | `/employees/employee/{taxPayerId}`   | `GET`               |
| EmployeeAPI | Find an employee by company name           | `/employees/employee`                | `GET`               |

<br />

Sample payloads for each endpoint:

`POST /companies/employee`
```
{
    "companyName": "Finstro",
    "country": "Australia"
}
```

<br />

`GET /companies/{companyName}/{country}`
```
{
    /companies/Finstro/Australia
}
```

<br />

`POST /employees/employee`
```
{
    "firstName": "Gian",
    "lastName": "Uy",
    "taxPayerId: 1,
    "company": {
        "companyName": "Finstro",
        "country": "Australia"
    }
}
```

<br />

`GET /employees/employee/{taxPayerId}`
```
{
    /employees/employee/1
}
```

<br />

`GET /employees/employee`
```
{
    /employees/employee?companyName=Finstro
}
```

<br />

> To run the application, you must first supply a password and profile within the VM options of IntelliJ: `-Dspring.datasource.password=${password}` and `-Dspring.profiles.active=${country}`.
> Afterwards, navigate your way to the `OnboardingApplication.java` class and hit run.

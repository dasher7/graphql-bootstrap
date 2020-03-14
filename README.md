# GraphQL Bootstrap [Spring Boot]

A little project to skyrocket your way into GraphQL and Spring Boot.
The project is ready to go to try out all GraphQL's functionality.

## Tech Stack and Dependecy

GraphQL is pretty a new thing for most of the user, and for this reason, all of its implementation are ongoing.
From version to version you may find lots of difference, so, here's the following technology and dependecy used for this project.
  
  - Java 8
  - Spring Boot 2.2.5
  - Gradle
  - GraphQL Spring Boot Starter 5.0.2
  - GraphQL Java Tools 5.2.4
  - Lombok 1.18.4
  - H2 Database
  
## Installation

In your console, simply:

``` git clone https://github.com/dasher7/webflux-api.git ```

Import your code into your favourite IDE, I invite you to use Sping Tools Suite (STS 4).

Install [Lombok] (https://projectlombok.org/)
Update your Gradle Dependecy and then just:

``` gradle bootRun ```

Or run via STS config.

## Usage

You can visit your H2 database here:
``` http://localhost:8080/h2-console/login.jsp ```
note: use the parameter in *application.properties*

You GraphQL endpoint will be:
``` http://localhost:8080/graphql ```

First thing first, hit the following endpoint:
``` http://localhost:8080/graphql/schema.json ```
The response will be a JSON with all the specification of your API.

### Example

All your request will be managed only by this endpoint:
``` http://localhost:8080/graphql ```

I'll provied an example of you can query your new little toy.

#### @POST - save a new author
    ```graphql
        mutation {
            newAuthor(
              firstName: "Ken",
              lastName: "Follet"
               )
         }
      ```
      
#### @POST - find all books
    ```graphql
            {
              findAllBooks {
                 id
                 title
                }
            }
      ```
      
## Contribuiton and Usage

Feel free to use the project for your own like.
NOTE: The project is always a WIP, because I will always try new things and test new topic.

## License

[MIT](https://choosealicense.com/licenses/mit/)

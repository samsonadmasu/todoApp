# Todo Microservice Application

## Development
Build a Todo Microservices Application
### Prerequisites

- Java 17
- Spring Boot
- Spring Cloud
- H2 database

### Task Description:

- Users should be able to create, read, update, and delete Todos.
- Todos should have a title, description, and a due date.
- Users should be able to mark Todos as completed.
- Users should be able to get a list of all their Todos and - filter them by completion status and due date.
- You should use Java Spring to build the microservices.
- You should follow RESTful API design principles.
- You should use an in-memory database such as H2 or Redis for each microservice. If you don't have experience with them, use mock data.
- You should write unit tests for your code.
- You should provide clear and concise documentation for each microservice and the API Gateway.
- Add a README file that has documentation of how to run/test it.
### Todo service

    todo-service



- The service should expose RESTful endpoints for creating, reading, updating, and deleting Todos.
- The service should communicate with the User service to ensure that only the owner of a Todo can modify or delete it.
- This service should handle all CRUD operations for the Todo entity.

### User service

    user-service



- This service should handle all operations related to users.
- The service should expose RESTful endpoints for creating, reading, updating, and deleting users.
- The service should provide authentication and authorization functionality for the Todo service.
- The service should communicate with the Todo service to ensure that only the owner of a Todo can modify or delete it.
### App gateway
Run the application utilities: SQS Messaging, Create SQS QUEUE and Storage Service

    api-gateway


- This service should act as the entry point for all external requests to the microservices application.
- The service should be responsible for routing requests to the appropriate microservice.
- The service should provide authentication and authorization functionality for the Todo and User services.
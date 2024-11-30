# java-github-workspaces-preview-2

## Project Description

This project is a customer feedback collection system. It provides a backend REST API that enables customers to submit their feedback securely. The backend is prepared for front-end work with a stable API that maintains data integrity.

## Technologies Used

- Java 21
- Spring Boot
- PostgreSQL (running inside Docker Compose for development)

## Running the Project with Docker Compose

To run the project with Docker Compose, follow these steps:

1. Ensure you have Docker and Docker Compose installed on your machine.
2. Navigate to the project directory.
3. Run the following command to start the PostgreSQL database:

   ```sh
   docker-compose up
   ```

4. The PostgreSQL database will be available at `localhost:5432`.
5. You can now run the Spring Boot application using your preferred method (e.g., from your IDE or using the command line).

## Running the Project with Maven

To run the project with Maven, follow these steps:

1. Ensure you have Maven installed on your machine.
2. Navigate to the project directory.
3. Run the following command to start the Spring Boot application:

   ```sh
   mvn spring-boot:run
   ```

4. The application will start and be available at `http://localhost:8080`.

## Running the Project with IDE

To run the project with an IDE, follow these steps:

1. Import the project into your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
2. Ensure that the IDE is configured to use JDK 21.
3. Run the `FeedbackApplication` class as a Java application.
4. The application will start and be available at `http://localhost:8080`.

## Running Tests

To run the tests for this project, follow these steps:

1. Ensure you have Maven installed on your machine.
2. Navigate to the project directory.
3. Run the following command to execute the tests:

   ```sh
   mvn test
   ```

4. The tests will be executed, and the results will be displayed in the console.

## Additional Information for Developers

- The project follows the ports and adapters architecture (also known as Hexagonal Architecture) for the backend code.
- The code is covered by unit tests and integration tests.
- Validation annotations are used in the `Feedback` class to ensure that the email and feedback text fields are validated automatically by Spring.
- Error handling in the `FeedbackController` class is improved by adding more specific exception handlers for different types of errors.
- Logging is added to the application using the SLF4J logging framework.

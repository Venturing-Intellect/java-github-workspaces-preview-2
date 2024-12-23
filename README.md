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

## Frontend Setup and Running Instructions

To set up and run the React frontend for submitting feedback, follow these steps:

1. Navigate to the `frontend` directory:

   ```sh
   cd frontend
   ```

2. Install the required dependencies:

   ```sh
   npm install
   ```

3. Start the React development server:

   ```sh
   npm start
   ```

4. The React application will start and be available at `http://localhost:3000`.

5. You can now submit feedback using the form provided in the React frontend.

## Component Diagram

```mermaid
graph TD;
    A[Frontend] --> B[Backend];
    B[Backend] --> C[Database];

    subgraph Frontend
        A1[React App]
    end

    subgraph Backend
        B1[Spring Boot Application]
        B2[REST Controller]
        B3[Service Layer]
        B4[Repository Layer]
    end

    subgraph Database
        C1[PostgreSQL]
    end

    A1 --> B1
    B1 --> B2
    B2 --> B3
    B3 --> B4
    B4 --> C1
```

### Technical Details

- **Frontend**: The frontend is a React application that allows users to submit feedback through a form. It communicates with the backend via REST API calls.
- **Backend**: The backend is a Spring Boot application that handles the business logic and data persistence.
  - **REST Controller**: Handles incoming HTTP requests and maps them to appropriate service methods.
  - **Service Layer**: Contains the business logic of the application.
  - **Repository Layer**: Interacts with the database to perform CRUD operations.
- **Database**: PostgreSQL is used as the database to store feedback data.

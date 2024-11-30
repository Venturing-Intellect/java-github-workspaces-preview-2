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

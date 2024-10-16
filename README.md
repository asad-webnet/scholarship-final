# Pariksha

Pariksha is a web application designed to help students apply for scholarships. The application allows admins to manage scholarships and students to submit their applications easily.

## Features

- Admin can add and delete scholarships.
- Students can apply for scholarships.
- Admin can view applications submitted by students.

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Thymeleaf
- H2 Database (in-memory for testing)
- Bootstrap (for styling)

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd pariksha
   
2. Ensure Maven is Installed Make sure you have Maven installed on your machine. You can check by running: mvn -v


3.Build the Application Navigate to the project root folder and run: 
mvn clean install

4. To run the application, execute the following command in the project root folder:
mvn spring-boot:run

5. Once the application is running, you can access it at:
http://localhost:8081

6. To access the admin dashboard, visit:
http://localhost:8081/admin

7. Admin Login Credentials
Username: admin
Password: admin



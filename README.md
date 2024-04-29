# Project Management App

This is a web-based project management application built with ReactJS (with Bootstrap), Spring Boot backend, using JWT for authentication, RESTful services, Lombok, and PostgreSQL for the database.

## Features

- **Secure Authentication**: Users can securely log in using JWT authentication.
- **Endpoint Authorization**: Endpoints are protected with authorization to ensure secure access.
- **Role-Based Access Control**: Different roles have access to different features of the application.
- **CRUD Operations on Projects**: Users can create, read, update, and delete projects.
- **Task Management**: Projects can have tasks with full CRUD operations (Create, Read, Update, Delete).
- **User Management**: Full CRUD operations are available for managing user accounts.
- **User Registration**: New users can register for an account.
- **Email Notification**: Users can view a list of other users and contact them via email.

## Technologies Used

- **Frontend**:
  - ReactJS
  - Bootstrap
  
- **Backend**:
  - Spring Boot
  
- **Authentication**:
  - JWT (JSON Web Tokens)
  
- **Database**:
  - PostgreSQL
  
- **Additional Libraries**:
  - Lombok

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository:
   ```bash
   git clone <repository-url>

2. Navigate into the project directory:
  ```bash
  cd project-management-app
```

4. Install dependencies:
  ```bash
   npm install
```

5. Create Jar file
  ```bash
   mvn package
```

6. Start the frontend and backend servers:
  ```bash
  npm start     # Start frontend server
  java -jar -[project name] # Start backend server
```


## Usage

1. Open the application in your web browser.
2.  Log in using your credentials.
3.  Explore the various features such as creating projects, managing tasks, and contacting other users.
4. Enjoy managing your projects efficiently!

## License
This project is licensed under the MIT License.

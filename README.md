🚀 Features

Add new records

Fetch all records

Fetch record by ID

Update existing record

Delete record

MySQL database integration

Clean and modular code structure

🛠️ Technologies Used

Java

Spring Boot

Spring Web

Spring Data JPA

MySQL Database

Maven

📦 Project Structure
src/
 └── main/
     ├── java/com/example/project
     │     ├── controller
     │     ├── service
     │     ├── repository
     │     ├── entity
     │     └── dto (optional)
     └── resources/
           ├── application.properties
           └── schema.sql (optional)

⚙️ Setup & Installation
1. Clone the repository
git clone https://github.com/your-username/your-repo-name.git

2. Configure MySQL

Create a database in MySQL:

CREATE DATABASE your_db_name;


Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Run the project

Use your IDE or run the following command:

mvn spring-boot:run

🧪 API Endpoints
Method	Endpoint	Description
POST	/api/items	Add new item
GET	/api/items	Get all items
GET	/api/items/{id}	Get item by ID
PUT	/api/items/{id}	Update item
DELETE	/api/items/{id}	Delete item

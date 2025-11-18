<p align="center">
  <img src="crud-rest-api-with-mysql-banner.png" width="100%" alt="CRUD REST API Banner">
</p>

# CRUD REST API with MySQL

## 🚀 Features
- Add new records  
- Fetch all records  
- Fetch record by ID  
- Update existing record  
- Delete record  
- MySQL database integration  
- Clean and modular code structure  

---

## 🛠️ Technologies Used
- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- MySQL Database  
- Maven  

---

## 📦 Project Structure
src/
└── main/
├── java/com/example/project
│ ├── controller
│ ├── service
│ ├── repository
│ ├── entity
│ └── dto (optional)
└── resources/
├── application.properties
└── schema.sql (optional)

yaml
Copy code

---

## ⚙️ Setup & Installation  

### 1. Clone the repository
```bash
git clone https://github.com/your-username/your-repo-name.git
2. Configure MySQL
Create a database:

sql
Copy code
CREATE DATABASE your_db_name;
Update application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Run the project
bash
Copy code
mvn spring-boot:run


🧪 API Endpoints
Method	Endpoint	Description
POST	/api	Add new item
GET	/api/items	Get all items
GET	/api/items/{id}	Get item by ID
PUT	/api/items/{id}	Update item
DELETE	/api/items/{id}	Delete item

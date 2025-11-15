College Management System — Java + MySQL (JDBC)

This is a console-based College Management System built using Java, MySQL, and JDBC.
It demonstrates clean modular coding, proper database integration, DAO architecture, and real-world CRUD operations.

This project is ideal for:

Placements

Internship portfolios

DSA + Java practice

Learning MySQL + JDBC fundamentals

Resume / GitHub showcase

🚀 Features

➕ Add Student

📄 List All Students

🔍 Search Student by Roll Number

❌ Delete Student by ID

🗄 Database Storage (Persistent using MySQL)

🧱 DAO Layer Architecture

🔗 JDBC Connectivity

🧱 Architecture

The project follows a 4-layer architecture:

1️⃣ app → Main application & user interface
2️⃣ model → Data classes (Student)
3️⃣ dao → Database CRUD operations
4️⃣ util → Database connection helper (DBUtil)

This keeps the project clean, maintainable, and scalable.

🗄 Database Structure (ER Design)
students
-----------------------------------
id (INT, PRIMARY KEY, AUTO_INCREMENT)
roll_no (VARCHAR)
name (VARCHAR)
age (INT)
email (VARCHAR)

🧰 Technologies Used

Java 17+

MySQL 8.0+

JDBC (MySQL Connector/J)

VS Code

Git & GitHub

▶️ How to Run the Project
1. Create Database
CREATE DATABASE college_db;

2. Create Application User
CREATE USER 'cms_user'@'localhost' IDENTIFIED BY 'cms_pass';
GRANT ALL PRIVILEGES ON college_db.* TO 'cms_user'@'localhost';
FLUSH PRIVILEGES;

3. Compile
javac -d out -cp "lib/*" src/util/*.java src/model/*.java src/dao/*.java src/app/*.java

4. Run
java -cp "out;lib/*" app.Main

🎯 Future Enhancements

Add login system (Admin / Student)

Add GUI using JavaFX or Swing

Add Subjects & Marks tables

Add PDF/Excel export

Convert to Web App using Spring Boot

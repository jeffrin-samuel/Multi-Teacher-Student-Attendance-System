🎓 Multi-Teacher Attendance System (JavaFX + MySQL)

A beginner-friendly attendance management system where:

👑 Admins can manage everything
👨‍🏫 Teachers can only manage their own students & subjects

Built using JavaFX + MySQL + Maven, designed so even beginners can install and run it easily.

✨ Features

✔ Admin & Teacher Login
✔ Add / Edit / Delete Students
✔ Subject & Course Management
✔ Auto-Enrollment Based on Course + Semester
✔ Daily Attendance & History Viewer
✔ Dashboard with Stats
✔ Secure Passwords (BCrypt)
✔ Works in IntelliJ OR VS Code

🧰 What You Need Before Running
Tool	Why You Need It
Java 17+	To run the project
Maven	To download libraries
MySQL (XAMPP or MySQL Workbench)	To store attendance data
IDE: IntelliJ OR VS Code	To run the program
(Optional) SceneBuilder	To edit FXML UI visually
📦 1. Download the Project
🟢 Option A: Git (Recommended)
git clone https://github.com/YOUR_USERNAME/Multi-Teacher-Student-Attendance-System.git

🔵 Option B: No Git

Click Code → Download ZIP → Extract it.

🗄️ 2. Database Setup (SUPER EASY GUIDE)
✔ Works with BOTH MySQL Workbench & XAMPP phpMyAdmin
Step 1: Create Database

Open MySQL Workbench and run:

CREATE DATABASE attendance_system;


OR in phpMyAdmin:

Open localhost/phpmyadmin

Click “New”

Enter: attendance_system

Click Create

Step 2: Import the SQL File

File location in project:

database/attendance_system.sql

⭐ MySQL Workbench:

✔ Server → Data Import
✔ Import from Self-Contained File
✔ Select attendance_system.sql
✔ Start Import

⭐ phpMyAdmin:

✔ Click database
✔ Import tab
✔ Select file
✔ Click Go

🎉 Your database is now ready!

🔌 3. Update Database Settings (IMPORTANT)

Open this file:

src/main/java/com/bsmi/attendancesystem/DatabaseConnection.java

If you use MySQL root user:
String databaseUser = "root";
String databasePassword = "";

If you used:
username = admin
password = admin


then you do NOT need to change the file.

▶️ 4. Run the Application
🟢 IntelliJ IDEA

Open project

Let Maven finish

Right-click:

src/main/java/com/bsmi/attendancesystem/AttendanceApplication.java


Click Run

🔵 VS Code

Install Java Extension Pack

Open project folder

Open AttendanceApplication.java

Click Run (play ▶ button)

🔑 Default Login Accounts
Role	Username	Password
Admin	admin	admin123
Teacher	teacher1	teacher123

👉 These are controlled INSIDE the database, not MySQL.

📁 Project Structure (Simple View)
project/
├── src/
│   ├── main/java/com/bsmi/attendancesystem/
│   └── main/resources/
├── database/
│   └── attendance_system.sql
├── screenshots/
├── pom.xml
└── README.md

🛠️ Common Problems & Fixes
❌ Database not connecting

✔ Make sure MySQL service is running
✔ Check DB username/password in DatabaseConnection.java
✔ Database name MUST be: attendance_system

❌ JavaFX not found

✔ You must use JDK 17 or above
✔ Make sure Maven finished downloading dependencies
✔ Try mvn clean install

❌ SceneBuilder not loading FXML

✔ Install SceneBuilder
✔ Open .fxml files from /src/main/resources/

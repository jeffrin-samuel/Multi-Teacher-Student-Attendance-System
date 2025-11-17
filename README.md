# Multi-Teacher Attendance System (JavaFX + MySQL)

## Overview
A simple JavaFX-based attendance system with **Admin** and **Teacher** roles.
Admins can manage everything. Teachers can only access their assigned subjects & students.

## Features
- Admin + Teacher login
- Add/Edit/Delete students
- Subject & course management
- Auto student enrollment by semester/course
- Attendance marking + history view
- Dashboard statistics
- BCrypt password security
- Works on IntelliJ IDEA or VS Code

## Requirements
- Java 17 or higher
- Maven
- MySQL (Workbench or XAMPP/phpMyAdmin)
- IntelliJ IDEA **or** VS Code
- (Optional) SceneBuilder

## Download the Project
### Option 1: Using Git
git clone https://github.com/jeffrin-samuel/Multi-Teacher-Student-Attendance-System.git

### Option 2: Without Git
Download ZIP → Extract

## Database Setup (VERY BEGINNER FRIENDLY)
### Step 1: Create Database
In MySQL Workbench or phpMyAdmin run:
CREATE DATABASE attendance_system;

### Step 2: Import SQL File
File path:
database/attendance_system.sql

#### In MySQL Workbench:
Server → Data Import → select file → import

#### In phpMyAdmin:
Select DB → Import → Choose file → Go

## Configuring Database in Code
Open:
src/main/java/com/bsmi/attendancesystem/DatabaseConnection.java

### If you use MySQL root user:
String databaseUser = "root";
String databasePassword = "";

### If using admin/admin (default):
No changes needed.

## Running the Application

### IntelliJ IDEA:
1. Open project
2. Wait for Maven to download dependencies
3. Run: AttendanceApplication.java

### VS Code:
1. Install "Java Extension Pack"
2. Open project folder
3. Run AttendanceApplication.java

## Default Login Credentials
| Role    | Username | Password    |
|---------|----------|-------------|
| Admin   | admin    | admin123    |
| Teacher | teacher1 | teacher123  |

## Project Structure
src/main/java/...        (Java code)
src/main/resources/...   (FXML, CSS, assets)
database/                (SQL file)
pom.xml                  (Maven build file)

## Common Problems & Fixes
### Cannot connect to DB
- MySQL not running
- Wrong user/password
- Database name must be `attendance_system`

### JavaFX errors
- Must use JDK 17+
- Run from IntelliJ or VS Code with Java extension
- Let Maven finish downloading dependencies

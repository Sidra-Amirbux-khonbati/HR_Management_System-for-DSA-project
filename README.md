# HR Management System (Java Swing)

This project is a **Java-based HR Management System** developed using **Java Swing**.
It provides a graphical user interface to manage employee records and demonstrates
basic **Data Structures and Algorithms** concepts.


## 📌 Project Overview

The system allows an organization to:
- Register employees
- Maintain employee records
- Sort employees automatically
- Search employees efficiently
- Record attendance (entry and exit time)
- Calculate employee salary

All operations are performed using a **GUI**, making the system user-friendly.


## 🧩 Main Components of the System

### 1. Employee Class
- Stores employee information:
  - Name
  - Employee ID
  - Entry time
  - Exit time
- Acts as a data model for the system


### 2. Sorting Module (Insertion Sort)
- Employees are sorted **by Employee ID**
- Sorting is performed using **Insertion Sort**
- Sorting occurs automatically whenever a new employee is registered
- After each step of sorting, the current order of employees is displayed using a GUI popup

**Purpose of using Insertion Sort:**
- Simple and easy to understand
- Suitable for small datasets
- Commonly taught in academic courses


### 3. Searching Module (Binary Search)
- Employee records are searched using **Binary Search**
- Binary Search works on a **sorted employee array**
- It allows faster searching compared to linear search
- Used when marking entry time, exit time, and calculating salary


### 4. Interview Module
- Displays predefined interview questions
- Uses a scrollable GUI window
- Helps simulate a basic interview process


### 5. Attendance Management
- Entry time is recorded using the current system time
- Exit time is also recorded automatically
- Java Time API is used for accurate time handling


### 6. Salary Calculation
- Salary is calculated based on:
  - Entry time
  - Exit time
  - Fixed hourly rate
- Working hours are calculated using time difference logic


## 🖥️ Technologies Used

- Java
- Java Swing (GUI)
- Java AWT (Layout management)
- Java Time API


## 🎯 Learning Outcomes

- Understanding of **Insertion Sort**
- Understanding of **Binary Search**
- Practical use of **Object-Oriented Programming**
- GUI development using Java Swing
- Working with date and time in Java


## ▶️ How to Run the Project

1. Open the project in any Java IDE (IntelliJ, Eclipse, NetBeans)
2. Run the `HR_Management_System.java` file
3. Use the buttons in the GUI to perform operations


## 👩‍💻 Group Project

Sidra Amirbux Khonbati 
Sanam Bibi Khonbati
BS Software Engineering Student  
Szabist University Karachi

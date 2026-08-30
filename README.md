# 🚌 Bus Reservation System

A console-based **Bus Reservation System** developed using **Java, JDBC, and MySQL**.

This project allows users to register and log in, view available buses, and book bus tickets for a specific date. The application uses **JDBC** to connect the Java application with a **MySQL database**.

---

## 📌 Project Overview

The Bus Reservation System is a simple console-based Java application that demonstrates how to perform database operations using JDBC.

The application provides user authentication and bus booking functionality. Users can register themselves, log in to the application, view available buses, and book a bus based on the available capacity.

---

## ✨ Features

- 👤 User Registration
- 🔐 User Login
- 🚌 View Available Buses
- 🎫 Book Bus Tickets
- 📅 Date-Based Booking
- 💺 Check Bus Capacity
- 🚫 Prevent Booking When Bus Is Full
- 🗄️ MySQL Database Integration
- 🔗 JDBC Database Connectivity
- 🖥️ Console-Based User Interface

---

## 🛠️ Technologies Used

| Technology | Usage |
|------------|-------|
| Java | Application Development |
| JDBC | Database Connectivity |
| MySQL | Database Management |
| SQL | Database Queries |
| Scanner | User Input |
| Eclipse / IntelliJ IDEA | Development Environment |

---

## 📂 Project Structure

The project follows a standard **Layered Architecture** to separate database operations, business logic, data models, and the user interface.

```text
Bus-Reservation-System-JDBC/
│
├── src/
│   └── com/
│       └── busreservation/
│           ├── model/          # Plain Java objects representing entities
│           │   ├── Bookings.java
│           │   ├── Bus.java
│           │   └── User.java
│           │
│           ├── dao/            # Database communication (JDBC & SQL)
│           │   └── BusDAO.java
│           │
│           ├── service/        # Business logic, validation & auth
│           │   ├── BookingService.java
│           │   └── UserService.java
│           │
│           └── main/           # Console UI and application entry point
│               └── BusMain.java
│
├── README.md
└── .gitignore
```
## 🧩 Class Responsibilities

| Class / Component | Layer | Primary Responsibility |
| :--- | :--- | :--- |
| **`BusMain.java`** | Presentation (`main`) | Acts as the entry point; manages the console menu, handles user inputs via `Scanner`, and coordinates application flow. |
| **`BusDAO.java`** | Data Access (`dao`) | Executes direct database operations using JDBC (`PreparedStatement`, `ResultSet`), including saving bookings and fetching records from MySQL. |
| **`Bookings.java`** | Model (`model`) | Serves as a POJO (Plain Old Java Object) holding passenger name, bus number, and journey date details. |
| **`Busregisterlogin.java`** | Service (`service`) | Manages user registration rules, password confirmation checks, and login authentication validation. |

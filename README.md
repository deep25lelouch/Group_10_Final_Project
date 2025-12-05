# 🏙️ Community Issue Reporting & Resolution Management System
### 🎓 Northeastern University | INFO 5100 Final Project | Fall 2025

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white)
![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)
![Group](https://img.shields.io/badge/Group-10-orange?style=for-the-badge)

---

## 👥 The Team
| Name | Role |
| :--- | :--- |
| **Rijurik Saha** | Lead Architect / Backend |
| **Avadhanam Vinaya Rekha** | UI/UX Designer |
| **Deep Prajapati** | Full Stack Developer |
| **Zenish Borad** | Testing & QA Lead |

---

## 📖 Table of Contents
- [Project Overview](#-project-overview)
- [System Architecture](#-system-architecture)
  - [High-Level Component Diagram](#high-level-component-diagram)
  - [UML Class Diagram](#uml-class-diagram)
- [Key Features](#-key-features)
- [Technology Stack](#-technology-stack)
- [Installation & Usage](#-installation--usage)
- [Login Credentials](#-login-credentials)
- [Golden Path Demo](#-golden-path-demo-script)

---

## 📖 Project Overview
The **Community Issue Reporting System** is a robust, enterprise-grade ecosystem designed to digitize municipal operations. It bridges the communication gap between **Citizens**, **City Departments**, and **Emergency Services**.

Unlike traditional linear systems, this project implements a **Complex Ecosystem Model** where multiple Enterprises (Public Works, Utilities, Safety) operate independently but can collaborate seamlessly through **Cross-Enterprise Work Requests**.

### 🎯 Problem Statement
Urban maintenance is often fragmented. A "Pothole" might actually be a "Water Leak" in disguise. Traditional systems trap this information in the Road Department. Our solution allows the Road Department to **escalate** the issue directly to the Water Department, creating a linked resolution chain.

---

## 🏗 System Architecture

### High-Level Component Diagram
*This diagram illustrates the hierarchical "Ecosystem" model used in the application.*

## 🏗 UML

### UML Diagram
*This diagram illustrates the hierarchical "Ecosystem" model used in the application.*

## 🚀 Key Features

### 🔐 1. Advanced Role-Based Security
* **10+ Unique Roles:** Granular access control (e.g., A *Plumber* cannot see *Police* data).
* **Smart Authentication:** Users are routed to their specific dashboard upon login (Factory Pattern).

### 🔄 2. Cross-Enterprise Collaboration (The "Wow" Factor)
* **Scenario:** A Road Technician discovers a pipe burst.
* **Action:** They click **"Escalate"** within the app.
* **Result:** A linked request is automatically routed to the **Water Department** in a completely different Enterprise.

### 🔔 3. Communication Ecosystem
* **Notification Center:** Real-time inbox for all users.
    * *Workers* get notified of new assignments.
    * *Supervisors* get notified of escalations.
    * *Citizens* get notified of completion.

### 📊 4. Manager Analytics Module
* **Data Visualization:** Text-based graphical reports.
* **Metrics:** Tracks "Average Resolution Time" and "Completion Rates" per Enterprise.

---

## 🛠 Technology Stack
* **Language:** Java 17+
* **GUI Framework:** Swing (`javax.swing`)
* **IDE:** NetBeans 12+
* **Data Generation:** `java-faker` (Synthetic data for realistic demos)
* **Design Patterns:** Singleton, Factory Method, Strategy, Observer

---

## 📦 Installation & Usage

### 1. Clone the Repository
```bash
git clone [https://github.com/YourRepo/CommunityReportingSystem.git](https://github.com/YourRepo/CommunityReportingSystem.git)
```

### 2. Libraries: The project uses `java-faker` for data generation (libraries included).
### 3. Steps:
    * Open the project in NetBeans.
    * Navigate to `src/main/Main.java`.
    * Right-click `Main.java` and select **Run File**.

---

## 🔑 Login Credentials (Quick Start)
The system initializes with these default accounts for testing:

### 1. Administrators
* **System Admin:** `sysadmin` / `Admin123!`
* **Network Admin:** `netadmin` / `Admin123!`

### 2. Supervisors (Dispatchers)
* **Public Works:** `supervisor.publicworks` / `Supervisor123!`
* **Utilities:** `supervisor.utilities` / `Supervisor123!`
* **Public Safety:** `supervisor.publicsafety` / `Supervisor123!`
* **Emergency:** `emergency.coordinator` / `Emergency123!`

### 3. Manager (Analytics)
* **Utilities Manager:** `manager.bostonutilities` / `Manager123!`

### 4. Citizens & Workers
* **Citizen:** Check the **console logs** upon startup for specific generated usernames (e.g., `olene.grimes`). Default password is `Password123!`
* **Workers:** Check the **console logs** upon startup for specific generated usernames (e.g., `olene.grimes`). Default password is `Password123!`.

---

## 🧪 Demo Script: The "Golden Path"
To see the **Cross-Enterprise Escalation** (Major Feature), follow these steps:

1.  **Login as Supervisor** (`supervisor.publicworks` / `Supervisor123!`).
    * Assign a "Pothole" request to a worker (e.g., `olene.grimes`). Logout.
2.  **Login as Worker** (Username from step 1 / `Password123!`).
    * Go to **Inbox** to see the assignment.
    * Open the request. Click **"Escalate / Report Related"**.
    * Select **"Water Leak"** (This routes to a different Enterprise).
    * Logout.
3.  **Login as Utilities Supervisor** (`supervisor.utilities` / `Supervisor123!`).
    * Verify the new "Water Leak" request appears in your queue (sent by the Road Worker).
    * Assign it to a Plumber.
4.  **Login as Manager** (`manager.bostonutilities` / `Manager123!`).
    * Click **Generate Report** to see system analytics.

---

## 📊 25% Extra Feature (Group of 4)
We implemented a complete **Analytics & Reporting Module** (`AnalyticsJPanel`) and **Complex Cross-Enterprise Routing** logic (`WorkRequestRouter`), satisfying the requirement for larger teams.

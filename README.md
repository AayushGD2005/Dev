# 💊 Medicine Reminder System

## 📌 Overview

A full-stack web application that helps users manage and receive reminders for medications.

## 🚀 Features

* Add and delete medicines
* Mark medicines as taken
* Time-based reminders using Spring Scheduler
* Browser notifications
* Separate pages for adding and viewing reminders

## 🛠 Tech Stack

* Backend: Spring Boot (Java)
* Frontend: HTML, CSS, JavaScript
* Database: MySQL

## ⚙️ How it Works

* Medicines are stored in MySQL database
* A scheduler runs every minute
* It compares system time with stored medicine time
* When matched, a notification is triggered

## ▶️ Run Locally

1. Clone repo
2. Configure MySQL in `application.properties`
3. Run Spring Boot app
4. Open http://localhost:8080

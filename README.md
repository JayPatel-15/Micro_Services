# 🏨 Hotel Rating Microservices System

A scalable, modular hotel rating system built using **Java**, **Spring Boot**, and **Spring Cloud**. This project demonstrates microservices architecture by decoupling responsibilities across independently deployable services, leveraging service discovery, centralized configuration, and an API gateway for streamlined management.

## 🧰 Tech Stack

- **Java**
- **Spring Boot**
- **Spring Cloud (Gateway, Eureka, Config Server)**
- **Maven**
- **RESTful APIs**

## 📦 Microservices Overview

| Service               | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| **API Gateway**       | Central entry point for all requests, routing to respective services.       |
| **Config Server**     | Provides centralized configuration for all services.                        |
| **Eureka Server**     | Service registry for dynamic discovery and load balancing.                  |
| **User Service**      | Manages user data and operations.                                           |
| **Hotel Service**     | Handles hotel-related information.                                          |
| **Rating Service**    | Stores and manages hotel ratings.                                           |

## ✨ Features

- ✅ Microservices-based architecture
- ✅ Centralized configuration management
- ✅ Service discovery using Eureka
- ✅ API Gateway with route management and filtering
- ✅ Scalable and fault-tolerant design
- ✅ Inter-service communication via REST

# 🌱 Spring Course

> **Задание:** В местной библиотеке хотят перейти на цифровой учет книг. Вам
необходимо реализовать веб-приложение для них. Библиотекари
должны иметь возможность регистрировать читателей, выдавать им
книги и освобождать книги (после того, как читатель возвращает
книгу обратно в библиотеку).

---

## 📂 Project 1

### 🛠 Технологии и инструменты

![Spring](https://img.shields.io/badge/Spring-6.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-42-blue)
![JDBC](https://img.shields.io/badge/JDBC-Template-yellow)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-orange)
![REST](https://img.shields.io/badge/REST-API-brightgreen)
![Validation](https://img.shields.io/badge/Validation-@Valid-red)
![Lombok](https://img.shields.io/badge/Lombok-red)

### 📝 Описание проекта

- Проект сконфигурирован на Spring 6 без использования Spring Boot.
- Подключена СУБД PostgreSQL и созданы две таблицы:
    - **Person** (Читатели)
    - **Book** (Книги) с отношением `OneToMany` между таблицами.
- Для работы с базой данных используется `jdbcTemplate`.
- Для отображения шаблонов используется **Thymeleaf**.
- Реализован REST API с поддержкой методов:
    - `GET`
    - `POST`
    - `PATCH`
    - `DELETE`
- Используется валидация с помощью аннотации `@Valid` и кастомного `PersonValidator`.

---

## 📂 Project 2

### 🛠 Технологии и инструменты

![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green)
![Hibernate](https://img.shields.io/badge/Hibernate-5.x-blue)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-3.x-yellow)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-orange)
![REST](https://img.shields.io/badge/REST-API-brightgreen)

### 🚀 Основные изменения
- **Миграция с JDBCTemplate** → Hibernate + Spring Data JPA
- **Архитектура**: Controller-Service-Repository
- **Конфигурация**: Переход на Spring Boot 3
- **Дополнительные фичи**:
    - Пагинация и сортировка книг
    - Поиск по начальным буквам названия
    - Автоматическая проверка просрочки возврата (на основе `LocalDateTime`)
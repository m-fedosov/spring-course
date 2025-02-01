# 🌱 Spring Course

> **Задание:** В местной библиотеке хотят перейти на цифровой учет книг. Вам
необходимо реализовать веб-приложение для них. Библиотекари
должны иметь возможность регистрировать читателей, выдавать им
книги и освобождать книги (после того, как читатель возвращает
книгу обратно в библиотеку).

---

## 📂 Project 1

[Подробное задание](https://swiftbook.org/system/uploads/lecture_material/material/866/Project1_TZ.pdf)

### 🛠 Технологии и инструменты

![REST](https://img.shields.io/badge/REST-API-brightgreen)
![Spring](https://img.shields.io/badge/Spring%20framework-6DB33F?logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?logo=Thymeleaf&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Template-yellow)
![Validation](https://img.shields.io/badge/Validation-@Valid-red)
![Lombok](https://img.shields.io/badge/Lombok-red)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?logo=Apache%20Maven&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?logo=apache-tomcat&logoColor=black)

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

[Подробное задание](https://swiftbook.org/system/uploads/lecture_material/material/872/Project2_TZ.pdf)

### 🛠 Технологии и инструменты

![REST](https://img.shields.io/badge/REST-API-brightgreen)
![Spring](https://img.shields.io/badge/Spring%20framework-6DB33F?logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?logo=Thymeleaf&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=Hibernate&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-3.x-yellow)
![Validation](https://img.shields.io/badge/Validation-@Valid-red)
![Lombok](https://img.shields.io/badge/Lombok-red)

### 🚀 Основные изменения
- **Миграция с JDBCTemplate** → Hibernate + Spring Data JPA
- **Архитектура**: Controller-Service-Repository
- **Конфигурация**: Переход на Spring Boot 3
- **Дополнительные фичи**:
    - Пагинация и сортировка книг
    - Поиск по начальным буквам названия
    - Автоматическая проверка просрочки возврата (на основе `LocalDateTime`)
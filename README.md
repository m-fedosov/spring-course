# 🌱 Spring Course

Приветствую тебя, странник! В этом репозитории собраны результаты обучения на курсе [Spring - Полный курс. Boot, Hibernate, Security, REST](https://swiftbook.org/courses/438/)

<img src="images/image-1.png" style="width: 100%; object-fit: cover;"/>
Не оставляй этот репозиторий без звёздочки, если он был тебе полезен 🌟

<img align="right" src="https://visitor-badge.laobi.icu/badge?page_id=spring.course">

## [📂 Project 1](https://github.com/m-fedosov/spring-course/tree/project1)

> **Задание:** В местной библиотеке хотят перейти на цифровой учет книг. Вам
необходимо реализовать веб-приложение для них. Библиотекари
должны иметь возможность регистрировать читателей, выдавать им
книги и освобождать книги (после того, как читатель возвращает
книгу обратно в библиотеку).
> 
> [Подробное задание](https://swiftbook.org/system/uploads/lecture_material/material/866/Project1_TZ.pdf)

### 🛠 Технологии и инструменты

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

## [📂 Project 2](https://github.com/m-fedosov/spring-course/tree/project2)

> **Задание:** Переписать Project1 с использованием Hibernate и Spring Data JPA. Добавить пагинацию и сортировку на эндпоинте /books. Добавить поиск /books/search. Отображать на странице /people/id какие книги просрочены человеком.
> 
> [Подробное задание](https://swiftbook.org/system/uploads/lecture_material/material/872/Project2_TZ.pdf)

### 🛠 Технологии и инструменты

![Spring](https://img.shields.io/badge/Spring%20framework-6DB33F?logo=spring&logoColor=white)
![SpringSecurity](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-%236DB33F?logo=Spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?logo=Thymeleaf&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=Hibernate&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-3.x-yellow)
![Validation](https://img.shields.io/badge/Validation-@Valid-red)
![Lombok](https://img.shields.io/badge/Lombok-red)

### 🚀 Основные изменения
- **Spring Security**: аутентификация formLogin, авторизация вызова методов @PreAuthorize
- **Миграция с JDBCTemplate** → Hibernate + Spring Data JPA
- **Архитектура**: Controller-Service-Repository
- **Конфигурация**: Переход на Spring Boot 3
- **Дополнительные фичи**:
    - Пагинация и сортировка книг
    - Поиск по начальным буквам названия
    - Автоматическая проверка просрочки возврата (на основе `LocalDateTime`)

---

## [📂 Project 3](https://github.com/m-fedosov/spring-course/tree/project3)

> **Задание:** Создание REST API приложения с помощью Spring REST. Создание Java клиента, который бы отправлял данные на
REST API приложение - с помощью класса RestClient.
>
> [Подробное задание](https://swiftbook.org/system/uploads/lecture_material/material/874/Project3_TZ.pdf)

### 🛠 Технологии и инструменты

![SpringBoot](https://img.shields.io/badge/Spring_Boot-%236DB33F?logo=Spring&logoColor=white)
![SpringREST](https://img.shields.io/badge/Spring_REST-%236DB33F?logo=Spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![JSON](https://img.shields.io/badge/JSON-yellow)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-3.x-yellow)
![Validation](https://img.shields.io/badge/Validation-@Valid-red)
![Lombok](https://img.shields.io/badge/Lombok-red)

### 🏛️ Архитектура приложения:
Проект разделён на две логические части.
- **Серверная часть (REST API)**
  - Реализует набор эндпоинтов @RestController для управления ресурсами (например, создание, получение сущностей через DTO).
  - Для обработки HTTP запросов используются аннотации Spring (@GetMapping, @PostMapping), что обеспечивает чистую и понятную организацию кода.
  - Обработка ошибок организована через глобальный обработчик исключений, позволяющие возвращать корректные HTTP статусы и сообщения.
- **Клиентская часть (Java клиент)**
  - Консольное приложение, демонстрирующее взаимодействие с REST API.
  - Использует класс RestClient для отправки запросов к серверу, получения ответов и их обработки.
  - Клиент иллюстрирует выполнение CRUD операций, что позволяет проверить работоспособность API.
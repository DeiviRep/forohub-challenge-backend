# 📘 ForoHub API – Challenge ONE + Alura

API REST para la gestión de tópicos en un foro, desarrollada con **Java 17/24**, **Spring Boot 4**, **Spring Security**, **JPA/Hibernate**, **MySQL**, **Flyway**, **JWT** y **Swagger/OpenAPI**.

Este proyecto forma parte del desafío **ForoHub** del programa **Oracle Next Education (ONE) + Alura**, cuyo objetivo es construir una API completa con CRUD, autenticación y documentación.

***

## 🚀 Funcionalidades principales

### 🔐 Autenticación y Seguridad

*   Inicio de sesión con **JWT** (`/login`)
*   Protección de endpoints
*   Filtro JWT personalizado
*   Usuarios almacenados en la tabla `usuario`
*   Contraseñas cifradas con **BCrypt**

### 💬 Gestión de Tópicos (CRUD completo)

*   **Crear** tópico
*   **Listar** tópicos (paginación + filtros opcionales)
*   **Filtrar** por curso, año o ambos
*   **Consultar detalle**
*   **Editar**
*   **Eliminar** (físico o lógico según implementación)
*   Validación **anti-duplicados** (mismo título + mensaje)

### 🧾 Migraciones automatizadas

*   Estructura de base de datos gestionada con **Flyway**
*   Migraciones de:
    *   Tablas del foro (`curso`, `usuario`, `topico`, `respuesta`)
    *   Semillas de datos
    *   Alta de credenciales (`login`, `clave`) con índice único

### 📑 Documentación de API (Swagger / OpenAPI)

*   Disponible en `/swagger-ui/index.html`
*   Generada automáticamente con **springdoc-openapi v3.x** (compatible con **Spring Boot 4**) [\[springdoc.org\]](https://springdoc.org/v4/), [\[github.com\]](https://github.com/springdoc/springdoc-openapi/releases)

***

## 🛠️ Tecnologías utilizadas

| Tecnología                      | Descripción                                                                                                            |
| ------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| **Java 17/24**                  | Lenguaje principal                                                                                                     |
| **Spring Boot 4.0.3**           | Framework principal para la API                                                                                        |
| **Spring Web**                  | Controladores REST                                                                                                     |
| **Spring Security**             | Seguridad + JWT                                                                                                        |
| **Spring Data JPA (Hibernate)** | Persistencia                                                                                                           |
| **Flyway**                      | Migraciones                                                                                                            |
| **MySQL 8**                     | Base de datos                                                                                                          |
| **Lombok**                      | Reducción de código boilerplate                                                                                        |
| **springdoc-openapi 3.x**       | Documentación de API (compatible con Boot 4) [\[springdoc.org\]](https://springdoc.org/v4/) |

***

## 🗄️ Estructura del proyecto

    src/main/java/com.alura.foro_hub
     ├── controller
     ├── domain
     │    ├── topico
     │    ├── respuesta
     │    ├── usuario
     │    └── curso
     ├── infra
     │    └── security (JWT, filtros, config)
     ├── service
     └── repository

***

## 🧬 Base de datos (modelo)

*   **usuario**
    *   id, nombre, login (único), clave (BCrypt)

*   **curso**
    *   id, nombre, categoría

*   **topico**
    *   id, título, mensaje, fecha\_creación, status, autor\_id, curso\_id

*   **respuesta**
    *   id, mensaje, fecha, autor\_id, topico\_id

***

## ▶️ Ejecución del proyecto

### 1️⃣ Configura variables de entorno

```bash
SPRING_DATASOURCE_URL=jdbc:mysql://<HOST>:<PORT>/<DB>?sslMode=REQUIRED
SPRING_DATASOURCE_USERNAME=<USER>
SPRING_DATASOURCE_PASSWORD=<PASSWORD>
API_SECURITY_TOKEN_SECRET=<SECRET_DE_32+_CARACTERES>
```

### 2️⃣ Ejecutar con Maven Wrapper (sin instalar Maven)

```bash
.\mvnw.cmd spring-boot:run
```

***

## 🧪 Endpoints principales

### 🔐 Autenticación

| Método | Endpoint | Descripción        |
| ------ | -------- | ------------------ |
| POST   | `/login` | Devuelve token JWT |

### 💬 Tópicos

| Método | Endpoint        | Descripción                        |
| ------ | --------------- | ---------------------------------- |
| POST   | `/topicos`      | Crea un tópico                     |
| GET    | `/topicos`      | Lista tópicos (filtros opcionales) |
| GET    | `/topicos/{id}` | Detalle                            |
| PUT    | `/topicos/{id}` | Actualiza                          |
| DELETE | `/topicos/{id}` | Elimina                            |

***

## 📚 Documentación de API (Swagger)

Disponible automáticamente en:

👉 **`http://localhost:8080/swagger-ui/index.html`**  
👉 **`http://localhost:8080/v3/api-docs`**

Soportado por **springdoc-openapi 3.x**, diseñado para **Spring Boot 4**.    [\[springdoc.org\]](https://springdoc.org/v4/)

***

## 👨‍💻 Autor

**Patzi Vargas David Bernardo**  
Desarrollador — Challenge ForoHub (ONE + Alura)

***

## 📝 Licencia

Este proyecto se publica con fines educativos como parte del programa **Oracle Next Education (ONE)**.
***

# 📘 README — ForoHub (Spring Boot + MySQL)

ForoHub es una API REST construida con **Java 17**, **Spring Boot**, **Spring Data JPA**, **Flyway**, **MySQL** y **Spring Security (por defecto)**.  
Permite gestionar tópicos similares a los de un foro (como Alura o StackOverflow).

***

## 🚀 Funcionalidades

### ✔ Crear tópico (POST /topicos)

*   Valida campos obligatorios.
*   Verifica duplicados (mismo título + mensaje).
*   Persiste autor, curso y fecha automática.

### ✔ Listar tópicos (GET /topicos)

*   Paginado y ordenado.
*   Filtros opcionales:
    *   por nombre de curso
    *   por año
    *   curso + año

### ✔ Detalle de tópico (GET /topicos/{id})

*   Devuelve título, mensaje, fecha, estado, autor y curso.

### ✔ Actualizar tópico (PUT /topicos/{id})

*   Cambia título, mensaje, estado.
*   Valida duplicados.
*   Verifica existencia.

### ✔ Eliminar tópico (DELETE /topicos/{id})

*   Manejo correcto de integridad referencial.
*   Eliminación funcional del recurso.

***

## 🗄️ Base de datos

La aplicación usa MySQL 8 y migraciones gestionadas por **Flyway**.

Tablas principales:

*   `usuario`
*   `curso`
*   `topico`
*   `respuesta`

Migraciones en:

    src/main/resources/db/migration

***

## ▶️ Ejecución

Compilar y ejecutar:

```bash
mvn clean package
java -jar target/forohub-challenge-backend.jar
```

Swagger UI (si lo habilitas):

    http://localhost:8080/swagger-ui/index.html

***

## 🧪 Pruebas con Insomnia/Postman

Endpoints principales:

*   `POST /topicos`
*   `GET /topicos`
*   `GET /topicos/{id}`
*   `PUT /topicos/{id}`
*   `DELETE /topicos/{id}`

***

## 🔐 Seguridad

La app levanta con **Spring Security por defecto**, usando contraseña generada automáticamente para usuario `user`.

***

## 💾 Tecnologías usadas

*   Java 17
*   Spring Boot 3 / 4
*   Spring Web
*   Spring Data JPA
*   MySQL Driver
*   Flyway
*   Validation
*   Spring Security

***

## 📦 Estructura

    src/main/java/com.alura.foro_hub
     ├── controller
     ├── domain
     ├── service
     └── repository

***

## 📝 Notas

Este proyecto forma parte del **Challenge ForoHub** del programa **Oracle Next Education (ONE) + Alura**.

***

## ✨ Commit sugerido

Aquí tienes un commit **simple y corto** como pediste:

    docs: update README with CRUD and recent changes

***

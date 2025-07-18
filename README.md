# API REST - Foro Hub

Este proyecto es una API REST desarrollada con **Spring Boot** que simula un foro donde los usuarios pueden registrarse, autenticarse y gestionar tópicos. La API está protegida con **Spring Security** y utiliza **JWT** para autenticación. 
La base de datos utilizada es **MySQL**, y las migraciones se gestionan con **Flyway**. La documentación de la API está disponible mediante **SpringDoc OpenAPI** y las pruebas fueron realizadas con **Insomnia**.

---

## 🛠️ Funcionalidades

- Registro de usuarios (evita duplicados por nombre de usuario).
- Autenticación mediante login y generación de token JWT.
- Autorización basada en token para acceder a los endpoints protegidos.
- CRUD de tópicos:
  - Crear tópico.
  - Listar tópicos paginados.
  - Ver detalles de un tópico.
  - Actualizar y eliminar solo si pertenece al usuario autenticado.
- Validaciones para campos requeridos y no nulos.
- Encriptación de contraseñas con **BCryptPasswordEncoder**.
- Manejo de excepciones personalizado.
- Documentación interactiva con **SpringDoc**.

---

## 🧪 Pruebas

Las pruebas fueron realizadas con **Insomnia** para comprobar el comportamiento de:

- Registro y login.
- Generación y validación del token.
- Acceso a endpoints con y sin autenticación.
- Comprobación de permisos por usuario en tópicos.

---

## 🔐 Seguridad

- Se utiliza **Spring Security** para proteger todos los endpoints.
- Solo las rutas de login y registro son públicas.
- Todos los demás endpoints requieren token JWT válido.
- Autorización basada en el usuario propietario del recurso (tópico).

---

## 🧩 Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT (Java Web Token)**
- **BCryptPasswordEncoder**
- **Spring Data JPA**
- **MySQL**
- **Flyway**
- **SpringDoc OpenAPI**
- **Insomnia** (para pruebas)

---

## 🗃️ Base de Datos

- Motor: **MySQL**
- Migraciones automáticas con **Flyway**
- Tablas creadas al inicio con scripts de migración

🧑‍💻 Autor

- Albeiro Manuel Baena Tovar de Alura Latam

# 📚 FeedbackHub

**FeedbackHub** es una API RESTful construida con **Spring Boot** orientada a la gestión de encuestas y retroalimentación académica, como parte de un proyecto personal de portafolio. Apunta a mejorar el proceso de recepción y análisis de feedback en contextos educativos (como universidades, materias o trabajos de tesis).

---

## 🚀 Características actuales

- Registro e inicio de sesión de usuarios con autenticación JWT
- Gestión básica de usuarios y roles (por ahora: `STUDENT`)
- Arquitectura limpia basada en capas (Controller, Service, Repository, Model)
- Seguridad integrada con Spring Security
- Manejo de base de datos con PostgreSQL y JPA
- Buenas prácticas: TDD-ready, control de versiones, separación de responsabilidades

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.x
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- JWT (`jjwt`)
- Lombok
- Mockito (pendiente de integración en pruebas)
- Postman (para pruebas manuales)

---

## 📂 Estructura del proyecto


---

## 🔐 Autenticación

Se utiliza JWT para la autenticación. Los usuarios deben registrarse e iniciar sesión para obtener un token, el cual se debe enviar en el header `Authorization` en los endpoints protegidos.


---

## 📫 Endpoints actuales

| Método | Endpoint             | Descripción                | Protección |
|--------|----------------------|----------------------------|------------|
| POST   | `/api/auth/register` | Registro de usuario        | ❌ Pública |
| POST   | `/api/auth/login`    | Login y generación de token| ❌ Pública |

*Endpoints adicionales en desarrollo.*

---

## 📌 Por hacer (roadmap)

- [ ] Gestión de encuestas y formularios de feedback
- [ ] Respuesta y almacenamiento de feedback por usuarios
- [ ] Roles avanzados (ADMIN, TEACHER, etc.)
- [ ] Documentación Swagger
- [ ] Pruebas unitarias y de integración
- [ ] Deploy en Railway o Render

---

## 👨‍💻 Sobre el autor

Adrián Knüppelholz – Tesista de Ingeniería en Informática y Backend Java Developer.  
Este proyecto forma parte de mi portfolio personal.  
[LinkedIn](https://www.linkedin.com/) • [GitHub](https://github.com/)

---

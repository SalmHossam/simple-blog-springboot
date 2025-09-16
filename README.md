# simple-blog-springboot
Got it 👍 Let’s create a **README.md** for your simple blog backend (Spring Boot + REST API).

Here’s a clean version you can use in your project:

---

# 📝 Simple Blog Backend

A simple **Spring Boot REST API** for managing blog posts and comments.
Supports creating, reading, searching, and deleting posts & comments.

---

## 🚀 Features

* Manage **Blog Posts**

  * Create a post
  * Get all posts
  * Get a single post by ID
  * Delete a post
  * Search posts by keyword
* Manage **Comments**

  * Add a comment to a post
  * Get all comments for a post
  * Delete a comment

---

## ⚙️ Tech Stack

* **Java 17+**
* **Spring Boot 3+**
* **Spring Web**
* **Spring Data JPA**
* **H2 Database** (in-memory) or MySQL/Postgres
* **Jackson** (for JSON serialization/deserialization)

---

## 📂 Project Structure

```
src/main/java/com/example/blog
│── controller      # REST controllers
│── service         # Business logic
│── repository      # Spring Data JPA interfaces
│── model           # Entities (Post, Comment)
│── dto             # DTOs / Response classes
```

---

## ▶️ Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/your-username/simple-blog-backend.git
cd simple-blog-backend
```

### 2. Build and run

```bash
./mvnw spring-boot:run
```

or

```bash
mvn clean install
java -jar target/blog-backend-0.0.1-SNAPSHOT.jar
```

### 3. Access API

* Base URL: `http://localhost:8080/api`

---

## 📌 API Endpoints

### 🔹 Posts

| Method | Endpoint                     | Description             | Request Body Example                                                       |
| ------ | ---------------------------- | ----------------------- | -------------------------------------------------------------------------- |
| GET    | `/posts`                     | Get all posts           | —                                                                          |
| GET    | `/posts/{id}`                | Get single post by ID   | —                                                                          |
| POST   | `/posts`                     | Create a new post       | `json { "title": "My Post", "content": "Hello World", "author": "Salma" }` |
| DELETE | `/posts/{id}`                | Delete a post           | —                                                                          |
| GET    | `/posts/search?keyword=java` | Search posts by keyword | —                                                                          |

---

### 🔹 Comments

| Method | Endpoint                        | Description                 | Request Body Example                                  |
| ------ | ------------------------------- | --------------------------- | ----------------------------------------------------- |
| GET    | `/posts/{postId}/comments`      | Get all comments for a post | —                                                     |
| POST   | `/posts/{postId}/comments`      | Add a comment to a post     | `json { "author": "User1", "content": "Nice post!" }` |
| DELETE | `/posts/{postId}/comments/{id}` | Delete a comment            | —                                                     |

---

## 📊 Example JSON

### Post Response

```json
{
  "id": 1,
  "title": "First Blog Post",
  "content": "This is my first post!",
  "author": "Salma",
  "comments": [
    {
      "id": 1,
      "author": "User1",
      "content": "Great post!"
    }
  ]
}
```

---

## ✅ Status Codes

* `200 OK` → Successful GET/DELETE
* `201 Created` → Successful POST (can be changed to 200 if needed)
* `404 Not Found` → Resource not found
* `400 Bad Request` → Validation errors

---

## 📦 Future Improvements

* Add authentication (Spring Security + JWT)
* Add pagination for posts & comments
* Improve error handling with custom exceptions
* Swagger/OpenAPI documentation


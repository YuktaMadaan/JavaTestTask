# Item REST API (E-commerce Example)

## How to Run

1. Install Java 17
2. Install Maven
3. Run:

   mvn spring-boot:run

Application runs on:
http://localhost:8080

---

## API Endpoints

### 1. Add Item
POST /api/items

Example JSON:
{
"name": "Laptop",
"description": "Gaming Laptop",
"price": 75000
}

---

### 2. Get Item by ID
GET /api/items/{id}

Example:
GET /api/items/1

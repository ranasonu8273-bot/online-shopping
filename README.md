# Online Shopping System (Java)

A beginner-friendly console-based Online Shopping System built with Java. It demonstrates product listing, searching, shopping cart operations, quantity validation, and checkout totals.

## Features
- View available products
- Search products by name
- Add products to the cart
- View cart and subtotal
- Remove items from the cart
- Checkout with a simple order summary
- Object-oriented design using classes

## Requirements
- JDK 17 or later
- Maven (optional; the project includes a Maven configuration)

## Run with Java
From the repository root:

```bash
javac -d out src/main/java/com/onlineshopping/*.java
java -cp out com.onlineshopping.Main
```

Or use Maven:

```bash
mvn compile
mvn exec:java
```

## Project Structure
```
online-shopping/
├── README.md
├── pom.xml
├── database/schema.sql
└── src/main/java/com/onlineshopping/
    ├── Product.java
    ├── CartItem.java
    ├── ShoppingCart.java
    └── Main.java
```

## Database
`database/schema.sql` contains an optional MySQL schema for products, customers, orders, and order items. The console demo currently uses sample in-memory products and does not connect to MySQL.

## Learning Outcomes
Java classes and objects, encapsulation, ArrayList, loops, input validation, searching, and basic shopping-cart calculations.

## Academic Note
Review, run, and customize this project before submitting it. Add your own improvements and make sure you can explain how each class works.

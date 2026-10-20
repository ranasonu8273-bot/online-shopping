package com.onlineshopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Product> products = new ArrayList<>();
    private static final ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        loadProducts();
        System.out.println("=================================");
        System.out.println("      ONLINE SHOPPING SYSTEM");
        System.out.println("=================================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. View products");
            System.out.println("2. Search product");
            System.out.println("3. Add to cart");
            System.out.println("4. View cart");
            System.out.println("5. Remove from cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> showProducts();
                case 2 -> searchProduct();
                case 3 -> addToCart();
                case 4 -> showCart();
                case 5 -> removeFromCart();
                case 6 -> checkout();
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Thank you for visiting our store!");
        scanner.close();
    }

    private static void loadProducts() {
        products.add(new Product(1, "Wireless Mouse", 599.00, 10));
        products.add(new Product(2, "Keyboard", 899.00, 8));
        products.add(new Product(3, "Headphones", 1299.00, 6));
        products.add(new Product(4, "USB Cable", 199.00, 20));
        products.add(new Product(5, "Laptop Stand", 749.00, 5));
    }

    private static void showProducts() {
        System.out.println("\nID   Product                Price      Availability");
        for (Product product : products) System.out.println(product);
    }

    private static Product findProduct(int id) {
        for (Product product : products) if (product.getId() == id) return product;
        return null;
    }

    private static void searchProduct() {
        System.out.print("Enter product name: ");
        String query = scanner.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(query)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) System.out.println("No matching product found.");
    }

    private static void addToCart() {
        showProducts();
        int id = readInt("Enter product ID: ");
        Product product = findProduct(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        int quantity = readInt("Enter quantity: ");
        if (cart.add(product, quantity)) System.out.println("Product added to cart.");
        else System.out.println("Invalid quantity or insufficient stock.");
    }

    private static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\nYour Cart");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%s x %d = Rs. %.2f%n",
                    item.getProduct().getName(), item.getQuantity(), item.getTotal());
        }
        System.out.printf("Subtotal: Rs. %.2f%n", cart.getSubtotal());
    }

    private static void removeFromCart() {
        showCart();
        if (cart.isEmpty()) return;
        int id = readInt("Enter product ID to remove: ");
        if (cart.remove(id)) System.out.println("Item removed.");
        else System.out.println("That product is not in your cart.");
    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add items before checkout.");
            return;
        }
        showCart();
        System.out.printf("Order total: Rs. %.2f%n", cart.getSubtotal());
        System.out.println("Demo checkout complete. No real payment was processed.");
        cart.clear();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}

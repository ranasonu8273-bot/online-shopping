package com.onlineshopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public boolean add(Product product, int quantity) {
        if (quantity < 1 || quantity > product.getStock()) return false;
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > product.getStock()) return false;
                item.setQuantity(newQuantity);
                return true;
            }
        }
        items.add(new CartItem(product, quantity));
        return true;
    }

    public boolean remove(int productId) {
        return items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) total += item.getTotal();
        return total;
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }
}

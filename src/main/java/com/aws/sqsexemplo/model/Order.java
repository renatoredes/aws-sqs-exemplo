package com.aws.sqsexemplo.model;
import java.util.Random;

public record Order(String orderId, String customerName, double amount) {
    public Order {
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be greater than zero");
        }
    }

    public static Order createWithRandomId(String customerName, double amount) {
        // Gera um número aleatório com no máximo 5 dígitos
        int maxOrderId = 99999;
        Random random = new Random();
        int randomOrderId = random.nextInt(maxOrderId) + 1;
        String orderId = String.format("%05d", randomOrderId); // Garante que o orderId tenha no máximo 5 dígitos
        return new Order(orderId, customerName, amount);
    }
}

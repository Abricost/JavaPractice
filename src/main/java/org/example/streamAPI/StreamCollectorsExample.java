package org.example.streamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        System.out.println(orders + "\n");

        Map<String, Double> totalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,
                        Collectors.summingDouble(Order::getCost)));

        List<Map.Entry<String, Double>> sortedProductsByCost = totalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();

        List<Map.Entry<String, Double>> top3Products = sortedProductsByCost.stream()
                .limit(3)
                .toList();

        System.out.println("Топ 3 самых дорогих продуктов:");
        top3Products.forEach(product -> System.out.println("Продукт: " + product.getKey() + ", Общая стоимость: " + product.getValue()));
    }
}

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "'" + product + '\'' +
                " - "  + cost;
    }
}

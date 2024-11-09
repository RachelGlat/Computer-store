package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PurchaseOrder {
    Cusomer orderingCustomer;
    private ArrayList<Product>products;
    private LocalDate orderDate=LocalDate.from(LocalDateTime.now());

    public Cusomer getOrderingCustomer() {
        return orderingCustomer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderingCustomer=" + orderingCustomer +
                ", products=" + products +
                ", orderDate=" + orderDate +
                '}';
    }
}

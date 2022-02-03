package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    public Order(Long id, String status, LocalDate orderData, LocalDate deliveryData, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderData;
        this.deliveryDate = deliveryData;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderData=" + orderDate +
                ", deliveryData=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
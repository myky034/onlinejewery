package online.jewery.onlinejewery.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    private String userId; // Reference to User
    private LocalDateTime orderDate;
    private double totalAmount;
    private  OrderStatus status;
    private List<OrderItem> items;

    // Constructors, getters, setters
}

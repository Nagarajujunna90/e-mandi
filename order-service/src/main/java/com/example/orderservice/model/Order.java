package com.example.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    private Integer id;
    private String oderBy;
    private Date orderDate;

    @ManyToMany(mappedBy = "orders")
    private List<User> users;

}

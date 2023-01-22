package com.example.orderservice.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    private Integer id;
    private String productDescription;
    private String name;

    private Date manufacturingDate;

    private String productCompany;

    

   /* @ManyToMany(mappedBy = "orders")
    private List<User> users;*/

}

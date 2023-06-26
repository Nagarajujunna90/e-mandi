package com.example.orderservice.repo;

import com.example.orderservice.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image,Integer> {
}

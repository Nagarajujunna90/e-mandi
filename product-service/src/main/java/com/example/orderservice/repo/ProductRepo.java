package com.example.orderservice.repo;

import com.example.orderservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update product p set p.image_Id=:imageId where p.id=:productId")
    Integer updateImageById(@PathParam("productId") String productId, @PathParam("imageId") Integer imageId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update product p set p.image_Id=null where p.image_Id=:imgId")
    void updateImageIdAsNull(Integer imgId);
}

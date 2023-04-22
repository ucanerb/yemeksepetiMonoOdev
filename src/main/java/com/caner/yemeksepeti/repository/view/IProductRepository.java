package com.caner.yemeksepeti.repository.view;

import com.caner.yemeksepeti.repository.entity.Order;
import com.caner.yemeksepeti.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

//public List<Product> findAllProductByRestaurantId(Long restaurantId);

}

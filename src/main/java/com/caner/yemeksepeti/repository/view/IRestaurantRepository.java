package com.caner.yemeksepeti.repository.view;

import com.caner.yemeksepeti.repository.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Long> {
   // Optional<Restaurant> findByRestaurantNameIgnoreCase(String name);

}

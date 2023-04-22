package com.caner.yemeksepeti.repository.view;

import com.caner.yemeksepeti.repository.entity.Customer;
import com.caner.yemeksepeti.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOptionalByProductId(Long id);

    //@Query(nativeQuery = true, "")
    public List<Order> findAllOrderByCustomerId(Long customerId);
    public List<Order> findAllOrderByRestaurantId(Long restaurantId);
}

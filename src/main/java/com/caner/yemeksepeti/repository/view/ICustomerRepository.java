package com.caner.yemeksepeti.repository.view;

import com.caner.yemeksepeti.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

Optional<Customer> findOptionalByEmailAndPassword(String email, String password);

}

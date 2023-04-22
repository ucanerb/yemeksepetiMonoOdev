package com.caner.yemeksepeti.repository.entity;

import com.caner.yemeksepeti.repository.entity.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblcustomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private int phoneNumber;
    private String password;
    private String cardDetails;
    private int balance;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus estatus = EStatus.PENDING;
    private String activationCode;
}

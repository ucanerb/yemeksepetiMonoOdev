package com.caner.yemeksepeti.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder//SUPERIN SUPERI BIR CLASS  OLDUĞU İÇİN
@MappedSuperclass// ALT SINIFINA MAPLEMEK İÇİN
public class Base {
    private Long orderDate;

}

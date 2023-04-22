package com.caner.yemeksepeti.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductRequestDto {

    @NotBlank(message="Ürün ismi boş kalamaz.")
    private String name;
    private String category;
    @NotNull(message="Ürün fiyatı boş kalamaz.")
    private Integer cost;

}

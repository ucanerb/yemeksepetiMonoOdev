package com.caner.yemeksepeti.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveRestaurantRequestDto {
    private String name;
    @NotBlank(message="Adres bilgileriniz boş kalamaz.")
    private String address;
    private List<Long> productId;
}

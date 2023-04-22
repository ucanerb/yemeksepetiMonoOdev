package com.caner.yemeksepeti.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrderResponseDto {
    Long customerId;
    Long restaurantId;
    List<Long> productId;
}

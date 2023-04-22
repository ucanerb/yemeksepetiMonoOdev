package com.caner.yemeksepeti.mapper;

import com.caner.yemeksepeti.dto.request.SaveOrderRequestDto;
import com.caner.yemeksepeti.dto.response.SaveOrderResponseDto;
import com.caner.yemeksepeti.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IOrderMapper {
    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

    Order toOrder (final SaveOrderRequestDto dto);

    SaveOrderResponseDto toResponse(final Order order);
}

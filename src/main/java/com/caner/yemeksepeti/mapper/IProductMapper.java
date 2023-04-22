package com.caner.yemeksepeti.mapper;

import com.caner.yemeksepeti.dto.request.SaveProductRequestDto;
import com.caner.yemeksepeti.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")

public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product toProduct(final SaveProductRequestDto dto);
}

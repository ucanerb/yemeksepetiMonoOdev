package com.caner.yemeksepeti.mapper;


import com.caner.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.caner.yemeksepeti.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);
    Restaurant toRestaurant (final SaveRestaurantRequestDto dto);
}

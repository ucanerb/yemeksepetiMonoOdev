package com.caner.yemeksepeti.mapper;

import com.caner.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.caner.yemeksepeti.dto.response.RegisterResponseDto;
import com.caner.yemeksepeti.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(final CustomerRegisterRequestDto dto);

    RegisterResponseDto toResponse(final Customer customer);

}

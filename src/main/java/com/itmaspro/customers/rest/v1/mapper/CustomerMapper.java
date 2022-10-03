package com.itmaspro.customers.rest.v1.mapper;

import java.util.List;

import com.itmaspro.customers.domain.model.CustomerEntity;
import com.itmaspro.general.domain.models.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper
{
    CustomerDto map( CustomerEntity entity );

    CustomerEntity map( CustomerDto dto );

    List<CustomerDto> map( List<CustomerEntity> entities);
}

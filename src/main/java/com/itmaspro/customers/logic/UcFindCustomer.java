package com.itmaspro.customers.logic;

import java.util.List;

import com.itmaspro.general.domain.models.CustomerDto;

public interface UcFindCustomer
{
    CustomerDto findCustomerById( String id);

    List<CustomerDto> findCustomers( Integer limit, Integer offset);
}

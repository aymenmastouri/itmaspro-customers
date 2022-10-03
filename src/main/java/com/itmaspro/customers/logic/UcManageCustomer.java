package com.itmaspro.customers.logic;

import com.itmaspro.general.domain.models.CustomerDto;

public interface UcManageCustomer
{
    CustomerDto createCustomer( CustomerDto customer);

    CustomerDto updateCustomer(String id, CustomerDto customer);

    void deleteCustomerById(String id);
}

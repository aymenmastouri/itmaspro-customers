package com.itmaspro.customers.logic.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.itmaspro.customers.domain.model.CustomerEntity;
import com.itmaspro.customers.domain.model.dao.CustomerDao;
import com.itmaspro.customers.logic.UcManageCustomer;
import com.itmaspro.customers.logic.exceptions.EmptyPayloadException;
import com.itmaspro.customers.logic.exceptions.IdMismatchException;
import com.itmaspro.customers.logic.exceptions.ResourceNotFoundException;
import com.itmaspro.customers.rest.v1.mapper.CustomerMapper;
import com.itmaspro.general.domain.models.CustomerDto;

@ApplicationScoped
@Transactional
public class UcManageCustomerImpl implements UcManageCustomer
{
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private CustomerDao customerDao;
    public CustomerDto createCustomer(CustomerDto customer) {
        if (customer == null) {
            throw new EmptyPayloadException(CustomerDto.class.getSimpleName());
        }
        CustomerEntity customerEntity = customerMapper.map(customer);
        customerEntity.setId(null);
        customerDao.create(customerEntity);
        return customerMapper.map(customerEntity);
    }

    @Override
    public CustomerDto updateCustomer(String id, CustomerDto customer)  {
        if (customer == null) {
            throw new EmptyPayloadException(CustomerDto.class.getSimpleName());
        }
        if (!id.equals(customer.getId())) {
            throw new IdMismatchException(id, customer.getId());
        }
        CustomerEntity customerEntity = customerDao.findOne( id );

        if (customerEntity == null) {
            throw new ResourceNotFoundException(CustomerDto.class.getSimpleName(), id);
        }
        CustomerEntity updatedCustomerEntity = customerMapper.map(customer);
        updatedCustomerEntity.setId(id);
        updatedCustomerEntity.setCreatedAt(customerEntity.getCreatedAt());
        updatedCustomerEntity = customerDao.update( updatedCustomerEntity );
        return customerMapper.map(updatedCustomerEntity);
    }

    @Override
    public void deleteCustomerById(String id) {
        CustomerEntity customerEntity = customerDao.findOne( id );
        if (customerEntity == null) {
            throw new ResourceNotFoundException(CustomerDto.class.getSimpleName(), id);
        }
        customerDao.delete(customerEntity);   }
}

package com.itmaspro.customers.logic.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import com.itmaspro.customers.domain.model.CustomerEntity;
import com.itmaspro.customers.domain.model.dao.CustomerDao;
import com.itmaspro.customers.logic.UcFindCustomer;
import com.itmaspro.customers.logic.exceptions.ResourceNotFoundException;
import com.itmaspro.customers.logic.exceptions.UnauthorizedException;
import com.itmaspro.customers.rest.v1.auth.AuthContext;
import com.itmaspro.customers.rest.v1.mapper.CustomerMapper;
import com.itmaspro.general.domain.models.CustomerDto;
@ApplicationScoped
public class UcFindCustomerImpl implements UcFindCustomer
{
    @Inject
    private CustomerMapper customerMapper;

    @Inject
    private AuthContext authContext;
    @Inject
    private CustomerDao customerDao;

    @Override
    public CustomerDto findCustomerById( String id){
        CustomerEntity customerEntity = customerDao.findOne(id);
        if (customerEntity == null) {
            throw new ResourceNotFoundException(CustomerDto.class.getSimpleName(), id);
        }
        if (authContext.getUser() != null && !authContext.getUser().getName().equals(customerEntity.getEmail())) {
            throw new UnauthorizedException();
        }
        return  customerMapper.map(customerEntity);
    }

    @Override
    public List<CustomerDto> findCustomers(Integer limit, Integer offset) {
        List<CustomerEntity> customerEntities = customerDao.findAllWithLimitAndOffset( limit,offset,CustomerEntity.CUSTOMER_ENTITY_FIND_ALL );
        return customerEntities.stream().map(customerMapper::map).collect( Collectors.toList());
    }

}

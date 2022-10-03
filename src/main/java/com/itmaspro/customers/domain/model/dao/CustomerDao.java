package com.itmaspro.customers.domain.model.dao;

import javax.enterprise.context.ApplicationScoped;
import com.itmaspro.customers.domain.model.CustomerEntity;

@ApplicationScoped
public class CustomerDao extends AbstractJpaDAO<CustomerEntity>
{
    public CustomerDao(){
        setClazz(CustomerEntity.class);
    }
}

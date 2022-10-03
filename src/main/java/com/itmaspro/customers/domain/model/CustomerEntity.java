package com.itmaspro.customers.domain.model;

import com.itmaspro.general.domain.models.ApplicationPersistenceEntity;
import com.itmaspro.general.domain.models.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery( name = CustomerEntity.CUSTOMER_ENTITY_FIND_ALL, query = "SELECT c FROM CustomerEntity c"),
        @NamedQuery( name = CustomerEntity.CUSTOMER_ENTITY_FIND_ALL_COUNT, query = "SELECT count(c) FROM CustomerEntity c")
})
public class CustomerEntity extends ApplicationPersistenceEntity implements Serializable
{

    public static final String CUSTOMER_ENTITY_FIND_ALL = "CustomerEntity.findAll";
    public static final String CUSTOMER_ENTITY_FIND_ALL_COUNT = "CustomerEntity.findAllCount";
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
}


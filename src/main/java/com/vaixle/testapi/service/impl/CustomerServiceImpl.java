package com.vaixle.testapi.service.impl;

import com.vaixle.testapi.mapper.CustomerMapper;
import com.vaixle.testapi.model.dto.CustomerBaseDto;
import com.vaixle.testapi.repository.CustomerRepository;
import com.vaixle.testapi.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    CustomerMapper customerMapper;

    @Override
    @Transactional
    public List<CustomerBaseDto> getAllCustomers() {
        return customerMapper.customersToCustomerBaseDtos(customerRepository.findAll());
    }
}

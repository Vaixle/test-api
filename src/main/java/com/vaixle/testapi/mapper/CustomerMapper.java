package com.vaixle.testapi.mapper;

import com.vaixle.testapi.model.Customer;
import com.vaixle.testapi.model.dto.CustomerDto;
import com.vaixle.testapi.model.dto.CustomerBaseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    CustomerBaseDto customerToCustomerBaseDto(Customer customer);

    List<CustomerBaseDto> customersToCustomerBaseDtos(List<Customer> customers);
}

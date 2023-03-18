package com.vaixle.testapi.service;

import com.vaixle.testapi.model.dto.CustomerBaseDto;
import com.vaixle.testapi.payload.response.OrdersResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerBaseDto> getAllCustomers();
}

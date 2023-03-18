package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.model.dto.CustomerBaseDto;
import com.vaixle.testapi.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService customerService;

    @GetMapping
//    @ApiOperation(
//            value = "Получить покупателей",
//            notes = "Получить список покупателей",
//            response = CustomerBaseDto.class)
    public List<CustomerBaseDto> getCustomers() {
        return customerService.getAllCustomers();
    }
}
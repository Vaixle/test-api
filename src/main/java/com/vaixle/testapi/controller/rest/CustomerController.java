package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.model.dto.CustomerBaseDto;
import com.vaixle.testapi.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Покупатели", description = "Операции над покупателями")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService customerService;

    @GetMapping
    @Operation(summary = "Получить покупателей",
            description = "Возвращает список покупателей с детальной информацией",
            operationId = "getCustomers")
    public List<CustomerBaseDto> getCustomers() {
        return customerService.getAllCustomers();
    }
}

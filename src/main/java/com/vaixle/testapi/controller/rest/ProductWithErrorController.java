package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.UpdateProductRequest;
import com.vaixle.testapi.payload.response.ProductResponse;
import com.vaixle.testapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/products2")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Продукты2", description = "Операции над продуктами")
public class ProductWithErrorController {

    ProductService productService;

    @PatchMapping("/{id}")
    @Operation(summary = "Обновить продукт по ID",
            description = "Частичное обновление продукта по ID",
            operationId = "patchProductWithError",
            parameters = {
                    @Parameter(name = "id", description = "ID продукта для обновления", required = true, example = "123")
            })
    public ProductResponse patchProduct(
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id,@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.patchProduct(Long.parseLong(id), updateProductRequest);
    }
}

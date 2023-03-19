package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.CreateProductRequest;
import com.vaixle.testapi.payload.request.UpdateProductRequest;
import com.vaixle.testapi.payload.response.ProductResponse;
import com.vaixle.testapi.payload.response.ProductsResponse;
import com.vaixle.testapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Продукты", description = "Операции над продуктами")
public class ProductController {

    ProductService productService;

    @GetMapping
    @Operation(summary = "Получить продукты",
            description = "Возвращает список продуктов с детальной информацией",
            operationId = "getAllProducts")
    public ProductsResponse getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить продукт по ID",
            description = "Возвращает продукт по ID с детальной информацией",
            operationId = "getProductById",
            parameters = {
                    @Parameter(name = "id", description = "ID продукта для извлечения", required = true, example = "123")
            })
    public ProductResponse getProductById(
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id) {
        return productService.getProductById(Long.parseLong(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать продукта",
            description = "Создание продукта",
            operationId = "createProduct")
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.createProduct(createProductRequest);
    }

    @DeleteMapping("/{id}")
    @GetMapping("/{id}")
    @Operation(summary = "Удалить продукт по ID",
            description = "Полностью удаляет продукт по ID",
            operationId = "deleteProduct",
            parameters = {
                    @Parameter(name = "id", description = "ID продукта для удаления", required = true, example = "123")
            })
    public ProductResponse deleteProduct(
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id) {
        return productService.deleteProduct(Long.parseLong(id));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновить продукт по ID",
            description = "Частичное обновление продукта по ID",
            operationId = "patchProduct",
            parameters = {
                    @Parameter(name = "id", description = "ID продукта для обновления", required = true, example = "123")
            })
    public ProductResponse patchProduct(
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id, @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.patchProduct(Long.parseLong(id), updateProductRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить продукт по ID",
            description = "Полное обновление продукта по ID",
            operationId = "putProduct",
            parameters = {
                    @Parameter(name = "id", description = "ID продукта для обновления", required = true, example = "123")
            })
    public ProductResponse putProduct(
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id, @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.putProduct(Long.parseLong(id), updateProductRequest);
    }
}

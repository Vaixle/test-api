package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.CreateProductRequest;
import com.vaixle.testapi.payload.request.UpdateProductRequest;
import com.vaixle.testapi.payload.response.ProductResponse;
import com.vaixle.testapi.payload.response.ProductsResponse;
import com.vaixle.testapi.service.ProductService;
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
//    @ApiOperation(
//            value = "Получить продукты",
//            notes = "Получить список продуктов",
//            response = ProductResponse.class)
    public ProductsResponse getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
//    @ApiOperation(
//            value = "Получить продукт",
//            notes = "Получить продукт по id",
//            response = ProductResponse.class)
    public ProductResponse getProductById(
//            @ApiParam(name = "id", value = "Id продукта", example = "1", required = true)
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id) {
        return productService.getProductById(Long.parseLong(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(
//            value = "Создать продукт",
//            notes = "Создание продукта",
//            response = ProductResponse.class)
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.createProduct(createProductRequest);
    }

    @DeleteMapping("/{id}")
//    @ApiOperation(
//            value = "Удалить продукт",
//            notes = "Удаление продукта по id",
//            response = ProductResponse.class)
    public ProductResponse deleteProduct(
//            @ApiParam(name = "id", value = "Id продукта", example = "1", required = true)
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id) {
        return productService.deleteProduct(Long.parseLong(id));
    }

    @PatchMapping("/{id}")
//    @ApiOperation(
//            value = "Обновить продукт",
//            notes = "Обновить название и описание продукта",
//            response = ProductResponse.class)
    public ProductResponse patchProduct(
//            @ApiParam(name = "id", value = "Id продукта", example = "1", required = true)
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id, @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.patchProduct(Long.parseLong(id), updateProductRequest);
    }

    @PutMapping("/{id}")
//    @ApiOperation(
//            value = "Обновить продукт",
//            notes = "Обновить название и описание продукта",
//            response = ProductResponse.class)
    public ProductResponse putProduct(
//            @ApiParam(name = "id", value = "Id продукта", example = "1", required = true)
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id, @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.putProduct(Long.parseLong(id), updateProductRequest);
    }
}

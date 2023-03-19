package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.UpdateProductRequest;
import com.vaixle.testapi.payload.response.ProductResponse;
import com.vaixle.testapi.service.ProductService;
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
//    @ApiOperation(
//            value = "Обновить продукт",
//            notes = "Обновить название и описание продукта",
//            response = ProductResponse.class)
    public ProductResponse patchProduct(
//            @ApiParam(name = "id", value = "Id продукта", example = "1", required = true)
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id,@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.patchProduct(Long.parseLong(id), updateProductRequest);
    }
}

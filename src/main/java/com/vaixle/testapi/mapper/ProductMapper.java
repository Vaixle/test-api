package com.vaixle.testapi.mapper;

import com.vaixle.testapi.model.Product;
import com.vaixle.testapi.payload.request.CreateProductRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    Product createProductRequestToProduct(CreateProductRequest createProductRequest);
}

package com.vaixle.testapi.service;


import com.vaixle.testapi.payload.request.CreateProductRequest;
import com.vaixle.testapi.payload.request.UpdateProductRequest;
import com.vaixle.testapi.payload.response.ProductResponse;
import com.vaixle.testapi.payload.response.ProductsResponse;

public interface ProductService {

    ProductsResponse getAllProducts();
    ProductResponse getProductById(long id);
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    ProductResponse deleteProduct(long id);
    ProductResponse updateProduct(long id, UpdateProductRequest updateProductRequest);
}

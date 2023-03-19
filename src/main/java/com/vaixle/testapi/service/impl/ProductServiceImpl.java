package com.vaixle.testapi.service.impl;

import com.vaixle.testapi.configuration.ExceptionConfig;
import com.vaixle.testapi.exception.NotFoundException;
import com.vaixle.testapi.mapper.ProductMapper;
import com.vaixle.testapi.model.Product;
import com.vaixle.testapi.payload.request.CreateProductRequest;
import com.vaixle.testapi.payload.request.UpdateProductRequest;
import com.vaixle.testapi.payload.response.ProductResponse;
import com.vaixle.testapi.payload.response.ProductsResponse;
import com.vaixle.testapi.repository.ProductRepository;
import com.vaixle.testapi.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductMapper productMapper;

    ExceptionConfig exceptionConfig;

    @Override
    @Transactional
    public ProductsResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ProductsResponse(products);
    }

    @Override
    @Transactional
    public ProductResponse getProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(exceptionConfig.getProductNotFoundMessageWithId(), id));
        return new ProductResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = productMapper.createProductRequestToProduct(createProductRequest);
        product = productRepository.save(product);
        return new ProductResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse deleteProduct(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(exceptionConfig.getProductNotFoundMessageWithId(), id));
        productRepository.deleteById(id);
        return new ProductResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse patchProduct(long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(exceptionConfig.getProductNotFoundMessageWithId(), id));
        if (updateProductRequest.getName() != null) {
            product.setName(updateProductRequest.getName());
        }
        if (updateProductRequest.getDescription() != null) {
            product.setDescription(updateProductRequest.getDescription());
        }
        product = productRepository.save(product);
        return new ProductResponse(product);
    }

    @Override
    public ProductResponse putProduct(long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(exceptionConfig.getProductNotFoundMessageWithId(), id));
        product.setName(updateProductRequest.getName());
        product.setDescription(updateProductRequest.getDescription());
        product = productRepository.save(product);
        return new ProductResponse(product);
    }
}
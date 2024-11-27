package com.ecom.service;

import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

//    @Override
//    public boolean existCategory(String category) {
//        return productRepository.existByCategory(category);
//    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

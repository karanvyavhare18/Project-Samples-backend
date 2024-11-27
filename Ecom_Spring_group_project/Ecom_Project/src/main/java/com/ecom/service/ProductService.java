package com.ecom.service;

import com.ecom.model.Product;
import jdk.jfr.Category;


import java.util.List;


public interface ProductService {

    Product addProduct(Product product);

//    public boolean existCategory(String category);

    public List<Product> getAllProducts();

}

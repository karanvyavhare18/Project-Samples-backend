package com.ecom.controller;


import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

   @Autowired
           ProductService productService;

   @Autowired
    CategoryService categoryService;

    @PostMapping("/addProducts")
    public ResponseEntity<?> addProduct(@ModelAttribute Product product, @RequestParam MultipartFile file){
        try {

//            // Check if the category already exists
//            if (categoryService.isCategoryPresent(product.getCategory())) {
//                return new ResponseEntity<>("Category already exists. Cannot add a product with the same category name.", HttpStatus.BAD_REQUEST);
//            }

            // Set default rating if not provided
            if (product.getRatings() == 0.0) {
                product.setRatings(0.0); // Default rating
            }

            if (product.getImage() == null || product.getImage().isEmpty()) {
                product.setImage("default.jpg"); // Set default image name
            }


            // Save the product
            product.setImage(product.getImage());
            Product savedProduct = productService.addProduct(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while saving the product.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts=productService.getAllProducts();
        return  new ResponseEntity<>(allProducts,HttpStatus.OK);
    }












//    @GetMapping("/getAllUsers");
//    @GetMapping("/getProductById");
//      @GetMapping("/getProductByName");  



}

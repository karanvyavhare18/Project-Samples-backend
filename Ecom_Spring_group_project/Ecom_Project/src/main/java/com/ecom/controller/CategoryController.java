package com.ecom.controller;

import com.ecom.model.Category;
import com.ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;




    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@ModelAttribute Category category, @RequestParam MultipartFile file ) {
        String imgName = (file != null && !file.isEmpty()) ? StringUtils.cleanPath(file.getOriginalFilename()) : "default.jpg";
        category.setImage(imgName);

        // Check if category already exists
        if (categoryService.isCategoryPresent(category.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Category already exists.");
        }

        // Save category
        Category savedCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
}

package com.ecom.controller;

import com.ecom.dto.LoginRequest;
import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommonController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;


    @Autowired
    UserRepository userRepository;



    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUserDetails(user), HttpStatus.CREATED);

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts=productService.getAllProducts();
        return  new ResponseEntity<>(allProducts,HttpStatus.OK);
    }
    @PostMapping("/signIn")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            // Log input
            System.out.println("Attempting login for email: " + loginRequest.getEmail());

            // Fetch user from DB
            User userFound = userRepository.findByEmail(loginRequest.getEmail());
            if (userFound == null) {
                System.out.println("User not found for email: " + loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Invalid email or password"));
            }

            // Verify password
            if (!userFound.getPassword().equals(loginRequest.getPassword())) {
                System.out.println("Invalid password for email: " + loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Invalid email or password"));
            }

            // Log successful authentication
            System.out.println("Login successful for email: " + loginRequest.getEmail());
            System.out.println("User role: " + userFound.getRole());

            // Return success response with user role
            return ResponseEntity.ok(Map.of(
                    "message", "Login successful",
                    "role", userFound.getRole(),
                    "userId", userFound.getId()
            ));
        } catch (Exception ex) {
            System.out.println("Error during login: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred during login"));
        }
    }
}
//    @GetMapping("/getAllProducts")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> allProducts = productService.getAllProducts();
//        return new ResponseEntity<>(allProducts, HttpStatus.OK);
//    }
//
//    @PostMapping("/saveUser")
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        return new ResponseEntity<User>(userService.saveUserDetails(user), HttpStatus.CREATED);
//
//    }

//    @PostMapping("/signIn")
//    public ResponseEntity<?> login(@RequestBody User user) {
//    return null;
//    }
//}


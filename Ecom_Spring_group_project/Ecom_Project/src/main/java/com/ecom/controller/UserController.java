package com.ecom.controller;

import com.ecom.dto.LoginRequest;
import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;



    @Autowired
    UserRepository userRepository;

//    @PostMapping("/saveUser")
//    public ResponseEntity<User> saveUser(@RequestBody User user){
//    return new ResponseEntity<User>(userService.saveUserDetails(user), HttpStatus.CREATED);
//
//    }
//
//    @GetMapping("/getAllProducts")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        List<Product> allProducts=productService.getAllProducts();
//        return  new ResponseEntity<>(allProducts,HttpStatus.OK);
//    }

//    @PostMapping("/signIn")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        try {
//            // Log input
//            System.out.println("Attempting login for email: " + user.getEmail());
//
//            // Authenticate the user
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            user.getEmail(),
//                            user.getPassword()
//                    )
//            );
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // Log authentication success
//            System.out.println("Authentication successful for email: " + user.getEmail());
//
//            // Fetch user from DB
//            User userfound = userRepository.findByEmail(user.getEmail());
//            if (userfound == null) {
//                System.out.println("User not found in database for email: " + user.getEmail());
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                        .body(Map.of("message", "Invalid email or password"));
//            }
//
//            // Log user role
//            System.out.println("User role: " + userfound.getRole());
//
//            return ResponseEntity.ok(Map.of(
//                    "message", "Login successful",
//                    "role", userfound.getRole(),
//                    "userId", userfound.getId()
//            ));
//        } catch (Exception ex) {
//            System.out.println("Error during login: " + ex.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("message", "Invalid email or password"));
//        }
//    }



//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//        String role = userService.loginUser(loginRequest);
//
//        if (role != null) {
//            // Return role with HTTP 200 OK status
//            return ResponseEntity.ok(role);
//        } else {
//            // Return error message with HTTP 401 Unauthorized status
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
//        }
//    }
}


//    @GetMapping("/")
//    public String homePage(){
//        return "home";
//
//    }




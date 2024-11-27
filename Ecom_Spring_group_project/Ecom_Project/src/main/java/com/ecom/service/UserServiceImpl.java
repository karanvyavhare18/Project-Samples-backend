package com.ecom.service;

import com.ecom.dto.LoginRequest;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired

    UserRepository userRepository;

    @Override
    public User saveUserDetails(User user) {
        return userRepository.save(user);
    }

    public String loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return user.getRole(); // Ensure the role is properly fetched
        }
        return null; // Return null if credentials are invalid
    }

}


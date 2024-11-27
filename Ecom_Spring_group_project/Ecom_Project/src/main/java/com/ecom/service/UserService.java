package com.ecom.service;

import com.ecom.dto.LoginRequest;
import com.ecom.model.User;

public interface UserService {

    public User saveUserDetails(User user);
    public String loginUser(LoginRequest loginRequest);
}

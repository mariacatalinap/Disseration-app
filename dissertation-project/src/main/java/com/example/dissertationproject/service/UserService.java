package com.example.dissertationproject.service;

import com.example.dissertationproject.dto.UserRegistrationDto;
import com.example.dissertationproject.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
}

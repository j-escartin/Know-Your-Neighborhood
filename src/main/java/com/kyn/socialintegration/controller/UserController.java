package com.kyn.socialintegration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.socialintegration.dto.UserDto;
import com.kyn.socialintegration.entity.User;
import com.kyn.socialintegration.exception.ResourceNotFoundException;
import com.kyn.socialintegration.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public UserDto getLoginUser(Authentication authentication) {
      User user = userRepository.findByEmail(authentication.getName()).get();

      if (user == null) {
        throw new ResourceNotFoundException("User", "Email", authentication.getName());
      }
      return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}

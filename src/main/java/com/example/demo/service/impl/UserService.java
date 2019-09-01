package com.example.demo.service.impl;


import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private RoleService roleService;


        public void save(User user){
            Role role = roleService.getByRole("user");
            user.setRole(role);

            //kodowanie hasła użytkownika przed zapisem do bazy danych
            PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }

        public List<User> findAll(){
            return userRepository.findAll();
        }
}

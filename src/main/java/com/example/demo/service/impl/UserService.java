package com.example.demo.service.impl;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        public void save(User user){
            userRepository.save(user);
        }

        public List<User> findAll(){
            return userRepository.findAll();
        }
}

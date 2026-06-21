package com.project.erp.erp_system.service;

import com.project.erp.erp_system.entity.User;
import com.project.erp.erp_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User update) {
        User user = userRepository.findById(id).orElseThrow();

        user.setUsername(update.getUsername());
        user.setEmail(update.getEmail());
        user.setPassword(update.getPassword());
        user.setRole(update.getRole());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

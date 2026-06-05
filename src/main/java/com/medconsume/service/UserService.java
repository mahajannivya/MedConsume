package com.medconsume.service;

import com.medconsume.model.User;
import com.medconsume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User registerUser(User user) {
        // Default role if none provided
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        // Default status too (optional)
        if (user.getStatus() == null || user.getStatus().isEmpty()) {
            user.setStatus("PENDING");
        }

        return userRepository.save(user);
    }



    public User validateUser(String email, String password, String role) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) return null;

        // prevent NullPointerException
        if (user.getRole() == null || !user.getRole().equalsIgnoreCase(role)) return null;

        // approval check
        if (user.getStatus() == null || !user.getStatus().equalsIgnoreCase("APPROVED")) return null;

        return user;
    }

    public List<User> getPendingUsers() {
        return userRepository.findByStatus("PENDING");
    }
    public void approveUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus("APPROVED");
        userRepository.save(user);
    }
    public void rejectUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus("REJECTED");
        userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            return existingUser;
        }
        return null;
    }


}

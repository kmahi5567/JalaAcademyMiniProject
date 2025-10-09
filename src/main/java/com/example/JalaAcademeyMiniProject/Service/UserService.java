package com.example.JalaAcademeyMiniProject.Service;



import com.example.JalaAcademeyMiniProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        // Only allow this email/password
        return "training@jalaacademey.com".equals(email) && "jobprogram".equals(password);
    }
}


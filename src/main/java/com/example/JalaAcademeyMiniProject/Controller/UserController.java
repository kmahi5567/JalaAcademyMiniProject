package com.example.JalaAcademeyMiniProject.Controller;


import com.example.JalaAcademeyMiniProject.Model.User;
import com.example.JalaAcademeyMiniProject.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // login.html
    }

    // Process login
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        if (userService.authenticate(email, password)) {
            session.setAttribute("loggedInUser", email);
            return "redirect:/student/list"; // redirect to student list
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}

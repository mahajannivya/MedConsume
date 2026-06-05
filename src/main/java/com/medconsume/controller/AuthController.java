
package com.medconsume.controller;

        import com.medconsume.model.User;
        import com.medconsume.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }
    @GetMapping("/signup-success")
    public String signupSuccessPage() {
        return "signup-success";
    }


    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, Model model) {
        user.setStatus("pending");
        userService.registerUser(user);
        model.addAttribute("message", "Registration successful! Wait for admin approval.");
        return "signupsuccess";
    }
@GetMapping("/admin")
public String admin(){
        return "admin";
}

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role,
                               Model model) {

        User user = userService.validateUser(email, password,role);

        if (user == null) {
            model.addAttribute("error", "Invalid email, password, or role.");
            return "login";
        }

        if (user.getStatus().equalsIgnoreCase("pending")) {
            model.addAttribute("error", "Your account is awaiting admin approval.");
            return "login";
        }
        if (user.getStatus().equalsIgnoreCase("rejected")) {
            model.addAttribute("error", "Your signup request was rejected.");
            return "login";
        }

        if (role.equalsIgnoreCase("admin")) {
            return "admin";
        } else {
            return "redirect:/search";
        }
    }

    @GetMapping("/pendingusers")
    public String pendingUsersPage() {
        return "pendingusers";
    }
    @GetMapping("/medicinesedit")
    public String showMed(){
        return "medicinesedit";
    }
}
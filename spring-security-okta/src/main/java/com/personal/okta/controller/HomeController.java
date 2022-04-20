package com.personal.okta.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	

    private Map<String, LocalDateTime> usersLastAccess = new HashMap<>();
	
	@GetMapping("/")
	public String getCurrentUser(@AuthenticationPrincipal User user, Model model) {
        String username = user.getUsername();
        
        model.addAttribute("username", username);
        model.addAttribute("lastAccess", usersLastAccess.get(username));

        usersLastAccess.put(username, LocalDateTime.now());

        return "home";
    }
}

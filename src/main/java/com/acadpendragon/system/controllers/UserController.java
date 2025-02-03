package com.acadpendragon.system.controllers;

import com.acadpendragon.system.dto.UserDTO;
import com.acadpendragon.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") // Permite todas as origens (não recomendado para produção)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/pagamento/false")
    public List<UserDTO> getUsersWithPaymentFalse() {
        return userService.getUsersWithPaymentFalse();
    }

    @PutMapping("/{id}/pagamento")
    public UserDTO updateUserPayment(@PathVariable Long id, @RequestParam boolean pagamento) {
        return userService.updateUserPayment(id, pagamento);
    }
}

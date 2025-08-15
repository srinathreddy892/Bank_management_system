package com.BankManagement.Operations.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankManagement.Operations.DTO.UserDto;
import com.BankManagement.Operations.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new account
    @PostMapping
    public UserDto createAccount(@RequestBody UserDto userDtO) {
        return userService.createAccount(userDtO);
    }


    // Check balance
    @GetMapping("/{id}/double")
    public double checkBalance(@PathVariable long id) {
        return userService.checkBalance(id);
    }

    // Withdraw
    @PutMapping("/{id}/withdraw/{amount}")
    public String withdraw(@PathVariable long id, @PathVariable double amount) {
        userService.withdraw(id, amount);
        return "Withdrawal successful";
    }
    //update name
    @PutMapping("/{id}/name/{name}")
    public String updateName(@PathVariable long id, @PathVariable String name) {
        userService.updateName(id, name);
        return "Name updated successfully";
    }
    // Deposit
    @PutMapping("/{id}/deposit/{amount}")
    public String deposit(@PathVariable long id, @PathVariable double amount) {
        userService.deposit(id, amount);
        return "Deposit successful";
    }

    // Close account
    @DeleteMapping("/{id}")
    public String closeAccount(@PathVariable long id) {
        userService.closeAccount(id);
        return "Account closed";
    }
	
}

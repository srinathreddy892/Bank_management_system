package com.BankManagement.Operations.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankManagement.Operations.DTO.UserDto;
import com.BankManagement.Operations.Entity.User;
import com.BankManagement.Operations.Repository.UserRepository;
import com.BankManagement.Operations.Service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDto createAccount(UserDto userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public double checkBalance(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getAmount();
    }

    @Override
    @Transactional
    public void withdraw(long id, double amount) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getAmount() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        user.setAmount(user.getAmount() - amount);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deposit(long id, double amount) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setAmount(user.getAmount() + amount);
        userRepository.save(user);
    }

    @Override
    public void updateName(long id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public void closeAccount(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::new) // Uses constructor UserDto(User)
                .collect(Collectors.toList());
    }
}

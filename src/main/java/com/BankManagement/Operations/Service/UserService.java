package com.BankManagement.Operations.Service;
	
import java.util.List;

import com.BankManagement.Operations.DTO.UserDto;
	
	public interface UserService{
		 UserDto createAccount(UserDto userDTO);
		    double checkBalance(long id);
		    void withdraw(long id, double amount);
		    void deposit(long id, double amount);
		    void closeAccount(long id);
		    void updateName(long id, String name);
		    List<UserDto> getAllUsers();
	
	}

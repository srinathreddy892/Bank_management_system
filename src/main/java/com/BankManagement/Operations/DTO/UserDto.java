package com.BankManagement.Operations.DTO;

import com.BankManagement.Operations.Entity.User;

public class UserDto {
	private long id;
    private String name;
    private double amount;

    public UserDto() {
		// TODO Auto-generated constructor stub
	}
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.amount = user.getAmount();
    }
    
	// Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

}

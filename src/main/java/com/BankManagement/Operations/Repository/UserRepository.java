package com.BankManagement.Operations.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankManagement.Operations.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	 Optional<User> findById(Long id);

}

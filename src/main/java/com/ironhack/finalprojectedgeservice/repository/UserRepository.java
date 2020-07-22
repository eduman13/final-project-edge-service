package com.ironhack.finalprojectedgeservice.repository;

import com.ironhack.finalprojectedgeservice.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   User findByUsername(String username);
}

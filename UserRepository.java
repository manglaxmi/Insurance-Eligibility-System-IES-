package com.IES.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.IES.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email); // ✅ REQUIRED
}
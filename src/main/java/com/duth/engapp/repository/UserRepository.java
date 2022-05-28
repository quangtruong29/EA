package com.duth.engapp.repository;

import com.duth.engapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);

}
package com.duth.engapp.service;

import com.duth.engapp.entity.CustomUserDetails;
import com.duth.engapp.entity.User;
import com.duth.engapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findUserByEmail(email);

        if (user.getEmail().isBlank()) {
            throw new UsernameNotFoundException(email);
        }
        logger.info("loadUserByUsername " + user);
        return new CustomUserDetails(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        logger.info("loadUserById" + user.toString());
        return new CustomUserDetails(user);
    }

}
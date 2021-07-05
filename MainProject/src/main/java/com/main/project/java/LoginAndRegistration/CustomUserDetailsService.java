package com.main.project.java.LoginAndRegistration;

import com.main.project.java.Entity.User;
import com.main.project.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService  implements UserDetailsService {
@Autowired
   private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {

        User user = userRepository.findByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }


    }


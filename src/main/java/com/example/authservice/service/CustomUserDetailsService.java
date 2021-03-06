package com.example.authservice.service;

import com.example.authservice.model.AuthenticationServiceUser;
import com.example.authservice.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticationServiceUser authenticationServiceUser = userRepository.findByUsername(username).get();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        authenticationServiceUser.getAuthorities().forEach(authority -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole()));
        });
                //.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return new
                org.springframework.security.core.userdetails.User(authenticationServiceUser.getUsername(),
                authenticationServiceUser.getPassword(), grantedAuthorities);
    }
}

package com.example.CarRent.Service;

import com.example.CarRent.Model.User;
import com.example.CarRent.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(usernameOrEmail);
        if (user != null) {
            return mapToUserDetails (user);
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }


    private org.springframework.security.core.userdetails.User mapToUserDetails(User user) {
        var email = user.getEmail();
        var password = user.getPassword();
        var roles = user.getRoleList().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(email, password, roles);
    }
}

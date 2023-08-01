package com.example.CarRent.Mapper;

import com.example.CarRent.Dto.UserDto;
import com.example.CarRent.Model.Role;
import com.example.CarRent.Model.User;
import com.example.CarRent.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User getUser(UserDto userDto) {
        return mapToUser(userDto);
    }

    private User mapToUser (UserDto userDto) {

        Role role = roleRepository.findById(userDto.getRole()).get();

        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .roleList(Arrays.asList(role))
                .build();
    }

}

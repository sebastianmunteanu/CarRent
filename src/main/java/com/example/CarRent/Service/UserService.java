package com.example.CarRent.Service;

import com.example.CarRent.Dto.UserDto;
import com.example.CarRent.Mapper.UserMapper;
import com.example.CarRent.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void saveUser(UserDto userDto) {
         userRepository.save(userMapper.getUser(userDto));
    }

    public boolean findIfUserExist(String email) {
        return userRepository.findByEmail(email) == null ? false : true;
    }

}

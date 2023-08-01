package com.example.CarRent.Service;

import com.example.CarRent.Dto.RoleDto;
import com.example.CarRent.Mapper.RoleMapper;
import com.example.CarRent.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public List<RoleDto> getAllRoles () {
        return roleMapper.getAllRoles(roleRepository.findAll());
    }
}

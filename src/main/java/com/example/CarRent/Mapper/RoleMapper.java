package com.example.CarRent.Mapper;

import com.example.CarRent.Dto.RoleDto;
import com.example.CarRent.Model.Role;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public List<RoleDto> getAllRoles (List<Role> roles) {
        return roles.stream()
                .map(role -> mapToRoleDto(role))
                .collect(Collectors.toList());
    }
    private RoleDto mapToRoleDto (Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .build();
    }

}

package com.example.CarRent.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "rolename")
    private String roleName;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList = new ArrayList<>();

    public Role(String roleName) {
        this.roleName = roleName;
    }

}

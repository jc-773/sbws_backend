package com.mysql.example.demo.repositories.authenticaitonRepositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mysql.example.demo.models.ERole;
import com.mysql.example.demo.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

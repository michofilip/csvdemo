package com.example.scvdemo.repositories;

import com.example.scvdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    public List<User> getAll() {
        return List.of(
                new User(1, "Ala"),
                new User(2, "Ola"),
                new User(3, "Ela"),
                new User(4, "Ula")
        );
    }
}

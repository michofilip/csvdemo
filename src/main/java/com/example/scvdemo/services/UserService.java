package com.example.scvdemo.services;

import com.example.scvdemo.engines.CSVSaver;
import com.example.scvdemo.model.User;
import com.example.scvdemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void downloadCSV(PrintWriter writer) throws IOException {
        List<User> users = getAll();
        CSVSaver.saveUsers(users, writer);
    }

}

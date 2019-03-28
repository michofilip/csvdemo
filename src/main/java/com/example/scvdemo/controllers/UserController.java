package com.example.scvdemo.controllers;

import com.example.scvdemo.model.User;
import com.example.scvdemo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @RequestMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/download")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", "users.csv");
        response.setHeader(headerKey, headerValue);

        userService.downloadCSV(response.getWriter());
    }
}

package com.ipssi.testing.controller;

import com.ipssi.testing.ressources.RestUser;
import com.ipssi.testing.service.Display;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Display display;

    @GetMapping("/users")
    public List<RestUser> getAllUsers() {
        return display.getUsers();
    }
}

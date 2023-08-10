package com.example.spotik;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/nopassword")
    public List<UserDTO> getAllUsersNoPassword() {
        return usersService.getAllUsersNoPassword();
    }

    @PostMapping("/users")
    public Long saveUser(@RequestBody User user) { return usersService.saveUser(user);}
}

package com.example.spotik;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final UserMapper userMapper;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/nopassword")
    public List<UserDTO> getAllUsersNoPassword() {
        return usersService.getAllUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/users")
    public Long saveUser(@RequestBody User user) { return usersService.saveUser(user);}


    @GetMapping("/users/filter")
    public List<UserDTO> getUsersByParametr(@RequestParam(required = false) String nickname,
                                            @RequestParam(required = false) Integer age,
                                            @RequestParam(required = false) String sex){
        return usersService.filterParam(nickname, age, sex).stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }


}

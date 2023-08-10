package com.example.spotik;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService{
    private final UsersRepository usersRepository;
    private final   UserMapper userMapper;


    public Iterable<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public Long saveUser(User user) {
        return usersRepository.save(user).getId();
    }
    public List<UserDTO> getAllUsersNoPassword() {
        return usersRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}

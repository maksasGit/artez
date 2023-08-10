package com.example.spotik;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService{
    private final UsersRepository usersRepository;

    public Iterable<User> getAllUsers() {
        return usersRepository.findAll();
    }


    public Long saveUser(User user) {
        return usersRepository.save(user).getId();
    }

    public Iterable<UserDTO> getAllUsersNoPassword() {
        return usersRepository.getAllUsersNoPassword();
    }
}

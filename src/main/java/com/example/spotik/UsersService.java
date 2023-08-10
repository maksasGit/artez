package com.example.spotik;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService{
    private final UsersRepository usersRepository;
    private final  UserMapper userMapper;

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public Long saveUser(User user) {
        return usersRepository.save(user).getId();
    }

    public List<User> filterParam(String nickname, Integer age, String sex) {
        List<User> usersByNick = usersRepository.findAll();
        List<User> usersByAge = usersRepository.findAll();
        List<User> usersBySex = usersRepository.findAll();
        if (nickname!=null) {
            usersByNick = usersRepository.findByNickname(nickname);
        }
        if (age!=null){
            usersByAge = usersRepository.findByAge(age);
        }
        if (sex!=null){
            usersBySex = usersRepository.findBySex(sex);
        }
        Set<User> resultSet = new HashSet<>(usersByNick);
        resultSet.retainAll(usersByAge);
        resultSet.retainAll(usersBySex);
        return new ArrayList<>(resultSet);
    }
}

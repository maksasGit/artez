package com.example.spotik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findByNickname(String nickname);
    List<User> findByAge(Integer age);
    List<User> findBySex(String sex);

}

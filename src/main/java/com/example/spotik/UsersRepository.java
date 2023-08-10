package com.example.spotik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.example.spotik.UserDTO(u.id, u.nickname, u.age, u.sex) FROM User u")
    Iterable<UserDTO> getAllUsersNoPassword();
}

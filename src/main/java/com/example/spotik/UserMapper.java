package com.example.spotik;


import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO toDTO(User user);

    User DTOto(UserDTO userDTO);
}

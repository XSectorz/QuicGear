package com.xsectorz.quicgear.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.xsectorz.quicgear.dto.SignUpDto;
import com.xsectorz.quicgear.dto.UserDto;
import com.xsectorz.quicgear.model.User;

@Mapper(componentModel="spring")
public interface  UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore=true)
    User signUpToUser(SignUpDto signUpDto);

}

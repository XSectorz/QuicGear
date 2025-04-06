package com.xsectorz.quicgear.service;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xsectorz.quicgear.dto.CredentialsDto;
import com.xsectorz.quicgear.dto.SignUpDto;
import com.xsectorz.quicgear.dto.UserDto;
import com.xsectorz.quicgear.exception.AppException;
import com.xsectorz.quicgear.mappers.UserMapper;
import com.xsectorz.quicgear.model.User;
import com.xsectorz.quicgear.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByUsername(credentialsDto.username()).orElseThrow(() -> new AppException("Unknow user", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalide password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto)  {

        Optional<User> oUser = userRepository.findByUsername(signUpDto.username());

        if(oUser.isPresent()) {
            throw new AppException("Username already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(signUpDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
        user.setEmail(signUpDto.email());
        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

}

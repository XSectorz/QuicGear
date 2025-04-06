package com.xsectorz.quicgear.dto;

import com.xsectorz.quicgear.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private UserRole userRole;
    private String username;
    private String email;
    private double balance;
    private String token;

}

package com.booking.backend.service;


import com.booking.backend.dto.RegisterDTO;

public interface RegisterService {
    int saveUser(RegisterDTO userDTO);
    RegisterDTO searchUser(String username);
}
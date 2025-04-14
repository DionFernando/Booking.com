package com.booking.backend.service.impl;

import com.booking.backend.dto.RegisterDTO;
import com.booking.backend.entity.Register;
import com.booking.backend.repo.RegisterRepository;
import com.booking.backend.service.RegisterService;
import com.booking.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RegisterServiceImpl implements UserDetailsService, RegisterService {

    @Autowired
    private RegisterRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Register user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    public RegisterDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        Register user = userRepository.findByEmail(username);
        return modelMapper.map(user, RegisterDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(Register user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }

    @Override
    public RegisterDTO searchUser(String username) {
        if (userRepository.existsByEmail(username)) {
            Register user=userRepository.findByEmail(username);
            return modelMapper.map(user, RegisterDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public Object getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public int saveUser(RegisterDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
           // userDTO.setRole("USER");
            userRepository.save(modelMapper.map(userDTO, Register.class));
            return VarList.Created;
        }
    }}

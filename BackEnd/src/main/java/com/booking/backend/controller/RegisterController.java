package com.booking.backend.controller;

import com.booking.backend.dto.AuthDTO;
import com.booking.backend.dto.ResponseDTO;
import com.booking.backend.dto.RegisterDTO;
import com.booking.backend.service.RegisterService;
import com.booking.backend.util.JwtUtil;
import com.booking.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/user")
public class RegisterController {
    private final RegisterService userService;
    private final JwtUtil jwtUtil;

    public RegisterController(RegisterService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid RegisterDTO userDTO) {
        try {
            int res = userService.saveUser(userDTO);
            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", authDTO));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    /*get all users*/
   /* @GetMapping(value = "/all")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.Ok, "Success", userService.getAllUsers()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }*/

    @GetMapping(value = "/all")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        System.out.println("getAllUsers endpoint hit");
        try {
            Object users = userService.getAllUsers();
            System.out.println("User count: " + ((List<?>) users).size());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.Ok, "Success", users));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

}

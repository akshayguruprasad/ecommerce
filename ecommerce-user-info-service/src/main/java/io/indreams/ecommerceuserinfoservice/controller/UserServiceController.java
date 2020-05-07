package io.indreams.ecommerceuserinfoservice.controller;

import io.indreams.ecommerceuserinfoservice.model.Address;
import io.indreams.ecommerceuserinfoservice.model.requestDTO.UserRegisterationRequestDTO;
import io.indreams.ecommerceuserinfoservice.model.responseDTO.UserResponseDTO;
import io.indreams.ecommerceuserinfoservice.service.UserService;
import io.indreams.ecommerceuserinfoservice.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegisterationRequestDTO userRegisterationRequestDTO) {
        return userService.registerUser(userRegisterationRequestDTO);
    }

    @GetMapping("/validate")
    public boolean validateUser(@RequestParam String userName) {
        return userService.validateUser(userName);
    }

    @PostMapping("/add/address")
    public String addAddress(@RequestBody Address address,@RequestHeader Map<String, String> headers) {
        String userName=Utility.getUserName(headers);
        return userService.addUserAddress(address,userName);
    }

    @GetMapping("/get/address")
    public List<Address> getAddresses(@RequestHeader Map<String, String> headers) {
        String userName=Utility.getUserName(headers);
        return userService.getAddresses(userName);
    }

    @GetMapping("/get/users")
    public List<UserResponseDTO> getUsers() {
        return userService.getAllUsers();
    }

    public String heart() {
        return "Hi";
    }
}

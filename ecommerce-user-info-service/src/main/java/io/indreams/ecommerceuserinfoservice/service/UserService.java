package io.indreams.ecommerceuserinfoservice.service;

import io.indreams.ecommerceuserinfoservice.model.Address;
import io.indreams.ecommerceuserinfoservice.model.requestDTO.UserRegisterationRequestDTO;
import io.indreams.ecommerceuserinfoservice.model.responseDTO.UserResponseDTO;

import java.util.List;

public interface UserService {
    String registerUser(UserRegisterationRequestDTO userRegisterationRequestDTO);

    boolean validateUser(String userName);

    String addUserAddress(Address address, String userName);

    List<Address> getAddresses(String userName);

    List<UserResponseDTO> getAllUsers();
}

package io.indreams.ecommerceuserinfoservice.service;

import io.indreams.ecommerceuserinfoservice.configuration.security.dao.UserRepository;
import io.indreams.ecommerceuserinfoservice.dao.UserRepo;
import io.indreams.ecommerceuserinfoservice.exception.UserFoundException;
import io.indreams.ecommerceuserinfoservice.model.Address;
import io.indreams.ecommerceuserinfoservice.model.User;
import io.indreams.ecommerceuserinfoservice.model.UserDAO;
import io.indreams.ecommerceuserinfoservice.model.requestDTO.UserRegisterationRequestDTO;
import io.indreams.ecommerceuserinfoservice.model.responseDTO.UserResponseDTO;
import io.indreams.ecommerceuserinfoservice.utility.Constants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepo userRepo; //MONGO

    @Autowired
    private UserRepository userRepository; //JPA

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String registerUser(UserRegisterationRequestDTO userRegisterationRequestDTO) {
        LOGGER.info(Constants.USER_REGISTERATION_SERVICE_START);
        UserDAO user = modelMapper.map(userRegisterationRequestDTO, UserDAO.class);
        Optional<User> userModel = userRepository.findByUsername(user.getUserName());
        if (userModel.isPresent()) throw new UserFoundException(Constants.USER_FOUND_EXCEPTION);
        User userCred = modelMapper.map(userRegisterationRequestDTO, User.class);
        userRepository.save(userCred);
        LOGGER.info(Constants.USER_REGISTERATION_PHASE_1_COMPLETED);
        userRepo.save(user);
        LOGGER.info(Constants.USER_REGISTERATION_PHASE_2_COMPLETED);
        LOGGER.info(Constants.USER_REGISTERATION_SERVICE_END);
        return Constants.SUCCESS;
    }

    @Override
    public boolean validateUser(String userName) {
        Optional<User> userModel = userRepository.findByUsername(userName);
        return userModel.isPresent();
    }

    @Override
    public String addUserAddress(Address address, String userName) {
        Optional<UserDAO> entity = userRepo.findById(userName);
        if (!entity.isPresent()) throw new UsernameNotFoundException(Constants.NO_USER_FOUND);
        UserDAO dbUserDetails = entity.get();
        dbUserDetails.getAddressList().add(address);
        userRepo.save(dbUserDetails);
        return Constants.SUCCESS;
    }

    @Override
    public List<Address> getAddresses(String userName) {
        Optional<UserDAO> entity = userRepo.findById(userName);
        if (!entity.isPresent()) throw new UsernameNotFoundException(Constants.NO_USER_FOUND);
        UserDAO dbUserDetails = entity.get();
        return dbUserDetails.getAddressList();
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll().stream().map(user -> {
            return modelMapper.map(user, UserResponseDTO.class);
        }).collect(Collectors.toList());
    }
}

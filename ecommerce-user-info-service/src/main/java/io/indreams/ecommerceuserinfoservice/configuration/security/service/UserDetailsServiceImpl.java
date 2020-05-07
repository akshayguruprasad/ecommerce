package io.indreams.ecommerceuserinfoservice.configuration.security.service;

import io.indreams.ecommerceuserinfoservice.configuration.security.dao.UserRepository;
import io.indreams.ecommerceuserinfoservice.model.User;
import io.indreams.ecommerceuserinfoservice.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);
        if (user.isPresent()) return new UserDetailsImpl(user.get());
        throw new UsernameNotFoundException(Constants.NO_USER_FOUND);
    }
}

package com.app.AidNearby.services.impl;

import com.app.AidNearby.Exceptions.InvalidCredentialsException;
import com.app.AidNearby.Exceptions.UserNotFoundException;
import com.app.AidNearby.domain.DTO.authDTO.AuthResponseDTO;
import com.app.AidNearby.domain.DTO.userDTO.UserDTO;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.Mapper;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.EntryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EntryServiceImpl implements EntryService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;
    private final JWTserviceImpl jwtService;
    private final Mapper<UserEntity, UserDTO> userMapper;

    @Override
    public UserEntity createUser(String password, String username, String email) {
        if (password == null || username == null || email == null) {
            throw new IllegalArgumentException("Password, username and email cannot be null.");
        }

        UserEntity userEntity = UserEntity.builder()
                .password(encoder.encode(password))
                .email(email)
                .username(username).build();

        UserEntity savedUser = null;

        try {
            savedUser = userRepository.save(userEntity);
        }catch (DataIntegrityViolationException ex) {
            throw new IllegalArgumentException("Username or email already exists.");
        }

        return savedUser;
    }

    @Override
    public AuthResponseDTO verify(String password, String username, HttpServletRequest request) {

            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            //This will authenticate the user via AuthenticationProvider

            UserEntity userEntity = userRepository.findByUsername(username);
            if (userEntity == null) {
                throw new UserNotFoundException("User not found with username: " + username);
            }

            if(authentication.isAuthenticated()) {
                String ipAddress = request.getRemoteAddr();
                String token = jwtService.generateToken(username,userEntity.getUserId(),ipAddress,userEntity.getLatitude(),userEntity.getLongitude());
                return new AuthResponseDTO(userMapper.mapToDto(userEntity), token);
            } else {
                throw new InvalidCredentialsException("Invalid credentials");
            }
    }
}

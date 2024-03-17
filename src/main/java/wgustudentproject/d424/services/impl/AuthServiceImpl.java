package wgustudentproject.d424.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wgustudentproject.d424.dto.LoginDTO;
import wgustudentproject.d424.dto.RegisterDTO;
import wgustudentproject.d424.entity.Role;
import wgustudentproject.d424.entity.User;
import wgustudentproject.d424.exception.RegisterAPIException;
import wgustudentproject.d424.repository.RoleRepository;
import wgustudentproject.d424.repository.UserRepository;
import wgustudentproject.d424.services.AuthService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDTO registerDTO) {
        //Check if email exist in DB
        if(userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new RegisterAPIException(HttpStatus.BAD_REQUEST, "Email already registered");
        }

        //Create user as long as email is not already registered in DB
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getFirstName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        //Setting the role
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        //Set role of user
        user.setRoles(roles);

        userRepository.save(user);

        return "User has been registered successfully.";
    }

    @Override
    public String login(LoginDTO loginDTO) {
       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getEmail(),
                loginDTO.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User login successful.";
    }
}

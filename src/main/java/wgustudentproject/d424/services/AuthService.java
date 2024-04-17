package wgustudentproject.d424.services;

import wgustudentproject.d424.dto.JwtAuthResponse;
import wgustudentproject.d424.dto.LoginDTO;
import wgustudentproject.d424.dto.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO registerDTO);
    JwtAuthResponse login(LoginDTO loginDTO);
}

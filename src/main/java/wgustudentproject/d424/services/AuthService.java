package wgustudentproject.d424.services;

import wgustudentproject.d424.dto.LoginDTO;
import wgustudentproject.d424.dto.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO registerDTO);
    String login(LoginDTO loginDTO);
}

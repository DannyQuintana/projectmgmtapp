package wgustudentproject.d424.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wgustudentproject.d424.dto.JwtAuthResponse;
import wgustudentproject.d424.dto.LoginDTO;
import wgustudentproject.d424.dto.RegisterDTO;
import wgustudentproject.d424.services.AuthService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {

        String response = authService.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login (@RequestBody LoginDTO loginDTO){
        JwtAuthResponse jwtAuthResponse = authService.login(loginDTO);


        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }


}

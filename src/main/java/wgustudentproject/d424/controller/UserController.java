package wgustudentproject.d424.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wgustudentproject.d424.dto.UserDTO;
import wgustudentproject.d424.services.UserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.createUser(userDTO);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") int userId){
        UserDTO user = userService.getUserById(userId);

        return ResponseEntity.ok(user);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int userId, @RequestBody UserDTO userDTO){
        UserDTO user = userService.updateUsers(userId, userDTO);

        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userID){
        userService.deleteUser(userID);

        return ResponseEntity.ok("Employee Deleted");
    }
}

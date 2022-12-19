package com.example.dmd_damn_delicious.auth;

import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.model.UserDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDTO registrationDTO, HttpServletResponse response) {
        if (!registrationDTO.getPassword1().equals(registrationDTO.getPassword2())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passwords don't match.");
        }

        UserDTO userDTO = UserDTO.fromEntity(this.authService.register(registrationDTO));
        Cookie cookie = this.authService.createTokenCookie(userDTO.getUsername());
        response.addCookie(cookie);
        return ResponseEntity.ok(userDTO);

    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserLogin userLogin, HttpServletResponse response) {
        User user = this.authService.authenticate(userLogin.getUsername(), userLogin.getPassword());
        Cookie cookie = this.authService.createTokenCookie(user.getUsername());
        response.addCookie(cookie);
        return UserDTO.fromEntity(user);
    }

    @GetMapping("/check")
    public ResponseEntity<Void> currentUser(Principal principal) {
        if (principal != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private static class UserLogin {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

}

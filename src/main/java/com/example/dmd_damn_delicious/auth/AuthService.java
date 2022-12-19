package com.example.dmd_damn_delicious.auth;

import com.example.dmd_damn_delicious.auth.exception.UsernameTakenException;
import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.security.jwt.JWTUtil;
import com.example.dmd_damn_delicious.service.UserService;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final static int COOKIE_AGE_24H = 24 * 60 * 60;

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.cookieName}")
    private String jwtCookieName;

    public AuthService(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    protected User authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return this.userService.findByUsername(authentication.getName()).orElseThrow();
    }

    protected Cookie createTokenCookie(String username) {
        String token = jwtUtil.generateToken(username);

        Cookie cookie = new Cookie(jwtCookieName, token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(COOKIE_AGE_24H);
        cookie.setPath("/");
        return cookie;
    }

    public User register(RegistrationDTO registrationDTO) {
        if (userService.userExists(registrationDTO.getUsername())) {
            throw new UsernameTakenException(registrationDTO.getUsername());
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword1()));
        user.setAdmin(false);
        return this.userService.saveUser(user);
    }
}

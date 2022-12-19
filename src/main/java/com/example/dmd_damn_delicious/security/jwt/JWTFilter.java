package com.example.dmd_damn_delicious.security.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.dmd_damn_delicious.security.SecurityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    private final SecurityService securityService;

    @Value("${jwt.cookieName}")
    private String jwtCookieName;

    @Autowired
    public JWTFilter(JWTUtil jwtUtil, SecurityService securityService) {
        this.jwtUtil = jwtUtil;
        this.securityService = securityService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            final String token = getJWTFromCookie(request);
            if (token != null && !token.isEmpty()) {
                final String username = jwtUtil.validateToken(token);
                UserDetails userDetails = securityService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (JWTVerificationException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
        }

        filterChain.doFilter(request, response);
    }

    private String getJWTFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(jwtCookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}

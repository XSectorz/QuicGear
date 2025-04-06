package com.xsectorz.quicgear.config;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.xsectorz.quicgear.controller.AuthController;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserAuthProvider userAuthProvider;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if ((request.getRequestURI().equals("/api/v1/login") || request.getRequestURI().equals("/api/v1/register")) && "POST".equals(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }
    
        if (header != null) {
            String[] authElements = header.split(" ");
    
            if (authElements.length == 2 && "Bearer".equalsIgnoreCase(authElements[0])) {
                try {
                    if ("GET".equals(request.getMethod())) {
                        SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(authElements[1]));
                    } else {
                        SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateTokenStrongly(authElements[1]));
                    }
                } catch (RuntimeException e) {
                    logger.error("Token validation failed", e);
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }
    
        filterChain.doFilter(request, response);
    }

}

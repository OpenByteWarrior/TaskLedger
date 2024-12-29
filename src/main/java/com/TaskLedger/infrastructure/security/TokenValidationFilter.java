package com.TaskLedger.infrastructure.security;

import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.application.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.util.Locale;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class TokenValidationFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;
    private final AuthService tokenValidationService;
    private final MessageSource messageSource;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        Locale locale = request.getLocale();
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            sendErrorResponse(response, messageSource.getMessage("error.token.required", null, locale));
            return;
        }

        String token = authHeader.substring(7);

        try {
            boolean isValid = tokenValidationService.validateToken(token, locale);
            if (isValid) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(null, null, null);
                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);
            } else {
                sendErrorResponse(response, messageSource.getMessage("error.token.invalid", null, locale));
            }
        } catch (Exception e) {
            sendErrorResponse(response, messageSource.getMessage("error.token.validating",null,locale) + e.getMessage());
        }
    }
    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        ResponseHttpDTO errorResponse = new ResponseHttpDTO(HttpStatus.UNAUTHORIZED, message);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}
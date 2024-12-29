package com.TaskLedger.application.service;

import com.TaskLedger.infrastructure.client.AuthClient;
import com.TaskLedger.infrastructure.dto.ResponseAuth;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
@CircuitBreaker(name = "authService", fallbackMethod = "tokenValidationFallback")
public class AuthService {

    private final MessageSource messageSource;
    private final AuthClient authClient;

    public boolean validateToken(String token, Locale locale) {
        ResponseAuth response = authClient.validateToken(token , locale);
        if (response != null && response.getResponse() != null) {
            return (Boolean) response.getResponse();
        }

        return false;
    }

    public boolean tokenValidationFallback(String token,Locale locale, Throwable e) {
        log.info(messageSource.getMessage(
                "error.token.validating",
                new Object[]{token, e.getMessage()},
                locale
        ));
        return false;
    }
}

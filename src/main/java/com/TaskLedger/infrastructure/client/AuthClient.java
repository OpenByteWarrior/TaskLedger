package com.TaskLedger.infrastructure.client;

import com.TaskLedger.infrastructure.dto.ResponseAuth;  // Cambiar la importación
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthClient {
    private final RestTemplate restTemplate;
    private final MessageSource messageSource;

    public ResponseAuth validateToken(String token , Locale locale) {
        String authServerUrl = "http://localhost:8081";
        String url = authServerUrl + "/api/auth/validate";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        Map<String, String> body = new HashMap<>();
        body.put("token", token);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<ResponseAuth> response = restTemplate.exchange(
                    url, HttpMethod.POST, requestEntity, ResponseAuth.class);
            log.info(messageSource.getMessage(
                    "log.auth.success",
                    new Object[]{Objects.requireNonNull(response.getBody()).getResponse()},
                    locale
            ));
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                log.warn(messageSource.getMessage(
                        "log.auth.forbidden",
                        new Object[]{token,e.getMessage()},
                        locale
                ));
                return null;
            }
            throw new RuntimeException(messageSource.getMessage(
                    "error.auth.service",
                    null,
                    locale
            ) + ": " + e.getMessage(), e);
        }
    }
}

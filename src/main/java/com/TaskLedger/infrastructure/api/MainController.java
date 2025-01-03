package com.TaskLedger.infrastructure.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class MainController {

    private final MessageSource messageSource;

    @GetMapping("/test")
    public String hello(Locale locale) {
        return messageSource.getMessage("info.admin.message", null, locale);
    }
}

package com.TaskLedger.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCustomerDTO{
    private UUID id;
    private String name;
    private String identificationType;
    private String identifier;
}

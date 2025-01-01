package com.TaskLedger.application.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private String name;
    private String description;
    private String identificationType;
    private String identifier;
    private String category;
}

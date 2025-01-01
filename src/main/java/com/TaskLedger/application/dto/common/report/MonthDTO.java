package com.TaskLedger.application.dto.common.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthDTO {
    private UUID id;
    private String name;
    private Integer number;
    private List<DayDTO> days;
}

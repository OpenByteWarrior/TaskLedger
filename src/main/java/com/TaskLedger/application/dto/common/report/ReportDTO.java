package com.TaskLedger.application.dto.common.report;

import com.TaskLedger.application.dto.common.employee.EmployeeDTO;
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
public class ReportDTO {
    private UUID id;
    private Integer year;
    private EmployeeDTO employee;
    private List<MonthDTO> months;
}

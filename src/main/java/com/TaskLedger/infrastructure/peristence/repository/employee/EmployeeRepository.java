package com.TaskLedger.infrastructure.peristence.repository.employee;

import com.TaskLedger.infrastructure.peristence.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}

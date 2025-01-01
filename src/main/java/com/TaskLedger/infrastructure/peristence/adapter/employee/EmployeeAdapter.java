package com.TaskLedger.infrastructure.peristence.adapter.employee;

import com.TaskLedger.domain.EmployeeGateway;
import com.TaskLedger.infrastructure.peristence.entity.employee.Employee;
import com.TaskLedger.infrastructure.peristence.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EmployeeAdapter implements EmployeeGateway {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        employeeRepository.deleteById(id);
    }
}

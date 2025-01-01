package com.TaskLedger.infrastructure.peristence.repository;

import com.TaskLedger.infrastructure.peristence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer,UUID> {
}

package com.TaskLedger.infrastructure.peristence.repository;

import com.TaskLedger.infrastructure.peristence.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}

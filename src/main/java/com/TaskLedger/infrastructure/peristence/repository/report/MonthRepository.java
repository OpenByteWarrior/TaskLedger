package com.TaskLedger.infrastructure.peristence.repository.report;

import com.TaskLedger.infrastructure.peristence.entity.report.Month;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonthRepository extends JpaRepository<Month, UUID> {
}

package com.TaskLedger.infrastructure.peristence.repository.report;

import com.TaskLedger.infrastructure.peristence.entity.report.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DayRepository extends JpaRepository<Day, UUID> {
}

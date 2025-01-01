package com.TaskLedger.infrastructure.peristence.repository.report;

import com.TaskLedger.infrastructure.peristence.entity.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}
